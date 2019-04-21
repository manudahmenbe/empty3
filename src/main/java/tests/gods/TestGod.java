package tests.gods;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;


public class TestGod extends TestObjetSub {
    private static God god;

    public static void main(String [] args)
    {
        TestGod testGod = new TestGod();
        testGod.setGenerate(GENERATE_MOVIE|GENERATE_IMAGE|GENERATE_MODEL);
        testGod.loop(false);
        new Thread(testGod).start();
    }
    public void ginit()
    {
        god = new God(4, 15, new ColorTexture(Color.PINK));
        scene().add(god);
        scene().cameraActive(new Camera());
        scene().cameraActive(new Camera(Point3D.Z.mult(50), Point3D.X.mult(15)));
    }
    public void testScene()
    {

    }
}
