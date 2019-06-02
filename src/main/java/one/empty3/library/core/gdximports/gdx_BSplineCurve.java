/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package one.empty3.library.core.gdximports;

import com.badlogic.gdx.math.BSpline;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import one.empty3.library.Point3D;
import one.empty3.library.core.nurbs.ParametricCurve;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class gdx_BSplineCurve extends ParametricCurve {
    int degree;
    boolean continuous;
    private BSpline<Vector3> bspline;
    private Point3D[] controlPoints;

    public gdx_BSplineCurve() {
    }

    public void instantiate(Point3D[] controlPoints, int degree) {
        this.controlPoints = controlPoints;
        Vector3[] arr = new Vector3[controlPoints.length];
        Array<Vector3> knots = new Array<Vector3>();
        int i = 0;
        bspline = new BSpline<Vector3>();
        for (Point3D p : controlPoints) {
            Vector3 v = new Vector3();
            arr[i++] = Conv.conv(v, p);
            knots.add(v);

        }
        bspline.set(arr, degree, true);
        bspline.knots = knots;
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
