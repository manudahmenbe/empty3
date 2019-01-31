package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.core.renderer.TestObjetStub;

import java.awt.*;

/**
 * @author Manuel DAHMEN
 */
public class TestTriangle extends TestObjetStub {
    public static void main(String[] args) {
        TestTriangle testTriangle = new TestTriangle();
        testTriangle.run();
    }

    @Override
    public void testScene() {
        setResx(320);
        setResy(200);
        scene().add(new TRI(new Point3D(0, 0, 0), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.green));
        scene().add(new TRI(new Point3D(1, 1, 0), new Point3D(1, 0, 0), new Point3D(0, 1, 0), Color.red));

        camera(new Camera(new Point3D(0, 0, -1000), new Point3D(0, 0, 0)));
        description = "Two be.manudahmen.empty3.library.tests.triangles . One green down left . One red upper right";
    }

}