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

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class SimpleTrajectory implements Trajectory {

    private ArrayList<Point3D> liste = new ArrayList<Point3D>();

    public boolean hasMorePoints() {
        return !liste.isEmpty();
    }

    public Point3D getNextPointAndRemove() {
        Point3D p = liste.get(0);
        liste.remove(p);
        return p;
    }

    public Point3D[] getIntermediatePointsUntilNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPoints(Collection<Point3D> points) {
        liste.addAll(points);
    }

    public void addPoints(Point3D[] points) {
        for (int i = 0; i < points.length; i++) {
            liste.add(points[i]);
        }
    }

}
