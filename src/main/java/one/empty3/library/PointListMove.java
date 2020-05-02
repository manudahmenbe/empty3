package one.empty3.library;
import one.empty3.library.core.nurbs.*;
public class PointListMove {
    private RepresentableT [] points;
    private StructureMatrix<String> formula = new StructureMatrix (1, String.class);
    private StructureMatrix<ParametricCurve> curves = new StructureMatrix (1, ParametricCurve.class);
    private int type;
    private double t, dt;
    // Slices of ord.ex (0,1), curve, curveOp 
    // tan, norm, cross, add... ???
    // collide
    public PointListMove (double t, double dt, RepresentableT... p) {
        this.points = p;
        this.t = t;this.dt = dt;
    }
    
    public void customFunction(String property) {
    
    }

    public void curve(String property, ParametricCurve curve) {
        this.curve = curve;
    }
    /***
     * @param formula vec{3}(f(ord(0), ord(1), ...))
     */
    public void formulaOrd(String property, String formula) {
       this.formula = formula;
    
    }
    
    public void next(){
         
    }
    
}