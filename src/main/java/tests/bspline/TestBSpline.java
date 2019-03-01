package tests.bspline;

import be.manudahmen.empty3.BSpline;
import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.gdximports.gdx_BSplineCurve;
import be.manudahmen.empty3.core.nurbs.BSplineCurve;
import be.manudahmen.empty3.core.testing.TestObjetSub;

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
                        new Point3D(0, 0, 0),
                        new Point3D(0, 1, 0),
                        new Point3D(1, 1, 0),
                        new Point3D(1, 0, 0)
                };
        BSpline bSpline = new BSpline();
        bSpline.add(points[0]);
        bSpline.add(points[1]);
        bSpline.add(points[2]);
        bSpline.add(points[3]);
        scene().cameraActive(new Camera(new Point3D(0.5, 0.5, 2),
                new Point3D(0.5, 0.5, 0)));
        scene().add(bSpline);

        BSplineCurve bSplineCurve = new BSplineCurve();
        bSplineCurve.add(1.0, points[0]);
        bSplineCurve.add(1.0, points[1]);
        bSplineCurve.add(1.0, points[2]);
        bSplineCurve.add(1.0, points[3]);
        scene().add(bSplineCurve);
        System.out.println(bSplineCurve);

        gdx_BSplineCurve gdx_bSplineCurve = new gdx_BSplineCurve();
        gdx_bSplineCurve.instantiate(points, 4);
        scene().add(gdx_bSplineCurve);

        scene().cameraActive(new Camera(Point3D.Z.mult(-2),
                Point3D.O0));
    }

    public static void main(String[] args) {
        TestBSpline testBSpline = new TestBSpline();
        new Thread(testBSpline).start();

    }
}

