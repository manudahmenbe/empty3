package be.manudahmen.empty3.library.tests.borromeanRings;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.library.tests.TestSphere.Trajectoires;

/**
 * Created by Win on 11-09-18.
 */
public class TestBorromeanRings extends TestObjetSub {
    @Override
    public void finit() {
        camera(new Camera(Trajectoires.sphere(
                1.0 * frame() / getMaxFrames(), 0, 0.0001),
                Point3D.O0));
    }

    @Override
    public void ginit() {
        BorromeanRings br = new BorromeanRings();
        scene().add(br);
    }

    public static void main(String... args) {
        TestBorromeanRings tbr = new TestBorromeanRings();
        tbr.setMaxFrames(100);
        new Thread(tbr).start();
    }
}
