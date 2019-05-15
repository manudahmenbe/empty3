package tests.TestSphere;

import be.manudahmen.empty3.Matrix33;
import be.manudahmen.empty3.Point3D;


/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class Trajectoires {
    public static Point3D sphere(double longpc, double latpc, double radius, Matrix33 init) {
        return init.mult(new Point3D(
                Math.cos(latpc * 2 * Math.PI) * Math.cos(Math.PI * longpc),
                Math.cos(latpc * 2 * Math.PI) * Math.sin(Math.PI * longpc),
                Math.sin(longpc * 2 * Math.PI))

        ).mult(radius);

    }
}
