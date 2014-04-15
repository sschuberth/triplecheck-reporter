  /*
   * SPDXVersion: SPDX-1.1
   * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
   * Creator: Organization: TripleCheck (contact@triplecheck.de)
   * Created: 2013-08-29T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
   * FileName: Keyword.java  
   * FileType: SOURCE
   * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
   * FileComment: <text>Static definitions for the SPDX format</text> 
   */

package spdxlib;



public enum Keyword {
    // section #3 - generic document
    SPDXVersion,
    DataLicense,
    DocumentComment,
    Creator,
        Person,
        Organization,
        Tool,
    Created,
    CreatorComment,
    // section #4 - package details
    PackageName,
    PackageVersion,
    PackageFileName,
    PackageSupplier,
        // person details
    PackageOriginator,
        // person details
    PackageDownloadLocation,
    PackageVerificationCode,
    PackageChecksum,
    PackageSourceInfo,
    PackageLicenseConcluded,
    PackageLicenseInfoFromFiles,
    PackageLicenseDeclared,
    PackageLicenseComments,
    PackageCopyrightText,
    PackageSummary,
    PackageDescription,
    
    // section #5 - other licensing details
        LicenseID,
        ExtractedText,
        LicenseName,
        LicenseCrossReference,
        LicenseComment,
   
    // section #6 - information about the files
        FileName,
        FileType,
        FileChecksum,
            SHA1,
        LicenseConcluded,
        LicenseInfoInFile,
        LicenseComments,
        FileCopyrightText,
        ArtifactOfProjectName,
        ArtifactOfProjectHomePage,
        ArtifactOfProjectURI,
        FileComment,
   // section #7 - review information
   Reviewer,
   ReviewDate,
   ReviewComment
}
