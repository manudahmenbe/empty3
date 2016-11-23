package be.manudahmen.empty3.library.tribase;

import be.manudahmen.empty3.library.object.BezierCubique;
import be.manudahmen.empty3.library.object.Point3D;

public class CheminBezier extends Chemin {

    private int n = 100;
    private BezierCubique sd;

    public CheminBezier(BezierCubique sd) {
        this.sd = sd;
    }

    public double getLength() {
        throw new UnsupportedOperationException("Longueur Bezier non mesurée");
    }


    @Override
    public Point3D calculerPoint3D(double t) {
        return sd.calculerPoint3D(t);
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
