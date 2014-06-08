/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-08T20:39:01Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: zip.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> 
 * Copyright 2014 Nuno Brito, TripleCheck 
 * Copyright 2012 Robin Spark  
 * </text>
 * FileComment: <text> Zip and unzip routines </text> 
 */

package ThirdParty;

import java.io.*;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author Nuno Brito, 8th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class zip {

    /**
     * Creates a zip file at the specified path with the contents of the specified directory.
     * @param directoryPath The path of the directory where the archive will be created. eg. c:/temp
     * @param zipPath The full path of the archive to create. eg. c:/temp/archive.zip
     * @throws IOException If anything goes wrong
     * @origin http://developer-tips.hubpages.com/hub/Zipping-and-Unzipping-Nested-Directories-in-Java-using-Apache-Commons-Compress
     * @date 2012-09-05
     * @author Robin Spark
     */
    public static void createZip(File directoryPath, File zipPath) throws IOException {
        FileOutputStream fOut = null;
        BufferedOutputStream bOut = null;
        ZipArchiveOutputStream tOut = null;
 
        try {
            fOut = new FileOutputStream(zipPath);
            bOut = new BufferedOutputStream(fOut);
            tOut = new ZipArchiveOutputStream(bOut);
            addFileToZip(tOut, directoryPath, "");
        } finally {
            tOut.finish();
            tOut.close();
            bOut.close();
            fOut.close();
        }
 
    }
 
    /**
     * Creates a zip entry for the path specified with a name built from the base passed in and the file/directory
     * name. If the path is a directory, a recursive call is made such that the full directory is added to the zip.
     *
     * @param zOut The zip file's output stream
     * @param path The filesystem path of the file/directory being added
     * @param base The base prefix to for the name of the zip file entry
     * @origin http://developer-tips.hubpages.com/hub/Zipping-and-Unzipping-Nested-Directories-in-Java-using-Apache-Commons-Compress
     * @date 2012-09-05
     * @author Robin Spark
     * @throws IOException If anything goes wrong
     */
    private static void addFileToZip(ZipArchiveOutputStream zOut, File path, String base) throws IOException {
        File f = path;
        String entryName = base + f.getName();
        ZipArchiveEntry zipEntry = new ZipArchiveEntry(f, entryName);
 
        zOut.putArchiveEntry(zipEntry);
 
        if (f.isFile()) {
            FileInputStream fInputStream = null;
            try {
                fInputStream = new FileInputStream(f);
                IOUtils.copy(fInputStream, zOut);
                zOut.closeArchiveEntry();
            } finally {
                IOUtils.closeQuietly(fInputStream);
            }
 
        } else {
            zOut.closeArchiveEntry();
            File[] children = f.listFiles();
 
            if (children != null) {
                for (File child : children) {
                    addFileToZip(zOut, child, entryName + "/");
                }
            }
        }
    }
    
    
    
}
