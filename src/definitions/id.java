/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-08-29T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: id.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> For each SPDX document, declare constant ID value </text> 
 */
package definitions;

public enum id {
    SOURCEFOLDER; // from where have the source files been indexed?
    
    @Override
    public String toString() {
       String result = this.name() + "---";
               //.toLowerCase();
       return result;
    }
}
