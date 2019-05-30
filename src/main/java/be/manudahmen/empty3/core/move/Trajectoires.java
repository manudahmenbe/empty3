

package be.manudahmen.empty3.core.move;

import be.manudahmen.empty3.Point3D;

public class Trajectoires {

    @Deprecated
    public static Point3D sphere(double longpc, double latpc, double radius) {
        return new Point3D(
                Math.cos(longpc * Math.PI) * Math.cos(Math.PI * (latpc - 0.5)),
                Math.sin(longpc * Math.PI) * Math.cos(Math.PI * (latpc - 0.5)),
                Math.sin(Math.PI * (latpc - 0.5))
        ).mult(radius);

    }
}
 