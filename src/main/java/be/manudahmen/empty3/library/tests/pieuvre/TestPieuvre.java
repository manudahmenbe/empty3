package be.manudahmen.empty3.library.tests.pieuvre;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;


public class TestPieuvre extends TestObjetSub {
    private Pieuvre pieuvre;

    public void ginit() {
        this.pieuvre = new Pieuvre(10,
                Color.YELLOW);
        scene().add(pieuvre);
        scene().cameraActive(new Camera(Point3D.Z.mult(2), Point3D.O0));
    }

    private double time() {
        return 1.0 * frame() / getMaxFrames() * 25.0;
    }

    public void testScene() {
        pieuvre.setT(time());
    }

    public static void main(String[] args) {
        TestPieuvre testPieuvre = new TestPieuvre();
        testPieuvre.setMaxFrames(10000);
        new Thread(testPieuvre).start();

    }
}
