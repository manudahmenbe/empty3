/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.nurbs;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.move.Trajectoires;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestNurbsComplexeMy extends TestObjetSub {

    private final double[][] longpc = new double[4][4];
    private final double[][] latpc = new double[4][4];
    Point3D[][] pp;

    public static void main(String[] args) {

        TestNurbsComplexeMy n = new TestNurbsComplexeMy();

        n.setGenerate(GENERATE_MODEL | GENERATE_IMAGE);

        n.setMaxFrames(200);

        n.loop(true);

        new Thread(n).start();

    }

    public void changeValue(int i, int j) {
        longpc[i][j] = longpc[i][j] + Math.random() / 100;
        latpc[i][j] = latpc[i][j] + Math.random() / 100;
        pp[i][j] = Trajectoires.sphere(longpc[i][j], latpc[i][j], pp[i][j].norme());
    }

    public void updateValues(Point3D[][] ppp) {
        for (int i = 0; i < ppp.length; i++) {
            for (int j = 0; j < ppp[i].length; j++) {
                changeValue(i, j);
            }
        }
    }

    @Override
    public void ginit() {
        pp = new Point3D[][]{{
                new Point3D(-15.0, 0.0, 15.0),
                new Point3D(-15.0, 5.0, 5.0),
                new Point3D(-15.0, 5.0, -5.0),
                new Point3D(-15.0, 0.0, -15.0)
        }, {
                new Point3D(-5.0, 5.0, 15.0),
                new Point3D(-5.0, 10.0, 5.0),
                new Point3D(-5.0, 10.0, -5.0),
                new Point3D(-5.0, 5.0, -15.0)
        }, {
                new Point3D(5.0, 5.0, 15.0),
                new Point3D(5.0, 10.0, 5.0),
                new Point3D(5.0, 10.0, -5.0),
                new Point3D(5.0, 0.0, -15.0)
        }, {
                new Point3D(15.0, 0.0, 15.0),
                new Point3D(15.0, 5.0, 5.0),
                new Point3D(15.0, 5.0, -5.0),
                new Point3D(15.0, 0.0, -15.0)
        }
        };
    }

    @Override
    public void testScene() throws Exception {
        scene().clear();

        updateValues(pp);
        NurbsSurface n = new NurbsSurface();

        n.setMaillage(pp, new double[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}});

        n.setDegreU(3);
        n.setDegreV(3);

        n.setReseauFonction(new double[][]{
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
        });

        n.texture(new TextureCol(Color.WHITE));

        n.setMaxX(30);
        n.setMaxY(30);

        n.creerNurbs();

        scene().add(n);
        System.out.println(n);

        scene().cameraActive(new Camera(Point3D.Z.mult(-30), Point3D.O0));
    }

    @Override
    public void finit() {
    }
}
