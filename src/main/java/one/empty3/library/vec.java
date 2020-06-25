package one.empty3.library;
public class vec {
     public static DoubleArray da;
     private int arrayNo;
     private int start;
     private int stop;
     private boolean disposable;
     
     public vec(double x, double y, double z) {
          start = da.addDoubles(3);
          da.setDoubles(start, x, y, z);
     }

     public vec(double x, double y, double z,
         double t) {
          start = da.addDoubles(3);
          da.setDoubles(start, x, y, z, t);
     }
}
