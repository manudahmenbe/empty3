package one.empty3;
import java.io.File;
import java.nio.file.*;
import java.awt.image.BufferedImage;
import java.util.*;
/***
 * vn(int n)
 * vn(vn...)
 * vn(double... ) 
  * glsl light. like.
  *
 * chaque token doit etre identifie a
 * un type
 */

public class Shader{
   class SymbolTreeNode {
        String name;
        Items itemType;
        String text;
        Object jValue;
        SymbolTreeNode children;
   } 
   class Tree {
       SymbolTreeNode root;
       Iterator<SymbolTreeNode> iterate(){return null;}
       SymbolTreeNode current;
   }
 enum Type { Line, Block, Doc }
     enum Items {Comment, Macro, Function, FunctionDeclaration, FunctionBody, MemberVariable, ClassDeclaration, VariableName, VariableType, Literal, Scalar, ClassName}
    class Comment extends SymbolTreeNode{
     
     String text;
    }
      enum MacroType { Macro, Include }
    class Macro extends SymbolTreeNode{ 
   
        String name;
        String def;
    }
    class Class extends SymbolTreeNode{}
    public int readBlank(String shStr, int i) {
        int j = 0;
        while(Character.isWhitespace(shStr.charAt(i))||shStr.charAt(j)=='\t'||shStr.charAt(j)=='\n' 
             ||shStr.charAt(j)=='\r') {
             j++;
         }
         return j;
    }
    public int readChar(String shStr, char c, int i) {
        return shStr.charAt(i)==c?i+1:i;
    }
    public int readComment(String shStr , int i) {
        if(shStr.charAt(i)=='/') {
            i++;
            if(shStr.charAt(i)=='/') {
                while(shStr.charAt(i)!='\n')
                    i++;
                return i;
             }
            if(shStr.charAt(i)=='*') {
                i++;
                while(i<shStr.length()-1 && shStr.charAt(i)!='*' && shStr.charAt(i+1)=='/') {
                    i++;
                }
                i++;
                return i;
            }
        }
        return i;
   }
 enum LiteralType {S, D, L, I, F, O, }
    class Literal {
         
         
    }
    
     public int parseString(String shStr, int i){
         if(shStr.charAt(i)=='\"') {
              i++;
              while(shStr.charAt(i)!='\"') {
                  if(shStr.charAt(i)=='\\') 
                      i++;
                  i++;
              }
         }
         return i;
     }
     public int parseInt(String shStr, int i){
          return i;

         }
     public int parseFloat(String shStr, int i){
          return i;
          
         }
     public int parseDouble(String shStr, int i){
          return i;
          
     }
    public int readContainer(String shStr, int i) {
         return i;
    }
    public int readLiteral(String shStr, int i) {
         i = parseString(shStr, i);
         i = parseInt(shStr, i);
         i = parseFloat(shStr, i);
         i = parseDouble(shStr, i);
         return i;
    }
    public int parseArgumentList(String shStr, int i) {
          return i;
    
    }
    public int parseMethodBody(String shStr, int i) {
          return i;
         
    }
    public int readEquals(String shStr, int i) {
          return i;
    }
    public int readOperation(String shStr, int i){
          return i;
    }
    public int readMethodCall(int i){
          return i;
    }
    public List<String> split(String shStr) {
     
         List<String> lines = new ArrayList<>();
        int i= 0;
        int j= 0;
        while(j!=i) {
            j = readBlank(shStr, i);
        if(j==i)
           j = readComment(shStr, i);
       else
           lines.add(shStr.substring(i , j ));
       if(j==i)
           j = parseString(shStr, i);
       else
           lines.add(shStr.substring(i, j));
       if(j==i)
           j = readToken(shStr, i);
       else
           lines.add(shStr.substring(i, j));
       if(j!=i)
           return null;
       }
       return lines;
    }
    
    public int readMacro(String shStr, int i) {
        return i;
    }
    
    
    public int readToken(String shStr, int i) {
        while(i<shStr.length()&&readBlank(shStr, i)==i)
            i++;
        return i;
    }
    public void buildTree(List<String> lines) {
    }
    public boolean splitInTypes(String shStr) {
     int i = 0;
     List<String> lines = split(shStr);
     int posTry = -1;
     buildTree(lines);


            
           
             
   
                

             

         
     return true;
    }
    List<String> shaderFiles = new ArrayList<>();
    
    public Shader(File fileOrDirectory) {
         if(fileOrDirectory.isDirectory()) 
             for(String sf : fileOrDirectory.list()) {
                  try {
                      File f = new File(fileOrDirectory.getAbsolutePath()+File.separator+sf);
                      String shStr = stripComment(new String(Files.readAllBytes(Paths.get(f.getAbsolutePath()))));
                      splitInTypes(shStr);
                      //  shStr = replaceMacro(shStr);
                   } catch(IOException ex) {
                       ex.printStackTrace();
                  
             }
    }
    public void setOutput(File directory) {}
    public void shaders(File file) {}
    
    public String stripComment(String brut){
         return brut;
    }
   public String replaceMacro(String shStr) {
    return shStr;
   }
 //   public String categoriser(String contentStripped) {}
//    public String parseHeaders() {}
 //   public String parseMemberVars() {}
  //  public String parseClass() {}
   // public String parseMemberMethod() {}
//    public String parseMethodDeclaration(String name, Object... arguments) {}
 //   public String parseMethodImplementation() {}
    
    public void runCode() {}
    public BufferedImage getOutput() {
    return null;
    }
}

