/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.cadeau;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetStub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SphereCube11 extends TestObjetStub {
    private final double t0 = -1;
    private final double t1 = 1;
    double d = 90;
    private TRISphere s;

    private double F = 3;
    private Camera cam;

    public static void main(String[] args) {


        SphereCube11 sc = new SphereCube11();

        sc.setMaxFrames(500);

        sc.loop(true);

        new Thread(sc).start();


    }

    @Override
    public void ginit() {

        Cube c;

        //c.texture(new TColor(Color.RED));
        c = new Cube(d / 10, Point3D.O0);


        c.texture(new ColorTexture(Color.BLUE));

        s = new TRISphere(Point3D.X.mult(t0), d / 10);

        s.texture(new TColor(Color.YELLOW));

        scene().add(c);
        scene().add(s);

        cam = new Camera(s.getCentre().mult(F), Point3D.O0);

        scene().cameraActive(cam);
    }

    @Override
    public void testScene() throws Exception {

        double pc = 1.0 * frame() / getMaxFrames();

        double TT;
        TT = t0 + (t1 - t0) * pc;

        s.setCentre(Point3D.X.mult(TT * d));

        cam.setEye(s.getCentre().plus(Point3D.Y.mult(d / 9)));
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
