package be.manudahmen.emptycanvas.library.empty3.library.move;

import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class Trajectoires {

    public static Point3D sphere(double longpc, double latpc, double radius) {
        return new Point3D(
                Math.cos(longpc * 2 * Math.PI) * Math.cos(Math.PI * latpc),
                Math.sin(longpc * 2 * Math.PI) * Math.cos(Math.PI * latpc),
                Math.sin(latpc * 2 * Math.PI)
        ).mult(radius);

    }
}
 