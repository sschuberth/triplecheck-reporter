/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-20T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: Messages.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines a set of messages to be used between 
 * different classes with a specific text message. This way we can change 
 * the content of the text without worrying about changing the text on
 * each class that references them.</text> 
 */

package definitions;


/**
 *
 * @author Nuno Brito, 20th of September 2013 in Darmstadt, Germany.
 */
public class Messages {

    
    public static String
            ReadyToUse = "Program is ready to use",
            AddingTools = "Adding tools",
            AddedPlugin = "Added plugin: %1",
            
            GainedFocusOnTextBox = "Gained focus on Text Box",
            LostFocusOnTextBox = "Lost focus on Text Box",
            
            GainedFocusOnTreeBox = "Gained focus on Tree Box",
            LostFocusOnTreeBox = "Lost focus on Tree Box",
            
            TextWasModified = "Text was modified",
            TextWasLoaded = "Text was loaded",
            
            TreeNodeChanged = "Tree node changed: %1",
            TreeNodeDoubleClick = "Tree node doubleclick on: %1",
            
            GainedFocusOnSearchBox = "Gained focus on Search Box",
            LostFocusOnSearchBox = "Lost focus on Search Box",
    
            ClickedOnTree = "Clicked on Tree",
            ClickedOnLibraryComponent = "Clicked at a library component",
            
            // search box related
//            SearchBoxPressedENTER = "Pressed ENTER on search box",
            SearchBoxPressedKey = "Pressed KEY on search box",
            SearchBoxPressedESCAPE = "Pressed ESCAPE on search box",
//            SearchBoxLicenseSelect = "Looking to select a license on the search box",
//            SearchBoxLicenseSearch = "Searching for a specific a license",
            
            NodeSelected = "Node Selected: %1",
            RefreshSPDX = "Refreshed the list of SPDX documents",
            CallFrontScreen = "All done, showing main window";
}
