/*

    Vous êtes libre de :

*/
package tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel DAHMEN
 */
public class TestTrianglePerspective extends TestObjetSub {
    public static void main(String[] args) {
        TestObjetSub testTriangle = new TestTrianglePerspective();
        testTriangle.camera(new Camera(new Point3D(0, 0, -15000), new Point3D(0, 0, 0)));
        testTriangle.run();
    }

    @Override
    public void testScene() {

        scene().add(new TRI(new Point3D(0, 0, 0), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.green));
        scene().add(new TRI(new Point3D(1, 1, 0), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.red));


        description = "Two be.manudahmen.empty3.library.tests.triangles . One green down left . One red upper right";
    }
}
