package one.empty3.library.lang;

public class Token {
    TokenTypeTxt typeTxt;
    String literal;
    String tt;
    public Token(String tt, String literal, TokenTypeTxt typeTxt) {
        this.typeTxt = typeTxt;
        literal = literal;
        this.tt = tt;
    }
    public enum TokenTypeTxt {
        Space,
        SpecialChar,
        Keyword,
        Name,
        Literal
    }
    @Override
    public String toString() {
        return "Token{" +
                "literal='" + literal + '\'' +
                ", tt='" + tt + '\'' +
                ", typeTxt='" + typeTxt + '\'' +
                '}';
    }
}
