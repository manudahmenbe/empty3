package one.empty3.library.lang;

public class Scope {
    Scope parentScope;
    List<Node> nodes;
    String modifier; // static
    String privacy; // private public protected package
    boolean iDo;
    boolean iWhile;
    boolean iUnnamed;
    boolean iFor;
    boolean iForEach;

    Tree params;
    Tree cond;
    Tree instructions;
    
}
