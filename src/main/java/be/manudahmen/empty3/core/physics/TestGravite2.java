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

package be.manudahmen.empty3.core.physics;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.extra.Polyhedre;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

public class TestGravite2 extends TestObjetSub {
    int X = 2;
    int Y = 2;
    int Z = 2;
    Bille[] billes = new Bille[X * Y * Z];
    Force f = new Force();

    public static void main(String[] args) {

        TestGravite2 ttn = new TestGravite2();

        ttn.setResx(190);
        ttn.setResy(98);
        ttn.loop(true);
        ttn.setMaxFrames(10000);
        ttn.publishResult(true);
        ttn.setFileExtension("jpg");

        ttn.run();

    }

    public void ginit() {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < Z; k++) {

                    billes[k * Y * X + j * X + i] = new Bille();
                    billes[k * Y * X + j * X + i].position = new Point3D(
                            (i - X / 2) / 1f, (j - Y / 2) / 1f,
                            (k - Z / 2) / 1f);
                    billes[k * Y * X + j * X + i].vitesse = new Point3D(
                            (i - X / 2) / 1f, (j - Y / 2) / 1f,
                            (k - Z / 2) / 1f);
                    billes[k * Y * X + j * X + i].color = new Color(1.0f * i
                            / X, 1.0f * j / Y, 1.0f * k / Z);
                    billes[k * Y * X + j * X + i].masse = 1;
                    billes[k * Y * X + j * X + i].attraction = 1;
                    billes[k * Y * X + j * X + i].repulsion = 0.1;
                    billes[k * Y * X + j * X + i].amortissement = 0.2;
                }
            }

        }

        f.configurer(billes);
    }

    public void testScene() {
        scene().clear();


        f.calculer();


        RepresentableConteneur rc = new RepresentableConteneur();

        Polyhedre polyhedre = new Polyhedre();
        for (int i = 0; i < X * Y * Z; i++) {
            Representable r = new TRISphere(billes[i].position, f.getDistMin() / 4);

            ((TRISphere) r).setMaxX(7);
            ((TRISphere) r).setMaxY(7);

            r.texture(new ColorTexture(billes[i].color));

            rc.add(r);

            polyhedre.add(billes[i].position);
        }

        Camera camera = new Camera(f.centreMasse().plus(
                new Point3D(0, 0, -f.getDistMax() * 4)), f.centreMasse());

        System.out.println(rc.getListRepresentable().size());

        scene().cameraActive(camera);

        // scene().add(rc);

        scene().add(polyhedre);

    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
