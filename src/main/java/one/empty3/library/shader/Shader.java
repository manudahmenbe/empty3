package one.empty3.library.shader;
import java.io.*;
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
    enum DataType {Void, Scalar, Object}
    // Datadim?
    enum ParseContext {ClassDef, MemberDef, MethodDef, ListArgs, MethodBodyDef, VariableDef, Instruction, Operation }
   public ParseContext context;
   class SymbolTreeNode {
        public SymbolTreeNode(String name, 
           Items itype, String text, Object value) {
            this.name = name;
            this.itemType = itype;
            this.jValue = value;
            
       } 
       public void comment(String value) {}
       public void function(String name, String itype, SymbolTreeNode values) {}
                                                                             
                                                                             
       public List<SymbolTreeNode> getChildren() {
           return children;
       } 
        String name;
        Items itemType;
        String text;
        Object jValue;
        List<SymbolTreeNode> children = new ArrayList<>();
   } 
   class Expression extends SymbolTreeNode {
         public Expression(String name, 
                  Items itype, String text, Object value) {
              super(name, itype, text, value);
          }
   }
   class Tree {
       SymbolTreeNode root;
       Iterator<SymbolTreeNode> iterate(){return null;}
       SymbolTreeNode current;
   }
 enum Type { Line, Block, Doc }
     enum Items {Comment, Macro, Function, FunctionArgumentList, Keyword, FunctionDeclaration, FunctionBody, MemberVariable, ClassDeclaration, VariableName, VariableType, Literal, Scalar, ClassName}
    class Comment extends SymbolTreeNode{
     public Comment(String name, 
                  Items itype, String text, Object value) {
              super(name, itype, text, value);
          }
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
    private Tree tree;
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
    public int readPredefinedDeclaration(int i) {
        List<String> dec = new ArrayList<>();
        dec.addAll(new String[] {"uniform" , "varying"});
        if(dec.contains(lines.get(i))) {
             tree.current.itemType = Items.MemberVariable;
             tree.current.getChildren().add(new Item("predef member variable attribute",
                 Items.Keyword, lines.get(i)));
             return i+1;
        }
        return i;
    }
    public int readMethod( int i) {
        return i;
    } 

    public void buildExpression(int I) {
        return i;
    }
    public int readVariableDeclaration(int i) {
   
// type1 var1[=expression][,var2[=expression]][varn[=exprn]];
         String itype = lines.get(i);
         String varName = lines.get(i+1);
         
         if(lines.get(i+2).equals("=")) {
             Expression e = buildExpression(i+3);
             SymbolTreeNode stn = new Var(varName,
                new Type(itype), e);
                ;
         } else {
             SymbolTreeNode stn = new Var(varName,
                new Type(itype), null);
         }
             tree.current.add(stn);
         
       return i;
    } 
    public int readInstruction(int i) {
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
    List<Tree> shaderFiles = new ArrayList<>();
    
    public Shader(File fileOrDirectory) {
         if(fileOrDirectory.isDirectory()) 
             for(String sf : fileOrDirectory.list()) {
                  try {
                      File f = new File(fileOrDirectory.getAbsolutePath()+File.separator+sf);
                      tree = new Tree();
                      String shStr = stripComment(new String(Files.readAllBytes(Paths.get(f.getAbsolutePath()))));
                      
                   splitInTypes(shStr);
                   
                   shaderFiles.add(tree);
                      //  shStr = replaceMacro(shStr);
                   } catch(IOException ex) {
                       ex.printStackTrace();
                  }
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

