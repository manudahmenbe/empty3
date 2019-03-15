/*

    Vous êtes libre de :

*/
package tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Cube;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;

/**
 * @author Manuel DAHMEN
 */
public class TestCubeTroueTriangles extends TestObjetSub {

    public static void main(String[] args) {
        TestCubeTroueTriangles TestObjetSub = new TestCubeTroueTriangles();
        TestObjetSub.run();
    }

    @Override
    public void testScene() {

        Cube c = new Cube(1, Point3D.X.mult(3));
        scene().add(c);
        c = new Cube(1, Point3D.X.mult(-3));
        scene().add(c);
        c = new Cube(1, Point3D.Y.mult(3));
        scene().add(c);
        c = new Cube(1, Point3D.Y.mult(-3));
        scene().add(c);
        c = new Cube(1, Point3D.Z.mult(3));
        scene().add(c);

        scene().cameraActive(new Camera(new Point3D(0, 0, -15), new Point3D(0, 0, 0)));

        description = "5 be.manudahmen.empty3.library.tests.cubes";
    }
}
