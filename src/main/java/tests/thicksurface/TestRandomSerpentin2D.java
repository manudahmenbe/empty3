package tests.thicksurface;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.lighting.Colors;
import be.manudahmen.empty3.core.testing.TestObjetSub;

/**
 * Created by manue on 16-02-19.
 */
public class TestRandomSerpentin2D extends TestObjetSub {
    public TestRandomSerpentin2D() {
        super();
        setMaxFrames(1);
    }

    public void add() {
        RanndomSerpentin2D ranndomSerpentin2D = new RanndomSerpentin2D();
        ranndomSerpentin2D.texture(new ColorTexture(Colors.random()));
        ranndomSerpentin2D.setInnerWidth(0.5);
        ranndomSerpentin2D.setOuterWidth(0.5);
        scene().add(ranndomSerpentin2D);
    }

    @Override
    public void ginit() {
        for (int i = 0; i < 2; i++)
            add();
        scene().cameraActive(new Camera(Point3D.X.mult(5), Point3D.O0));
    }

    public static void main(String[] args) {
        TestRandomSerpentin2D testRandomSerpentin2D = new TestRandomSerpentin2D();
        new Thread(testRandomSerpentin2D).start();

    }
}
