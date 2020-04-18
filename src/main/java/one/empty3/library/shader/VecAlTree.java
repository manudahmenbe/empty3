package one.empty3.library.shader;
import one.empty3.library.core.raytracer.tree.*;
public class VecAlTree extends Vec {
    AlgebricTree tree;
    public VecAlTree(String formula) {
        super() ;
            

        tree=new AlgebricTree(formula) 
            ;
        try {
            tree.construct();
          } catch(AlgebraicFormulaSyntaxException|TreeNodeEvalException t) {
        System.out.println ("error vecaltreecondtruct\n"+tree ) ;
        } 
  	
    } 
 public void setParameter(String p, Double d) {
 tree.setParameter(p, d);
 }
    public Double [] getValue() {
    return new Double [] {tree. eval() } ;
    } 
} 
