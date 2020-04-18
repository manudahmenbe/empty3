package one.empty3.library.shader;
/***
*  VecStack. 
* fonctions vecteurs
* a parser à partir d'un fichirr xml ptmrporre
*
*/
public class VecStack {
    private StructureMatrix <Integer> numsIn = new StructureMatrix (1, Integer.class) ;
    private StructureMatrix <Integer> numsOut = new StructureMatrix (1, Integer.class) ;



/***
* @param in in[i:int] 
* @param out out[i : int]
* @param formula f(in, out) 
*/
    public VecStack(String formula) {
        
} 
public StructureMatrix <Integer> getVecIn() {
     return numsIn;
} 

public StructureMatrix <Integer> getVecOut() {
     return numsOut;
} 
public String getFormula() {
     return formula;
} 
} 
