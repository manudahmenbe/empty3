package be.manudahmen.empty3.library.sanorm;

import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.tribase.TRIObjetGenerateurAbstract;

import java.awt.*;

/**
 * @author Manuel Dahmen
 */

/**
 * @author Manuel Dahmen
 */
public class SurfacePointParPoint extends TRIObjetGenerateurAbstract {

    private Point3D[][] points;

    public SurfacePointParPoint(Point3D[][] points, Color[][] couleurs) {
        if (checkDimensions()) {
            this.points = points;

            setMaxX(points.length);
            setMaxY(points[0].length);
        }

    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        if (y < points.length && x < points[y].length && x >= 0 && y >= 0) {
            return points[y][x];
        }
        throw new ArrayIndexOutOfBoundsException("Coordonnée pas normale");
    }

    private boolean checkDimensions() {

        return true;
        // Hmmm.
    }
}
