package tests.thicksurface;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.lighting.Colors;
import be.manudahmen.empty3.core.testing.TestObjetSub;

/**
 * Created by manue on 16-02-19.
 */
public class TestRandomSerpentin2D extends TestObjetSub {
    RandomSerpentin2D ranndomSerpentin2D;
    public TestRandomSerpentin2D() {
        super();
        setMaxFrames(10000);
    }

    public void add() {
        ranndomSerpentin2D = new RandomSerpentin2D();
        ranndomSerpentin2D.texture(new TextureCol(Colors.random()));
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

    public void finit()
    {
        Point3D[][] coefficients = ranndomSerpentin2D.surfaceParametricPolygonalBezier.getCoefficients();
        for(int i=0; i<coefficients.length; i++)
            for(int j=0; j<coefficients[i].length; j++)
            {
                coefficients[i][j] = coefficients[i][j].plus(Point3D.random(0.01));
            }
    }
    public static void main(String[] args) {
        TestRandomSerpentin2D testRandomSerpentin2D = new TestRandomSerpentin2D();
        new Thread(testRandomSerpentin2D).start();

    }
}
