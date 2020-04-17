package one.empty3.library.shader;
public class VecAlTree extends Vec {
    AlgebricTree tree;
    public VecAlTree(String formula) {
        tree=new AlgebricTree(formula) 
            ;
        try {
            tree.construct();
          } catch(Throwable t) {
        System.out.println ("error vecaltreecondtruct\n"+trre ) ;
        } 
  	
    } 
 public void setParameter(String p, Double d) {
 tree.setParameter(p, d);
 }
    public Double [] getValue() {
    return new Double [] {tree. eval() } ;
    } 
} 
