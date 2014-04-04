package basic;

import GUI.Actions;
import GUI.RightClicks;
import definitions.Messages;
import script.Plugin;
import script.log;

/**
 *
 * @author Nuno Brito, 25th of September 2013 in Darmstadt, Germany.
 * nuno.brito@triplecheck.de | http://nunobrito.eu
 *
 */
public class pluginRightClicks extends Plugin {


    @Override
    public void startup(){
//        // trigger to delete a person from the SPDX documents
//        log.hooks.addAction(Messages.ClickedOnTree, thisFile, "processClick");
//        
//        // trigger to add a component to a selected software product 
//        log.hooks.addAction(Messages.ClickedOnLibraryComponent, thisFile, 
//            "processClickOnLibraryComponent");
//        log.hooks.addAction("Single-click at " + Actions.addComponentToProduct, 
//            thisFile, "addComponent");
//
//        // trigger to create a new SPDX
//        log.hooks.addAction("Single-click at New SPDX", thisFile, "newSPDX");
    }

//    void processClick(){
//        // let's warn the end-user about what is going on here
//        RightClicks.processClick();
//    }
//    void processClickOnLibraryComponent(){
//        // let's warn the end-user about what is going on here
//        RightClicks.processClickOnLibraryComponent();
//    }

    void addComponent(){
        // let's warn the end-user about what is going on here
        RightClicks.addComponent();
    }

    void newSPDX(){
        // launch the dialog to create a new SPDX document
        RightClicks.newSPDX();
    }

}