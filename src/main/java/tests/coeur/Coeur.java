/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>

 Creation time 25-oct.-2014
 ***/


package tests.coeur;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateurAbstract;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class Coeur extends TRIObjetGenerateurAbstract {
    private double b;

    public void param01(double b) {
        this.b = b;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        double a = 1.0 * x / getMaxX();
        double t = 1.0 * y / getMaxY() * 2 * Math.PI;
        return new Point3D(a * Math.sin(t + b * 2 * Math.PI) * (1 + Math.cos(t)), a * Math.cos(t + b * Math.PI * 2) * (1 + Math.cos(t)), 0);
    }

}
