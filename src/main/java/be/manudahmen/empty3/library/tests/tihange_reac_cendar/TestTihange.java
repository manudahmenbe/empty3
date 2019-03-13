package be.manudahmen.empty3.library.tests.tihange_reac_cendar;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.library.tests.TestSphere.Trajectoires;

public class TestTihange extends TestObjetSub {
    public static void main(String... args) {
        TestTihange testTihange = new TestTihange();
        testTihange.setMaxFrames(1);
        testTihange.setGenerate(GENERATE_MOVIE | GENERATE_IMAGE | GENERATE_MODEL);
        new Thread(testTihange).start();
    }

    public void finit() {
        scene().cameraActive(new be.manudahmen.empty3.Camera(
                Trajectoires.sphere(Math.random(), Math.random()
                        , 8),
                new Point3D(0, 0, 1)));
        scene().add(new Tihange());
    }

    @Override
    public void testScene() throws Exception {
    }
}
