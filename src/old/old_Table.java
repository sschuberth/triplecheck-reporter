/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-17T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Table.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Eases the creation of HTML tables </text> 
 */

package old;


/**
 *
 * @author Nuno Brito, 17th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class old_Table {

    
    String 
            headerOutput,
            footerOutput;
    
    int size = 0;
    
    String
            color1 = "<td style=\"font-family: Arial;\">",
            color2 = "<td style=\"font-family: Arial; background-color: rgb(219, 229, 241);\">";
    
    Boolean alternate = true;
    //ArrayList<String[]> items = new ArrayList();
    
    String 
            itemData = "",
            headerData = "";
    
    
    /**
     * Creates a simplified table where the two elements are centered
     * @param value1
     * @param size1
     * @param value2
     * @param size2
     * @return 
     */
    public static String simple(String value1, int size1, String value2, int size2){
        return "<table style=\"text-align: left; \" border=\"0\"\n" +
                " cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"width: " + size1 + "px;\">"
                + value1
                + "</td>\n" +
                "      <td style=\"width: " + size2 + "px;\">"
                + value2
                + "</td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>";
    }
    
    /**
     * Public constructor, important to define the array
     * @param header 
     */
    public old_Table(String[] header){
        size = header.length;
        String result = "";
        
        for(String item : header){
            result += //"<th>"
                    "<th style=\"text-align: left; color: rgb(31, 73, 125); "
                    + "font-weight: bold; font-family: Arial;\">"
                    + item 
                    + "</th>";
        }
        // do the header
        headerData = "<tr>"
                + result
                + "</tr>";
    }
    
 
       
    /**
     * Public constructor, important to define the array
     * @param header 
     * @param length 
     */
    public old_Table(String[] header, int[] length){
        size = header.length;
        String result = "";
        int i = -1;
        for(String item : header){
            i++;
            result += //"<th>"
                    "<th style=\"text-align: left; color: rgb(31, 73, 125); "
                    + "width: " + length[i] + "px; "
                    + "font-family: Arial;\">"
                    + item 
                    + "</th>";
        }
        // do the header
        headerData = "<tr>"
                + result
                + "</tr>";
    }
    
    
    /**
     * Creates single table fully aligned horizontally with a single line
     * @param params an array with text values
     * @param size the size for each column
     * @return the text in HTML format
     */
    public static String alignedTable(String[] params, int[] size){
        // add the header
        String result = "<table style=\"text-align: left;\" border=\"0\"\n" +
" cellpadding=\"1\" cellspacing=\"1\"><tbody><tr>";
        int i = -1;
        for(String param : params){
            i++;
            result += "<td style=\"width: "
                    + size[i]
                    + "px; vertical-align: top;\">"
                    + param
                    + "</td>"
                    ;
        }
        // add the footer
        result += "</tr></tbody></table>";

        
        return result;
    }
    
    /**
     * Add this item to our table list
     * @param item the data that we want to fill our list with
     */
    public void add(String[] item){
        // we need items with the same size as available columns
        if(item.length != size){
            System.err.println("TB001 - Column sizes don't match: ["
                    + utils.text.arrayToString(item, "], [")+ "]");
            return;
        }
        // all good, add up this item
        //items.add(item);
        itemData += "<tr>";
        String color;// = color1;
        // do the color switching
        if(alternate){
           color = color2;
           alternate = false;
        }else{
            color = color1;
            alternate = true;
        }
        
            // go through each column
            for(String text : item){
                itemData += color
                        //+ "<small>"
                        + text
                        //+ "</small>"
                        + "</td>";
            }
        itemData += "</tr>";
    }
    
    
    /**
     * Provides the output of this table along with its data
     * @return 
     */
    public String output(){
        String result;
        
        // do the header
        result = "<table style=\"text-align: left; width: 5px;\" border=\"0\""
                + "cellpadding=\"2\" cellspacing=\"2\">"
                + "<tbody>";

        
        result += 
                  headerData
                + itemData;
//        // now add up our items
//        for(String[] item : items){
//            result += "<tr>";
//            // go through each column
//            for(String text : item){
//                result += "<td align=\"undefined\" valign=\"undefined\">"
//                        + text
//                        + "</td>";
//            }
//            result += "</tr>";
//        }
        // add the closing part of the code
        result += "</tbody></table>";
        // all done
        return result;
    }
}
