/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) 
 * Created: 2014-05-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: bytecode.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> With this class we compile source code files into
 * bytecode classes that can be used directly by the application at the same
 * speed as the JVM. This is an improvement over the previous version that was
 * supported by Beanshell and later noted as slow when iterating through cycles
 * called several million times. This way we get the full speed benefit.</text>
 */

package utils;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;

/**
 *
 * @author Nuno Brito, 25th of May in Darmstadt, Germany.
 */
public class bytecode {
    
    /**
     * Given a file on disk, this method will try to convert a source code
     * file into a compiled bytecode class
     * @param sourceFile    Location of the file on disk
     * @return              The compiled object
     */
    public static Object getObject(File sourceFile){
        Class clazz;
        try {
            String sourceCode = utils.files.readAsString(sourceFile);
            SimpleCompiler compiler = new SimpleCompiler();
            compiler.cook(sourceCode);
            clazz = compiler.getClassLoader().loadClass(buildClassName(sourceCode, sourceFile));
            return clazz.newInstance();
            
        } catch (CompileException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
