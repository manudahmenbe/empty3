/*

    Vous êtes libre de :

*/
package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Polygon;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.awt.*;

/**
 * @author Manuel DAHMEN
 */
public class TestCubeTroue extends TestObjetStub {

    public static void main(String[] args) {
        TestCubeTroue TestObjetStub = new TestCubeTroue();
        TestObjetStub.run();
    }

    @Override
    public void testScene() {

        Polygon p = new Polygon(Color.red);
        p.setPoints(new Point3D[]{new Point3D(-0.5, -0.5, -0.5), new Point3D(-0.5, -0.5, 0.5), new Point3D(0.5, -0.5, 0.5), new Point3D(0.5, -0.5, -0.5)});
        scene().add(p);
        p = new Polygon(Color.blue);
        p.setPoints(new Point3D[]{new Point3D(-0.5, -0.5, -0.5), new Point3D(-0.5, -0.5, 0.5), new Point3D(-0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, -0.5)});
        scene().add(p);
        p = new Polygon(Color.green);
        p.setPoints(new Point3D[]{new Point3D(0.5, 0.5, -0.5), new Point3D(0.5, 0.5, 0.5), new Point3D(0.5, -0.5, 0.5), new Point3D(0.5, -0.5, -0.5)});
        scene().add(p);
        p = new Polygon(Color.magenta);
        p.setPoints(new Point3D[]{new Point3D(0.5, 0.5, -0.5), new Point3D(0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, -0.5)});
        scene().add(p);
        p = new Polygon(Color.black);
        p.setPoints(new Point3D[]{new Point3D(-0.5, -0.5, 0.5), new Point3D(0.5, -0.5, 0.5), new Point3D(0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, 0.5)});
        scene().add(p);

        scene().cameraActive(new Camera(new Point3D(0, 0, -10), new Point3D(0, 0, 0)));

        description = "Cube troué au centre en perspective";
    }
}
