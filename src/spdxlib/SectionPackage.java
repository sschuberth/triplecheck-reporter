  /*
   * SPDXVersion: SPDX-1.1
   * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
   * Creator: Organization: TripleCheck (contact@triplecheck.de)
   * Created: 2013-08-29T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
   * FileName: SectionPackage.java  
   * FileType: SOURCE
   * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
   * FileComment: <text>Class to define the properties of the SPDX 1.1 SectionPackage
   * Infomation field</text> 
   */

package spdxlib;

import experiment.FileInfo2;
import java.io.Serializable;
import java.util.ArrayList;



public class SectionPackage implements Serializable {

    public TagValue
            name, // formal name of the package, mandatory, one
            version, // optional, one
            fileName; // filename of the compressed file, optional, one
    
    public Person
            supplier = new Person(), // organization and author, optional, one
            originator = new Person();// only if supplier differs, optional, one
            
    public TagValue
            // Data Format: uniform resource locator | ”NONE” | “NOASSERTION” 
            downloadLocation, // where it can be downloaded, mandatory, one
            // Data Format: 160 bit binary represented as 40 hexidecimal digits 
            verificationCode, // special calculation routine, mandatory, one
            checksum, // SHA1 checksum of the package, optional, one
            sourceInfo, // other info about the origin, optional, one
            licenseConcluded; // the overall licensing terms, mandatory, one
    
    public ArrayList<TagValue>// list the licenses collected from the files included
            licenseInfoFromFiles = new ArrayList(); // mandatory, one or many        
   
    public TagValue  //TODO attention to be given on multiple/disjunctive licenses
            licenseDeclared, // license declared by author, mandatory, one
            licenseComments, // other info about the origin, optional, one
            copyrighText, // report date/copyrights applicable, mandatory, one
            summary, // summarize use or function of package, optional, one
            description; // detail use or function of package, optional, one
    
    public ArrayList<FileInfo2> // information about all files present on the package
            files = new ArrayList(); // mandatory, one or many        
   
    
    public ArrayList<TagValue> // tags not recognized
            unknown = new ArrayList(); // mandatory, one or many        
   
    
    // non-standard data
    public ArrayList<TagValue>// list the dependencies for this SPDX document
            dependencies = new ArrayList(); // optional, one or many   
   
    public boolean parseTag(TagValue tag){
        // only process tags starting with "Creat"
        if((tag.title.length() < 7)
                || (!tag.title.substring(0, 7).equalsIgnoreCase("Package"))){
            return false;
        }
        
        if(tag.title.equalsIgnoreCase("PackageName")){
            this.name = tag;
            return true;
        }

        if(tag.title.equalsIgnoreCase("PackageVersion")){
            this.version = tag;
            return true;
        }

        if(tag.title.equalsIgnoreCase("PackageFileName")){
            this.fileName = tag;
            return true;
        }

        if(tag.title.equalsIgnoreCase("PackageSupplier->Person")){
            supplier.setTagPerson(tag);
            return true;
        }
        if(tag.title.equalsIgnoreCase("PackageSupplier->Organization")){
            supplier.setTagOrganization(tag);
            return true;
        }
        if(tag.title.equalsIgnoreCase("PackageSupplier->Tool")){
            supplier.setTagTool(tag); 
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("PackageOriginator->Person")){
            originator.setTagPerson(tag);
            return true;
        }
        if(tag.title.equalsIgnoreCase("PackageOriginator->Organization")){
            supplier.setTagOrganization(tag);
            return true;
        }
        if(tag.title.equalsIgnoreCase("PackageOriginator->Tool")){
            supplier.setTagTool(tag);
            return true;
        }

        if(tag.title.equalsIgnoreCase("PackageDownloadLocation")){
            this.downloadLocation = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("PackageVerificationCode")){
            this.verificationCode = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("PackageChecksum->SHA1")){
            this.checksum = tag;
            return true;
        }
       
        if(tag.title.equalsIgnoreCase("PackageSourceInfo")){
            this.sourceInfo = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("PackageLicenseConcluded")){
            this.licenseConcluded = tag;
            return true;
        }
        
        if(tag.title.equalsIgnoreCase("PackageLicenseInfoFromFiles")){
            this.licenseInfoFromFiles.add(tag);
            return true;
        }
       
        if(tag.title.equalsIgnoreCase("PackageLicenseDeclared")){
            this.licenseDeclared = tag;
            return true;
        }
       
        if(tag.title.equalsIgnoreCase("PackageLicenseComments")){
            this.licenseComments = tag;
            return true;
        }
        
        
        if(tag.title.equalsIgnoreCase("PackageCopyrightText")){
            this.copyrighText  = tag;
            return true;
        }

        if(tag.title.equalsIgnoreCase("PackageSummary")){
            this.summary = tag;
            return true;
        }
       
        if(tag.title.equalsIgnoreCase("PackageDescription")){
            this.description = tag;
            return true;
        }
        
        // non-standard data
        if(tag.title.equalsIgnoreCase("PackageDependency")){
            this.dependencies.add(tag);
            return true;
        }
    
        // we found some tags that is unknown
        unknown.add(tag); // add it for future processing
        System.out.println("Unknown package tag found: " 
                + tag.title + " = " + tag);
        // nothing found, return false
        return false;
    }
    
    /**
     * This method is used by tree nodes
     * @return 
     */
    @Override
    public String toString(){
        return "Package";
    }
}
