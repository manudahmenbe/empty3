/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.extra;

import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.object.Scene;

public interface ISpirale {

    void addToScene(Scene sc);

    Point3D getObjectDeviation(Point3D position);

    Point3D getObjectDeviation(Point3D position, Point3D speed,
                               Point3D rotation);

    Point3D getObjectRotation(Point3D position);

    Point3D getObjectRotation(Point3D position, Point3D speed,
                              Point3D rotation);

    void rotate();

    void rotate(double deg);
}
