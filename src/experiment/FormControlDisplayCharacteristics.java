package experiment;

import net.htmlparser.jericho.*;
import java.util.*;
import java.io.*;
import java.net.*;
import main.core;
import utils_deprecated.Settings;

public class FormControlDisplayCharacteristics {
	public static void main(String[] args) throws Exception {
                     // where we will store and retrieve the settings for this page
    String fileName = "settings.xml";
    File thisFolder = new File(core.getPluginsFolder(), "/webserver");
    File settingsFile = new File(thisFolder, fileName);
    Settings settings = new Settings(settingsFile, "Settings for the "
            + "server");
   
            
		String sourceUrlString="data/form.html";
                
                File webPage = new File(thisFolder, "serverSettings.html");
                sourceUrlString = webPage.getAbsolutePath();
                String webText = utils_deprecated.files.readAsString(webPage);
       
		// instantiate our HTML manipulating class
                Source source =  new Source(webText);
                
                FormFields formFields=source.getFormFields();
                
                // go throught all the saved values and place them on the web page
                Enumeration e = settings.getAllKeys();
                // iterate throught all saved settings
                while (e.hasMoreElements()) {
                    // current key
                    String key = (String) e.nextElement();
                    String value = settings.read(key);
                    formFields.setValue(key, value);
                }
                
                
		// disable some controls:
//		formFields.get("Password").getFormControl().setDisabled(true);
//		formFields.setValue("MailingList","C");
//		formFields.get("MailingList").getFormControl("C").setDisabled(true);
//		formFields.get("MailingList").getFormControl("D").setDisabled(true);
//		// remove some controls:
//		formFields.get("button1").getFormControl().setOutputStyle(FormControlOutputStyle.REMOVE);
//		FormControl rhubarbFormControl=formFields.get("FavouriteFare").getFormControl("rhubarb");
//		rhubarbFormControl.setOutputStyle(FormControlOutputStyle.REMOVE);
//		// set some controls to display value:
//		formFields.setValue("Address","The Lodge\nDeakin  ACT  2600\nAustralia");
//		formFields.get("Address").getFormControl().setOutputStyle(FormControlOutputStyle.DISPLAY_VALUE);
//		formFields.setValue("FavouriteSports","BB");
//		formFields.addValue("FavouriteSports","AFL");
////		formFields.get("FavouriteSports").getFormControl().setOutputStyle(FormControlOutputStyle.DISPLAY_VALUE);
//		OutputDocument outputDocument=new OutputDocument(source);
//		outputDocument.replace(formFields); // adds all segments necessary to effect changes
		// also need to remove label for the removed "rhubarb" radio button:
		// label segment begins at the end of the rhubarb control, and ends at the start of the next control:
//		Segment rhubarbLabelSegment=new Segment(source,rhubarbFormControl.getEnd(),source.getNextTag(rhubarbFormControl.getEnd()).getBegin());
//		outputDocument.remove(rhubarbLabelSegment);
		// also need to remove instructions for favourite sports control which has been set to output display value:
//		Segment instructionsSegment=source.getFirstElement("class","instructions",false).getContent();
//		outputDocument.replace(instructionsSegment,"A comma separated list of favourite sports is shown above");
//
//		// modify stylesheet link since the output file is in a different directory to the input file
//		int cssPathPos=source.toString().indexOf("main.css");
//		outputDocument.insert(cssPathPos,"data/");

//		Writer out=new FileWriter("NewForm.html");
                
            OutputDocument outputDocument = new OutputDocument(source);
            outputDocument.replace(formFields); // adds all segments necessary to effect changes
            String result = outputDocument.toString();
            
            
            System.out.println(result);
                
//		outputDocument.writeTo(out);
//		out.close();
		System.err.println("\nThe form containing new default values has been output to NewForm.html");
		System.err.println("This will open automatically in a web browser after you press a key.");
  }
}
