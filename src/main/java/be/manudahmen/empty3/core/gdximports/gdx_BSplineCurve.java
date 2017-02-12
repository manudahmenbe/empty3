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

package be.manudahmen.empty3.core.gdximports;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;
import com.badlogic.gdx.math.BSpline;
import com.badlogic.gdx.math.Vector3;

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
