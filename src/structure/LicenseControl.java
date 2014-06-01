/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-26T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: LicenseControl.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows to handle the registered licenses </text> 
 */

package structure;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.TreeviewUtils;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.tree.DefaultTreeModel;
import main.core;
import script.exec;
import script.log;
import spdxlib.FileInfo2;
import spdxlib.License;
import spdxlib.LicenseType;
import spdxlib.SPDXfile2;
import utils.html;


/**
 *
 * @author Nuno Brito, 26th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class LicenseControl {

    /**
     * Public constructor
     */
    public LicenseControl(){
        launchThreadedStart();
    }
    
        
    private static final ArrayList<License> list = new ArrayList();
    
    private boolean hasNotProcessed = true;
    
    public void add(License license) {
        list.add(license);
    }

    
    public ArrayList<License> getList() {
        // only provide back a list after the licensing processing was made
        if(list.isEmpty() && hasNotProcessed){
            find();
        }
        return list;
    }
    
     /**
     * Add up all the extensions that we have available on disk
     */
    public void find() {
        if(hasNotProcessed == false){
            return;
        }
        // clear up the list to avoid duplicates
        File folder = core.getLicensesFolder();
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".java", 2);
        log.write(is.INSTALLING, "Processing %1 licenses", "" + files.size());
        for(File file : files){
            //core.script.runJava(file, null, is.license);
            License license = (License) exec.runJava(file, is.license);
                //utils.bytecode.getObject(file);
            if(license != null && license.getId().isEmpty() == false){
                list.add(license);
            }
        }
        // output some statistics about the number of extensions registered
        log.write(is.COMPLETED, "Licenses recognized: %1", "" + list.size());
        //System.err.println("LC85 - Found licenses: " + files.size() + "");
        //TODO we are still listing the template class as a file type.
        hasNotProcessed = false;
    }

    /**
     * Returns a given license object in our list. If it does not exist,
     * the result will be null
     * @param licenseId     Typically the SPDX identifier
     * @return              A License object
     */
    public License get(String licenseId) {
        for(License license : list){
            if(utils.text.equals(licenseId, license.getId())){
                return license;
            }
        }
        return null;
    }

    /**
     * When given a search term, looks inside our archived licenses and provides
     * a list with possible results
     * @param searchTerm    Portion of text to be found
     * @param link          The URL link that permits selecting a license
     * @return              HTML code ready to display to the user
     */
    public String search(String searchTerm, final String link) {
        
        String result, // the end result
                rankFirst = "", // results to be listed on top
                rankSecond = ""; // the secondary results

        // place the term in second position
        searchTerm = searchTerm.toLowerCase();
        
        // go through each found license
        for(License license : list){
            boolean hasRankedFirst = false;
            
            // look on the ids
            if(license.getId().toLowerCase().contains(searchTerm)){
                rankFirst += license.getPrettyText("choose", link + license.getId());
                hasRankedFirst = true;
                continue;
            }
            
            // look inside the text
            if(license.getTerms().toLowerCase().contains(searchTerm)){
                // no need to repeat the result if already ranked
                if(hasRankedFirst){
                    continue;
                }
                rankSecond += license.getPrettyText("choose", license.getId());
                //continue;
           }
        }
        
        // add the titles where needed
        if(rankFirst.length() > 0){
            rankFirst = html.h3("Matching title")
                    + rankFirst;
        }
        // add the titles where needed
        if(rankSecond.length() > 0){
            rankSecond = html.h3("Inside the license terms")
                    + rankSecond;
        }
        // add up the results
        result = html.div() 
                + rankFirst 
                + rankSecond
                + html._div;
        // all done
        return result;
    }

    /**
     * Have we already tried to look for licenses at least once?
     * @return 
     */
    public boolean hasNotProcessed() {
        return hasNotProcessed;
    }

    /**
     * We launch after a few second a thread that will automatically index
     * the licenses available on this machine
     */
    private void launchThreadedStart() {
               // launch a small thread to keep the progress updated
               Thread thread = new Thread(){
                   @Override
                   public void run(){
                       // wait a little bit for things to start
                       utils.time.wait(2);
                       find(); 
                   }
            };
    }
    
    
    /**
     * This method will change the declared license for a group of files.
     * It requires a list of the Id's that will be modified and a registered
     * license.
     * @param listUID   A string array where each element is a separate UID
     * @param license   A license from our list of available licenses
     */
    public void changeDeclaredLicense(String[] listUID, License license){
        // we have a list of UID, now we need to convert these onto
        // real objects.
        
        // create the list that will host the real nodes
        ArrayList<TreeNodeSPDX> nodeList = new ArrayList();
        // now iterate each array member to get the respective object
        for(String UID : listUID){
            // get the node
            TreeNodeSPDX node = TreeviewUtils.getNode(UID);
            // add to our list
            nodeList.add(node);
        }
        
        
        // on this operation we need to account that an end-user might choose
        // nodes from different SPDX documents, therefore we need to split these
        HashMap<String, ArrayList<FileInfo2>> spdxList = new HashMap();
        // now iterate each node and split them into respective SPDX
        for(TreeNodeSPDX node : nodeList){
            FileInfo2 fileInfo = (FileInfo2) node.getUserObject();
            // we use the id as unique identifier
            final String id = fileInfo.getSPDX().getId();
            if(spdxList.containsKey(id)){
                spdxList.get(id).add(fileInfo);
            }else{
                // didn't existed before, create a list for this spdx
                ArrayList<FileInfo2> thisList = new ArrayList();
                thisList.add(fileInfo);
                spdxList.put(id, thisList);
            }
        }
        
        // now that we splitted all the fileInfo, it is time to write them
        for(ArrayList<FileInfo2> fileInfoList : spdxList.values()){
            // get the SPDX object
            SPDXfile2 spdx = fileInfoList.get(0).getSPDX();
            // write the lines for this list
            spdx.writeLines(fileInfoList, is.tagLicenseConcluded, license.getId(), true);
            // after writing the changes to disk, it is time to update the nodes
            for(FileInfo2 fileInfo : fileInfoList){
                fileInfo.setLicenseConcluded(LicenseType.convertToEnum(license.getId()));
            }
        }
        
        // finish by updating the nodes on the treeview
        for(TreeNodeSPDX node : nodeList){
            if(node.nodeType != NodeType.file){
                continue;
            }
            DefaultTreeModel model = (DefaultTreeModel) 
                    core.studio.getTree().getModel();
            model.nodeChanged(node);
        }
        
        
        
    }
    
    
}