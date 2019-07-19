/***

Empty3
Copyright (C) 2010-2019  Manuel DAHMEN

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package one.empty3.library.core.nurbs;

import one.empty3.library.Camera;
import one.empty3.library.Matrix33;
import one.empty3.library.Point3D;

/**
 * @author Manuel Dahmen
 */
public class CameraInPath extends Camera {
    private double angleA = 0;
    private double angleB = 0;

    /**
     * Need to get a position of the camera since it's a Z-axis
     * Rotate, position angles around the camera.
     */
    public void rotateSphere(double angleARad, double angleBRad) {
        this.angleA = angleARad;
        this.angleB = angleBRad;
    }

    private ParametricCurve courbe;
    private double t;

    public CameraInPath(ParametricCurve maCourbe) {
        this.courbe = maCourbe;
        getDeclaredPoints().put("eye/eye", eye);
        getDeclaredPoints().put("lookat/lookAt", lookat);
        getDeclaredArray1dDouble().put("matrice/matrice", matrice.getDoubles());
        getDeclaredRepresentables().put("courbe/courbe", maCourbe);
    }

    public ParametricCurve getCourbe() {
        return courbe;
    }

    public void setCourbe(ParametricCurve maCourbe) {
        this.courbe = maCourbe;
    }


    public void calculerMatriceT(Point3D verticale) {
        setEye(courbe.calculerPoint3D(t));
        setLookat(courbe.calculerPoint3D(t + t * 1.001));
        Point3D dt1 = getLookat().moins(getEye()).norme1();
        Point3D dt2 = getEye().moins(courbe.calculerPoint3D(t - t * 0.001)).norme1();
        Point3D n = dt2.moins(dt1).norme1();
        super.calculerMatrice(verticale == null ? n : verticale);
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
        calculerMatriceT(null);
    }

    @Override
    public Point3D calculerPointDansRepere(Point3D p) {
        return Matrix33.rot(angleA, angleB).mult(super.calculerPointDansRepere(p));
    }
}
