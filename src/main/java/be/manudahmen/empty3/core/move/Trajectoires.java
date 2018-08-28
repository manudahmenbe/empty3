

package be.manudahmen.empty3.core.move;

import be.manudahmen.empty3.Point3D;

public class Trajectoires {

    public static Point3D sphere(double longpc, double latpc, double radius) {
        return new Point3D(
                Math.cos(longpc * 2 * Math.PI) * Math.cos(Math.PI * latpc),
                Math.sin(longpc * 2 * Math.PI) * Math.cos(Math.PI * latpc),
                Math.sin(latpc * 2 * Math.PI)
        ).mult(radius);

    }

}
 