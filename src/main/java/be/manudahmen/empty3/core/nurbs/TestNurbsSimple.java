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
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;

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
