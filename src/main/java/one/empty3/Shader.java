package one.empty3;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.*
/***
 * vn(int n)
 * vn(vn...)
 * vn(double... ) 
  * glsl light. like.
  *
  * where the rapers shit go?
 */
public class Shader{
   class SymbolTreeNode {
        String name;
        Items kind;
        SymbolTreeNode children;
   } 
   class Tree {
  SymbolTreeNode root;
  Iterator<SymbolTreeNode> iterate(){return null;}

     enum Items {Comment, Macro, FunctionDeclaration, FunctionBody, MemberVariable, ClassDeclaration, VariableName, VariableType, Literal, Scalar, ClassName}
    class Comment extends SymbolTreeNode{
     enum Type { Line, Block, Doc }
     String text;
    }
    class Macro extends SymbolTreeNode{ 
        enum Type { Macro, Include }
        String name;
        String def;
    }
    class Class extends SymbolTreeNode{}
 
 
    public boolean splitInTypes(String shStr) {
     int i = 0;
     int posTry = -1;
         while(i<shStr.length) {
             char ch = shStr.charAt(i);
             if(ch=='#') {i = readMacro(shStr, i+1);continue;}
             do { 
                 i = readKeyword(shStr, i);

              } while(i>=0)
             i = readType(shStr, i) ;
             i = readIdentifier(shStr, i);
             
              
             
              
              
             
             switch(root.current.itemType) {
               case Items.Class:
                   i = parseExtend(shStr);
                   break;
               case Items.Function:
                   i = parseArgumentList(shStr, i) ;
                   break;
               case Items.Variable:
                   i = parseExpr(shStr) ;
                   break;
               
              } 
                

             

         }
     return true;
    }
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
