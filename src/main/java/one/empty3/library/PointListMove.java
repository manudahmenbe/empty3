package one.empty3.library;
import one.empty3.library.core.nurbs.*;
public class PointListMove {
    private List<Point3D> points;
    private StructureMatrix<String> formula = new StructureMatrix (1, String.class);
    private StructureMatrix<ParametricCurve> curves = new StructureMatrix (1, ParametricCurve.class);
    private int type;
    // Slices of ord.ex (0,1), curve, curveOp 
    // tan, norm, cross, add... ???
    public PointListMove (List<Point3D> [) {
        this.points = p;
    }
    
    public void random() {
    
    }
    
    public void curve(ParametricCurve curve) {
        this.curve = curve;
    }
    /***
     * @param formula vec{3}(f(ord(0), ord(1), ...))
     */
    public void formulaOrd(String formula) {
       this.formula = formula;
    
    }
}
