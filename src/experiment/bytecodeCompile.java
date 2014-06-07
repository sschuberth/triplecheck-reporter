/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-05-24T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: bytecodeCompile.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Beanshell works great for scripting during runtime and
 * for editing from a Java IDE. However, it is noted that scripts are not
 * treated the same in terms of performance when compared to bytecode, this
 * causes a serious delay in processing that we need to solve. The current
 * experiment will compile scripted code to bytecode.</text>
 */

package experiment;

import java.io.File;
import main.core;
import org.codehaus.janino.SimpleCompiler;
import script.FileExtension;
        
        
/**
 *
 * @author Nuno Brito, 11th of May 2014 in Darmstadt, Germany.
 */
public class bytecodeCompile {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
//        File sourceFile = new File(core.getMiscFolder(), "cpp.java");
//        String sourceCode = utils.files.readAsString(sourceFile);
//        SimpleCompiler compiler = new SimpleCompiler();
//        compiler.cook(sourceCode);
//        Class clazz = compiler.getClassLoader().loadClass(buildClassName(sourceCode, sourceFile));
//        FileExtension instance = (FileExtension) clazz.newInstance();
//        
//        System.out.println(instance.getLanguage().toString());
        testPlugin();
        System.exit(555);
    }
    
    
    public static void testPlugin(){
        File scriptFile = new File(core.getMiscFolder(), "home.java");
        utils.bytecode.runJava(scriptFile, "say");
    }
    
    
    /**
     * Given a source code file, this method will try to extract the declared
     * package name in order to build a class name that will be used by the
     * class loader.
     * @param sourceCode
     * @return      The Class name
     */
    static String buildClassName(final String sourceCode, File file){
        // we expect to find the package declaration on the first line
        int index = sourceCode.indexOf(";");
        final String name = "." + file.getName().substring(0, file.getName().indexOf("."));
        // "package " has 8 spaces
        return sourceCode.substring(8, index) + name;
    }
}
