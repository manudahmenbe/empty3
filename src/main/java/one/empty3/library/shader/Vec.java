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
public Vec() {} 
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

    public Double[] value() {
        Double [] da;
        if(vecVal.data1d.size()>0) {
            da = new Double[getDims() ];
            int i = 0;
            for(i=0;i<vecVal.data1d.get(i); i++) {
                Double a = vecVal.getElem(i);
                da[i] = a;
                i++;
            } 

        } else {
            da = new Double[getDims()];
            int i = 0; // TODO
            int j = 0;
            for(i=0; i<vec.data1d.size(); i++) {
                Double [] d = (Double) vec. data1d. getElem(i). value() ;
                for(Double a : d) {
                    da[j] = a;
                    j++;
                } 

            } 
        } 
    return da;
    } 
} 
