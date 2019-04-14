package tests.aonb;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.Plan3D;

public class Carre extends Plan3D {
    public Carre()
    {
        super();
        pointXExtremite(new Point3D(1, -1, 0));
        pointYExtremite(new Point3D(-1, 0, 0));
        pointOrigine(new Point3D(-1, -1, 0));
    }
}
