/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * Creation time 17-sept.-2014
 * <p>
 * *
 */
package be.manudahmen.empty3.library.tests.nurbs;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.SurfaceParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.testing.TestObjetStub;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SurfaceBezier extends TestObjetStub {

    public static void main(String[] arg) {
        SurfaceBezier t1 = new SurfaceBezier();
        t1.loop(false);
        new Thread(t1).start();
    }

    @Override
    public void testScene() {
        Point3D[][] p = new Point3D[9][9];
        int m = 0;
        for (int i = -4; i <= 4; i++) {
            int n = 0;
            for (int j = -4; j <= 4; j++) {
                p[m][n] = new Point3D(i, j, 0);
                n++;
            }
            m++;
        }
        SurfaceParametriquePolynomialeBezier surfaceParametriquePolynomialeBezier = new SurfaceParametriquePolynomialeBezier(p);
        boolean add = scene().add(surfaceParametriquePolynomialeBezier);
        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0));

    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
