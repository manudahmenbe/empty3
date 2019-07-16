package one.empty3.pointset;

import one.empty3.library.Point3D;
import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebraicTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;

import java.util.HashMap;

/**
 * Created by manue on 16-07-19.
 *
 * '"
 * Ici il s'agit de faire évoluer des points à travers des lignes de forces
 * sans corps ni énergje d'un champ abstrait de force. But: waw
 * ""
 */
public class ComposanteForceSurface {


    private AlgebraicTree z;
    private AlgebraicTree x;
    private AlgebraicTree y;
    private HashMap<String, Double> params;

    public ComposanteForceSurface(AlgebraicTree x, AlgebraicTree y, AlgebraicTree z, HashMap<String, Double> params)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        x.getParametersValues().putAll(params);
        y.getParametersValues().putAll(params);
        z.getParametersValues().putAll(params);
        this.params = params;
        this.params.putAll(params);
    }
    
    public Point3D evSurface(double xv, double yv, double zv) throws TreeNodeEvalException, AlgebraicFormulaSyntaxException {
        params.put("x", xv);
        params.put("y", yv);
        params.put("z", zv);
        Point3D point3D = new Point3D(x.eval(), y.eval(), z.eval());
        return point3D;
    }
    public Point3D eqSurface() throws TreeNodeEvalException, AlgebraicFormulaSyntaxException {
        return new Point3D(x.eval(), y.eval(), z.eval());
    }
    public void declareVar(String var, Double value)
    {
        x.getParametersValues().put(var, value);
        y.getParametersValues().put(var, value);
        z.getParametersValues().put(var, value);
    }

    /***
     *         // RESTE A VOIR LA CHARITE DU DV
     * @param point3D
     * @param param
     * @param value
     * @param dv
     * @return
     * @throws TreeNodeEvalException
     * @throws AlgebraicFormulaSyntaxException
     */
    public Point3D diff2(Point3D point3D, String param, double value, double dv) throws TreeNodeEvalException, AlgebraicFormulaSyntaxException {
        declareVar(param, value);
        Point3D v = evSurface(point3D.getX(), point3D.getY(), point3D.getZ());
        declareVar(param, value+dv);
        Point3D v20 = evSurface(point3D.getX(), point3D.getY(), point3D.getZ());
        declareVar(param, value+2*dv);
        Point3D v21 = evSurface(point3D.getX(), point3D.getY(), point3D.getZ());
        declareVar(param, value-dv);
        Point3D v30 = evSurface(point3D.getX(), point3D.getY(), point3D.getZ());
        declareVar(param, value-2*dv);
        Point3D v31 = evSurface(point3D.getX(), point3D.getY(), point3D.getZ());
        declareVar(param, value);
        //....????
        double norme2 = v20.moins(v21).norme();
        double norme3 = v30.moins(v31).norme();
        if(norme3==norme2)
            return v;
        else if(norme2>norme3)
            return v30;
        else if(norme2<norme3)
            return v20;
        else
            return null;
        //return v.plus(v2).plus(v3).mult(1/3.0);
    }

    public void reset() {

    }
}
