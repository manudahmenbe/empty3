package one.empty3.library;

public class RepresentableT {
    protected double t, dt;
    private ListPointMove propertiesMoves;
    public double getT() {
         return t;
    }
    public void setT(double t) {
         this.t = t;
    }
    
    public void next() {
         propertiesMoves.next();
    }
}
