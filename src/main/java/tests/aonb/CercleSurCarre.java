package tests.aonb;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.Circle;

public class CercleSurCarre extends Circle {
    public CercleSurCarre() {
        super(new Axe(Point3D.Z, Point3D.Z.mult(-1)), 1);
    }
}
