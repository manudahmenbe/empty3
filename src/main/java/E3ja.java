public class E3ja {
     public E3ja(Object object) {
          
     }
     /*** 
       *  example: setFormulaFunctionA(AlgebricTree al) { ... }
       *           setFormulaFunctionB(...
       *  "formulaFunctionA=sin(x):formulaFunctionB=cos(x)"
     public void setFunctions(String propertyFunction) {
          String [] pf =  path.split(":");
          for(String i : pf) {
               String [] pair = i.split("=");
               String propertyName = pair[0];
               String formula = pair[1];
               AlgebricTree tree = new AlgebricTree(formula);
               Pojo.setProperty(propertyName, tree);
               
          }
     }
}
