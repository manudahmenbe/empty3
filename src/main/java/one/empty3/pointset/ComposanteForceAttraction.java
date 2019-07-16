package one.empty3.pointset;

import one.empty3.library.Point3D;

/**
 * Created by manue on 16-07-19.
 */
public class ComposanteForceAttraction {


    public Point3D fun(Gravity t1, Gravity t2, double G, double powerD, double powerM1, double powerM2)
    {
        Point3D plus = t2.dv1.plus(t1.moins(t2).mult(G * Math.pow(t1.m, powerM1) * Math.pow(t2.m, powerM2) / (
                Math.pow(t1.moins(t2).norme(), powerD))));
        return plus;
    }
}
