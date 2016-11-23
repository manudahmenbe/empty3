/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.nurbs;

import be.manudahmen.empty3.library.object.Camera;
import be.manudahmen.empty3.library.object.ColorTexture;
import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestNurbsSimple extends TestObjetSub {

    public static void main(String[] args) {

        TestNurbsSimple n = new TestNurbsSimple();

        n.setGenerate(GENERATE_MODEL | GENERATE_IMAGE);

        n.setMaxFrames(30);

        n.loop(true);

        new Thread(n).start();

    }

    @Override
    public void testScene() throws Exception {
        scene().clear();

        NurbsSurface n = new NurbsSurface();
        n.setMaillage(new Point3D[][]{
                        {
                                new Point3D(-1, -1, 0),
                                new Point3D(-1, 1, 0)
                        },
                        {
                                new Point3D(1, -1, 0),
                                new Point3D(1, 1, 0)}
                },
                new double[][]{
                        {1, 1},
                        {1, 1}
                });

        n.setDegreU(2);
        n.setDegreV(2);

        n.setReseauFonction(new double[][]{
                {0, 0, 1, 1},
                {0, 0, 1, 1}
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

        scene().cameraActive(new Camera(Point3D.Z.mult(-2), Point3D.O0));
    }

    @Override
    public void finit() {
    }

    @Override
    public void ginit() {
    }
}
