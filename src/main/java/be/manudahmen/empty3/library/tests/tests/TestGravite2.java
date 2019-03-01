package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.physics.Bille;
import be.manudahmen.empty3.core.physics.Force;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

public class TestGravite2 extends TestObjetSub {
    int X = 4;
    int Y = 4;
    int Z = 4;
    Bille[] billes = new Bille[X * Y * Z];
    Force f = new Force();

    public static void main(String[] args) {

        TestGravite2 ttn = new TestGravite2();

        ttn.setResx(640);
        ttn.setResy(480);
        ttn.loop(true);
        ttn.setMaxFrames(3000);
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

        for (int i = 0; i < X * Y * Z; i++) {
            Representable r = new TRISphere(billes[i].position, f.getDistMin() / 4);

            ((TRISphere) r).setMaxX(20);
            ((TRISphere) r).setMaxY(20);

            r.texture(new TColor(billes[i].color));

            rc.add(r);

            //polyhedre.add(billes[i].be.manudahmen.empty3.library.tests.position);
        }

        Camera camera = new Camera(f.centreMasse().plus(
                new Point3D(0, 0, -f.getDistMax() * 0.3)), f.centreMasse());

        //System.out.println(rc.getListRepresentable().size());

        scene().cameraActive(camera);

        scene().add(rc);

        //scene().add(polyhedre);

    }

}
