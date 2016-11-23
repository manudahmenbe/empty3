package be.manudahmen.empty3.library.gdximports;

import be.manudahmen.empty3.library.nurbs.ParametrizedCurve;
import be.manudahmen.empty3.library.object.Point3D;
import com.badlogic.gdx.math.BSpline;
import com.badlogic.gdx.math.Vector3;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class gdx_BSplineCurve extends ParametrizedCurve {
    int degree;
    boolean continuous;
    private BSpline<Vector3> bspline;
    private Point3D[] controlPoints;

    public gdx_BSplineCurve() {
    }

    public void instantiate(Point3D[] controlPoints, int degree) {
        this.controlPoints = controlPoints;
        Vector3[] arr = new Vector3[controlPoints.length];
        int i = 0;
        for (Point3D p : controlPoints) {
            Vector3 v = new Vector3();
            arr[i++] = Conv.conv(v, p);

        }
        bspline = new BSpline<Vector3>();
        bspline.set(arr, degree, true);
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public BSpline getBspline() {
        return bspline;
    }


    public Point3D calculerPoint3D(double t) {
        Point3D p = new Point3D();
        Vector3 out = new Vector3();
        return Conv.conv(new Point3D(), bspline.valueAt(out, (float) t));
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
