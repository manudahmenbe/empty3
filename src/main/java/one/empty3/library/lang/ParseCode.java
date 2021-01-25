package one.empty3.library.lang;

import java.util.*;
public class ParseCode {
    public enum TokenType {Name, Keyword, StringLiteral,
       FloatLiteral, DoubleLiteral, CharLiteral, Comment, JavadocComment
       };
    public enum InstructionBlock { Unnamed, For, While, Do, Method };
    String special = "!%*&()+\\|/[]{}<>:,;?'\"";
    String[] keywords = new String [] {
       ""
    };
    String code;
    Tree tree;
    public ParseCode() {
        tree = new Tree();
        // separer en tokens typés
    }
    public boolean addToken() {
        Token t = new Token();
        return true;
    }
    int i=0;
    String brut;
    String uncomm;
    public void removeComments() {
        StringBuilder sb = new StringBuilder();
                // Caractère par caractère
        int comm = 0;
        // Si /* sauter jusqu'à */
        // Si // sauter jusqu'à ¶
      
        for( i=0; i<brut.length(); i++) {
            if(comm==0 && brut.charAt(i)=='"') {
                comm =3; i++;
            }
            if(comm==3 && brut.charAt(i)=='"') {
                comm = 0; i++;
            }
            if(comm==3 &&brut.charAt(i)=='\\') {
                i+=2;
           }
           if(comm==0 && brut.charAt(i)=='\'') {
                comm =4; i++;
           }
           if(comm==4 && brut.charAt(i)=='\'') {
                comm = 0; i++;
           }
           if(comm==4 &&brut.charAt(i)=='\\') {
                i+=2;
           }
            if(comm==0 && brut.charAt(i)=='/'
               && i<brut.length()-1
               && brut.charAt(i+1)=='*')
                comm = 1;
            if(comm==0 && brut.charAt(i)=='/'
               && i<brut.length()-1
               && brut.charAt(i+1)=='/') {
    
                comm = 2;
                while(i<brut.length()) {
                    if(brut.charAt (i)=='\n'){
                        comm = 0;
                        i++;
                    }
                }
            }
            if(comm==1 && brut.charAt(i)=='*'
               && i<brut.length()-1
               && brut.charAt(i+1)=='/') {
                comm = 0; i+=2;
            }
           
            if(comm==0) {
                parseSpace();
                parseSpecialChar();
                parseKeyword();
                parseName();
                parseLiteral();
                sb.append(brut.charAt(i));
                i++;
            }
        }
            
    }

     public boolean parseSpace() {
         return false;
     }
     public boolean parseSpecialChar(){
         return false;
     }
     public int parseKeyword(){
         char a = uncomm.charAt(i);
         int j=0;
         while(Character.isLetter(a)) {
             j++;
             a = uncomm.charAt(i+j);
         }
         if(isSpecialChar(uncomm, i+j)||
               isWhitespace(uncomm, i+j)) {
           List<String> list = Arrays.asList(keywords);
        
           String k =uncomm.substring(i, i+j);
           if(k.length()>0&&list.contains(k))
               return i+j;
         }
         return i;
     }
    
     public int parseName(){
         char a = uncomm.charAt(i);
         int j=0;
         while(Character.isLetter(a)||(j>0
                     &&(Character.isLetterOrDigit(a)||
                      a=='_'))) {
             j++;
             a = uncomm.charAt(i+j);
         }
         List<String> list = Arrays.asList(keywords);
        
           String k =uncomm.substring(i, i+j);
           if(k.length()>0&&!list.contains(k))
               return i+j;
         return i;
     }
public boolean isSpecialChar(String uncomm,
                                int pos) {
        return special.indexOf(uncomm.charAt(pos))>=0;

    }
    public boolean isWhitespace(String uncomm,
                                int pos) {
       char a = uncomm.charAt(pos);
        if(a==' '||a=='\n'||a=='\t'||a=='\r') {
           // i=i+j;
          //  i=i+pos;
            return true;
        }
        return false;
    }
    public int nextWhitespace(String uncomm,
                                int pos) {
        boolean b = false;
        do {
            char a = uncomm.charAt(pos);
            if(a==' '||a=='\n'||a=='\t'||a=='\r') {
                pos++;
                b = true;
            }
        } while(!b && pos<uncomm.length());
        return pos;
    }
    public int nextChar(String uncomm,
                                int pos) {
        
            char a = uncomm.charAt(pos);
            while((a==' '||a=='\n'||a=='\t'||a=='\r')) {
                pos++;
            }
        
        return pos;
    }
     public boolean parseLiteral(){
         return false;
     }
    public void block() {
    }
    public void tree() {
    }
    public void reduce() {
    }
    public void map() {
    }
    public void result() {
    }
}
