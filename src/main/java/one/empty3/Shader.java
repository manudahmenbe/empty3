package one.empty3;
import java.io.File;
import java.awt.image.BufferedImage;
/***
 * vn(int n)
 * vn(vn...)
 * vn(double... ) 
  * glsl light. like.
  *
  * where the rapers shit go?
 */
public class Shader{
    class enum Items {Comment, Macro, FunctionDeclaration, FunctionBody, MemberVariable, ClassDeclaration, VariableName, VariableType, Literal, Scalar, ClassName}
    class Comment {
     enum Type { Line, Block, Doc }
     String text;
    }
    class Macro { 
        enum Type { Macro, Include }
        String name;
        String def;
    }
    claaa 
    List<String> shaderFiles = new ArrayList<>();
    
    public Shader(File fileOrDirectory) {
         if(fileOrDirectory.isDirectory()) 
             for(File f : fileOrDirectory) {
                  
                  String shStr = stripComment(new String(Files.readAllBytes(Paths.get(f.getAbsolutePath()))));
                  shStr = splitInTypes(shStr);
                  shStr = replaceMacro(shStr);
                  
             }
    }
    public void setOutput(File directory) {}
    public String shaders(File file) {}
    
    public String stripComment(String brut){
         return brut;
    }
    public String replaceMacro() {}
    public String categoriser(String contentStripped) {}
    public String parseHeaders() {}
    public String parseMemberVars() {}
    public String parseClass() {}
    public String parseMemberMethod() {}
    public String parseMethodDeclaration(String name, Object... arguments) {}
    public String parseMethodImplementation() {}
    
    public void runCode() {}
    public BufferedImage getOutput() {}
}
