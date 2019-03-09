package tests.thicksurface;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.lighting.Colors;
import be.manudahmen.empty3.core.testing.TestObjetSub;

/**
 * Created by manue on 16-02-19.
 */
public class TestRandomSerpentin1D extends TestObjetSub {
    RandomSerpentin1D ranndomSerpentin1D;
    public TestRandomSerpentin1D() {
        super();
        setMaxFrames(10000);
    }

    public void add() {
        ranndomSerpentin1D = new RandomSerpentin1D();
        ranndomSerpentin1D.texture(new TextureCol(Colors.random()));
        ranndomSerpentin1D.setInnerWidth(0.5);
        ranndomSerpentin1D.setOuterWidth(0.5);
        scene().add(ranndomSerpentin1D);
    }

    @Override
    public void ginit() {
        for (int i = 0; i < 2; i++)
            add();
        scene().cameraActive(new Camera(Point3D.X.mult(5), Point3D.O0));
    }

    public void finit()
    {
        Point3D[] coefficients = ranndomSerpentin1D.courbeParametriquePolynomialeBezier.getCoefficients();
        for(int i=0; i<coefficients.length; i++)
                coefficients[i] = coefficients[i].plus(Point3D.random(0.01));
    }
    public static void main(String[] args) {
        TestRandomSerpentin1D testRandomSerpentin1D = new TestRandomSerpentin1D();
        new Thread(testRandomSerpentin1D).start();

    }
}