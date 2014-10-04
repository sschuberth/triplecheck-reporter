package utils_deprecated;

import java.io.File;
import java.io.IOException;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;

public class ExtractExample {
	
        public static void main(String[] args) throws IOException{
            
            File archive = new File("/home/nuno/source/tool/run/downloads/jfreechart-1.0.17.tar.gz");
            File destination = new File("/home/nuno/source/tool/run/downloads/output/");

            Archiver archiver = ArchiverFactory.createArchiver("tar", "gz");
            archiver.extract(archive, destination);
            
           
        }
        
	
}