package tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Camera3D;
import be.manudahmen.empty3.Cube;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;

public class TestCube3D extends TestObjetSub {
    protected Cube c;

    public static void main(String[] args) {
        TestCube3D tn = new TestCube3D();

        tn.loop(false);

        tn.setMaxFrames(2000);

        tn.setResx(800);

        tn.setResy(600);

        tn.set3D(true);

        tn.run();
    }

    @Override
    public void ginit() {
        super.ginit();

        scene().clear();

        Camera c3D = new Camera3D(
                Point3D.Z.mult(100),
                Point3D.O0,
                10);
        ((Camera3D) c3D).configure(1);
        scene().cameraActive(c3D);

        c = new Cube(10, Point3D.O0);

        scene().add(c);
    }

    public void testScene() {
    }
}
