/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Atelier
 */
public class TestAnimSIB extends TestObjetSub {

    private double a;
    private double b;
    private Point3D pos;
    private TRISphere ts;
    private BezierCubique bc;
    private int n = 50;

    public TestAnimSIB() {
        super();
    }

    private static Point3D coordSphere(double a, double b, double radius) {
        return new Point3D(Math.cos(a) * Math.cos(b) * radius,
                0 + Math.cos(a) * Math.sin(b) * radius,
                0 + Math.sin(a) * radius);

    }

    public static void main(String[] args) {
        TestAnimSIB to = new TestAnimSIB();
        to.setResx(160);
        to.setResy(120);
        to.loop(true);
        to.setMaxFrames(1000);
        to.set3D(false);
        to.run();


    }

    private BezierCubique newBezier(BezierCubique old) {
        Point3D[] xy = new Point3D[4];
        if (old != null) {
            xy[0] = old.get(3);
        } else {
            xy[0] = new Point3D(Math.PI * (Math.random() - 0.5), Math.PI * 2 * (Math.random() - 0.5), 0);
        }
        for (int i = 1; i < 4; i++) {
            xy[i] = new Point3D(Math.PI * (Math.random() - 0.5), Math.PI * 2 * (Math.random() - 0.5), 0);
        }
        BezierCubique bc = new BezierCubique();
        for (int i = 0; i < 4; i++) {
            bc.add(xy[i]);
        }

        bc.texture(new TextureCol(Color.BLACK));

        return bc;
    }

    @Override
    public void ginit() {
        try {
            super.ginit();

            ts = new TRISphere(new Point3D(0, 0, 0), 100);
            ts.texture(
                    new TextureImg(new ECBufferedImage(ImageIO.read(getClass().getResource("cracked-earth-texture.jpg")))));
            scene().add(ts);
        } catch (IOException ex) {
            Logger.getLogger(TestAnimSIB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void testScene() {
        if (frame % n == 0 || bc == null) {
            bc = newBezier(bc);
        }
        a = bc.calculerPoint3D((1.0 * ((frame + n) % n)) / n).getX();
        b = bc.calculerPoint3D((1.0 * ((frame + n) % n)) / n).getY();
        if (a > Math.PI / 2) {
            a = Math.PI / 2;
        }
        if (a < -Math.PI / 2) {
            a = -Math.PI / 2;
        }
        if (b > Math.PI) {
            a = -Math.PI;
        }
        if (b < -Math.PI) {
            a = Math.PI;
        }

        pos = coordSphere(a, b, 90);

        scene().clear();
        scene().add(ts);

        Camera cam = new Camera(pos, new Point3D(0, 0, 0));

        Point3D[] mCam = new Point3D[3];

        mCam[0] = Point3D.vecteur(cam.getEye(), cam.getLookat()).norme1();
        mCam[1] = mCam[0].prodVect(Point3D.Y).norme1();
        mCam[2] = mCam[0].prodVect(mCam[1]);


        cam.imposerMatrice(new Matrix33(mCam));

        scene().cameraActive(cam);

        System.out.println(bc.toString());
        description("Textured sphere seen from inside");

    }

}
