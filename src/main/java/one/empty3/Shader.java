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
    class Enum Items {Comment, Macro, FunctionDecaration, FunctionBody, MemberVariable, ClassDeclaration, VariableName, VariableType, Literal, Scalar, ClassName}
 
    List<String> shaderFiles = new ArrayList<>();
    
    public Shader(File fileOrDirectory) {
         if(fileOrDirectory.isDirectory()) 
             for(File f : fileOrDirectory) {
                  
                  String shStr = stripComment(new String(Files.readAllBytes(Paths.get(f.getAbsolutePath()))));
                  shStr = splitInTypes();
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
