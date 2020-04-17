package one.empty3.library.shader;
import one.empty3.library.*;
public class Vec
{
private int dims;
private StructureMatrix <Double> vecVal
    = new StructureMatrix (1, Double.class);
    
private StructureMatrix <Vec> vec
    = new StructureMatrix (1, Vec.class);
    
    public Vec(Double... comps) {
       //  Vec v = new Vec() ;
         for(Double d : comps) 
             vecVal.add(1, d);
} 
    public Vec(Vec... comps) {
        for(Vec v : comps)
            vec.add(1, v);
            
} 

    public int getDims() {
        int dims =0;
        if(vecVal.data1d.size()>0) {
            this.dims =vecVal.data1d.size();
            return dims;
}
        if(vec.data1d.size()>0)
            for(int i=0;i<vec.data1d.size();i++)
                dims += vec.data1d.size();
          
         return dims;
} 
    public String toString() {
        String s = "vec" +getDims() + 
           "(";
        if(vecVal.data1d.size()>0) 
            for(int i=0;i<vecVal.data1d.size();
                 i++)
                s+=vecVal.
getElem(i)+", ";
        else
for(int i=0;i<vec.data1d.size();
                 i++)
                s+= vec.
getElem(i).toString()+", ";
s+=")";
return s;
}
    public Vec eval() {
   return null;
    } 
    public Double[] value() {
        if(vecVal.data1d.size()) {
            Double [] da = new Double[vecVal.data1d.size()];
            int i = 0;
            for(Double a : vecVal.data1d.get(i)) {
                da[i] = a;
                i++;
            } 
            return da;
        } else {
            Double [] da = new Double[vec.data1d.size()];
            int i = 0; // TODO
            for(Double a : vec.data1d.get(i). value()[0] ) {
                da[i] = a;
                i++;
            } 
        } 
    return null;
    } 
} 
