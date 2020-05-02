package one.empty3.library;

public class RepresentableT {
    protected double t, dt;
    private RListMove propertiesMoves;
    public double getTime() {
         return t;
    }
    public void setTime(double t) {
         this.t = t;
    }
    
    public void next() {
         propertiesMoves.next();
    }
}
