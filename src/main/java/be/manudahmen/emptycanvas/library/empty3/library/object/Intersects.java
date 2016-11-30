package be.manudahmen.emptycanvas.library.empty3.library.object;

/**
 * Created by manuel on 21-10-16.
 */
public class Intersects {
    public Ray ray;
    public Intersection intersection;

    public class Ray {
        public Point3D start;
        public Point3D direction;

    }

    public class Intersection {
        public Representable intersection;
        public Point3D interPoint;
    }
}
