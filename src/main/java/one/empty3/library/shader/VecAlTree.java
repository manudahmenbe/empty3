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
          } catch(AlgebraicFormulaSyntaxException t) {
        System.out.println ("error vecaltreecondtruct\n"+tree ) ;
        } 
  	
    } 
 public void setParameter(String p, Double d) {
 tree.setParameter(p, d);
 }
    public Double [] getValue() {
try {
    return new Double [] {
tree. eval() } ;
} catch (TreeNodeEvalException ex) {
     ex.printStackTrace();
     return new Double[] {0.0};
} 


   } 
} 
