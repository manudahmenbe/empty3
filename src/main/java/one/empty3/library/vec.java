package one.empty3.library;
public class vec {
     public static DoubleArray da;
     private int arrayNo;
     private int start;
     private int n;
     private boolean disposable;
     public int length() {
         return n;
     }
     public vec(double x, double y, double z) {
          n = 3;
          start = da.addDoubles(n);
          da.setDoubles(start, x, y, z);
     }

     public vec(double x, double y, double z,
         double t) {
          n = 4;
          start = da.addDoubles(n);
         
          da.setDoubles(start, x, y, z, t);
     }
     public vec(vec v1, double... c) {
     }
     public vec(vec... v) {
     }
     public vec(double d, vec ... c) {
     }
}
