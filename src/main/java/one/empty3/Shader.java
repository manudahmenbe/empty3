package one.empty3;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.*;
/***
 * vn(int n)
 * vn(vn...)
 * vn(double... ) 
  * glsl light. like.
  *

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
     enum Items {Comment, Macro, Function, FunctionDeclaration, FunctionBody, MemberVariable, ClassDeclaration, VariableName, VariableType, Literal, Scalar, ClassName}
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
    public int readBlank(String shStr, int i) {
        int j = 0;
        while(Character.isWhitespace(shStr.charAt(i))||shStr.charAt(j)=='\t'||shStr.charAt(j)=='\n' 
             ||shStr.charAt(j)=='\r') {
             j++;
         }
         return j;
    }
    public int readChar(String shStr, char c, int i) {
        return sh.charAt(i)==c?i+1:i;
    }
    public int readComment(String shStr , int i) {
        if(shStr.charAt(i)=='/') {
            i++;
            if(shStr.charAt(i)=='/') {
                while(shStr.charAt(i)!=System.lineSeparator)
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
    
    class Literal {
         enum Type {S, D, L, I, F, O, }
         
    }
    
     public int readString(String shStr, int i){
         if(shStr.charAt(i)=='\"') {
              i++;
              while(shStr.charAt(i)=!'\"') {
                  if(shStr.charAt(i)=='\\') 
                      i++;
                  i++;
              }
         }
         return i;
     }
     public int parseInt(shStr, int i){
          return i;

         }
     public int parseFloat(shStr, int i){
          return i;
          
         }
     public int parseDouble(shStr, int i){
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
    public int parseArgumentList(shStr, int i) {
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
    public int readMethodCall(){
          return i;
    }
    public List<String> split(String shStr) {
     
         List<String> lines = new ArrayList<>();
        int i= 0;
        int j= 0;
        while(j!=i) {
        int j = readBlank(shStr, i);
        if(j==i)
           j = readComment(shStr, i);
       else
           j = lines.add(shStr.substring(i , j );
       if(j==i)
           j = readString(shStr, i);
                  else
           lines.add(shStr.substring(i, j);
       if(j==i)
           j = readToken(shStr, i);
                  else
           lines.add(shStr.substring(i, j);
       if(j!=i)
           return null;
       }
       return lines;
    }
    
    public int readMacro(String shStr, int i) {
        return i;
    }
    
    
    public int readToken(String shStr, int i) {
        while(readBlank(shStr.charAt(i))==i)
            i++;
        return i+;
    }
    public boolean splitInTypes(String shStr) {
     int i = 0;
     List<String> lines = split(shStr);
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
   // public String replaceMacro() {}
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

