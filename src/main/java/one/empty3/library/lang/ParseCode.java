package one.empty3.library.lang;

public class ParseCode {
    public enum TokenType {Name, Keyword, StringLiteral,
       FloatLiteral, DoubleLiteral, CharLiteral, Comment, JavadocComment
       };
    String tokenType = new String [] {
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
    public void removeComments() {
        StringBuilder sb = new StringBuilder();
                // Caractère par caractère
        int comm = 0;
        // Si /* sauter jusqu'à */
        // Si // sauter jusqu'à ¶
      
        for( i=0; i<brut.length; i++) {
            if(comm==0 && brut.charAt(i)=='"') {
                comm =3; i++;
            }
            if(comm=3 && brut.charAt(i)=='"') {
                comm = 0; i++;
            if(comm==3 &&brut.charAt(i)=='\\') {
                i+=2;
           }
           if(comm=0 && brut.charAt(i)=='\'') {
                comm =4; i++;
           }
           if(comm==4 && brut.charAt(i)=='\'') {
                comm = 0; i++;
           if(comm==4 &&brut.charAt(i)=='\\') {
                i+=2;
           }
            if(comm==0 && brut.charAt(i)=='/'
               && i<brut.length-1
               && brut.charAt(i+1)=='*')
                comm = 1;
            if(comm==0 && brut.charAt(i)=='/'
               && i<brut.length-1
               && brut.charAt(i+1)=='/') {
    
                comm = 2;
                while(i<brut.length) {
                    if(brut.charAt (i)=='\n'){
                        comm = 0;
                        i++;
                    }
                }
            }
            if(comm==1 && brut.charAt(i)=='*'
               && i<brut.length-1
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
         return false
     }
     public boolean parseKeyword(){
         return false
     }
     public boolean parseName(){
         return false
     }
     public boolean parseLiteral(){
         return false
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
