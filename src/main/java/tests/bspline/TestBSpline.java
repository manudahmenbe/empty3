package tests.bspline;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.gdximports.gdx_BSplineCurve;
import be.manudahmen.empty3.core.nurbs.BSplineCurve;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * Created by manue on 17-02-19.
 */
public class TestBSpline extends TestObjetSub {

    public TestBSpline() {
        setMaxFrames(1);
    }

    public void ginit() {
        Point3D[] points = new Point3D[]
                {
                        new Point3D(-1, -1, 0),
                        new Point3D(-1, 1, 0),
                        new Point3D(1, 1, 0),
                        new Point3D(1, -1, 0)
                };
        BSpline bSpline = new BSpline();
        bSpline.add(points[0]);
        bSpline.add(points[1]);
        bSpline.add(points[2]);
        bSpline.add(points[3]);
        bSpline.texture(new TextureCol(Color.RED));
        scene().add(bSpline);
        System.out.println(bSpline);

        BSplineCurve bSplineCurve = new BSplineCurve();
        bSplineCurve.add(1.0, points[0]);
        bSplineCurve.add(1.0, points[1]);
        bSplineCurve.add(1.0, points[2]);
        bSplineCurve.add(1.0, points[3]);
        bSplineCurve.texture(new TextureCol(Color.GREEN));
        scene().add(bSplineCurve);
        System.out.println(bSplineCurve);
        gdx_BSplineCurve gdx_bSplineCurve = new gdx_BSplineCurve();
        gdx_bSplineCurve.instantiate(points, 3);
        gdx_bSplineCurve.texture(new TextureCol(Color.BLUE));
                scene().add(gdx_bSplineCurve);
        System.out.println(gdx_bSplineCurve);

        scene().cameraActive(new Camera(new Point3D(0, 0, -4),
                new Point3D(0, 0, 0)));
    }

    public static void main(String[] args) {
        TestBSpline testBSpline = new TestBSpline();
        testBSpline.setMaxFrames(1);
        new Thread(testBSpline).start();

    }
}

