/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.nurbs;

import be.manudahmen.emptycanvas.library.empty3.library.object.Camera;
import be.manudahmen.emptycanvas.library.empty3.library.object.ColorTexture;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;
import be.manudahmen.emptycanvas.library.empty3.library.testing.TestObjetSub;

import java.awt.*;
//import nurbs.Axes;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestNurbs2 extends TestObjetSub {

    public static void main(String[] args) {

        TestNurbs2 n = new TestNurbs2();

        n.setGenerate(GENERATE_MODEL | GENERATE_IMAGE);

        n.setMaxFrames(30);

        n.loop(true);

        new Thread(n).start();

    }

    public double mr() {
        return Math.random();

    }

    @Override
    public void testScene() throws Exception {
        scene().clear();

        NurbsSurface n = new NurbsSurface();
        n.setMaillage(new Point3D[][]{
                {
                        new Point3D(mr(), mr(), mr()),
                        new Point3D(mr(), mr(), mr()),
                        new Point3D(mr(), mr(), mr())},
                {
                        new Point3D(mr(), mr(), mr()),
                        new Point3D(mr(), mr(), mr()),
                        new Point3D(mr(), mr(), mr())},
                {
                        new Point3D(mr(), mr(), mr()),
                        new Point3D(mr(), mr(), mr()),
                        new Point3D(mr(), mr(), mr())}
        }, new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        n.setDegreU(3);
        n.setDegreV(3);

        n.setReseauFonction(new double[][]{
                {0, 0, 0, 0.5, 1, 1, 1},
                {0, 0, 0, 0.5, 1, 1, 1}
        });

        n.texture(new ColorTexture(Color.WHITE));

        n.setStartU(0);
        n.setStartV(0);
        n.setEndU(1);
        n.setEndV(1);
        n.setIncrU(0.01);
        n.setIncrV(0.01);

        n.creerNurbs();

        scene().add(n);
        System.out.println(n);

        scene().cameraActive(new Camera(Point3D.Z.mult(-1), Point3D.O0));
    }

    @Override
    public void finit() {
    }

    @Override
    public void ginit() {
    }
}
