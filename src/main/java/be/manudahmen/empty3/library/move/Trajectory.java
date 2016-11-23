/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.move;

import be.manudahmen.empty3.library.object.Point3D;

import java.util.Collection;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public interface Trajectory {

    int POINTS_INTERMEDIATE_LINE = 0;
    int POINTS_INTERMEDIATE_BEZIER = 0;

    boolean hasMorePoints();

    Point3D getNextPointAndRemove();

    Point3D[] getIntermediatePointsUntilNext();

    void addPoints(Collection<Point3D> points);

    void addPoints(Point3D[] points);
}
