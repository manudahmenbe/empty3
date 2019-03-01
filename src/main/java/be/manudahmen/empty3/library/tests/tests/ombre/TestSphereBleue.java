package be.manudahmen.empty3.library.tests.tests.ombre;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

public class TestSphereBleue extends TestObjetSub {

    private static int N = 24 * 5;

    public static void main(String[] args) {
        TestSphereBleue ts = new TestSphereBleue();
        ts.loop(false);
        ts.setMaxFrames(N * 5);
        ts.publishResult(true);
        ts.run();
    }

    @Override
    public void testScene() {


        scene().clear();

        Color couleurLumiere = Color.RED;
        Point3D position =
                new Point3D(5, 5, -11);

        //Point3D.O0;
        Lumiere lp = new LumierePonctuelle(position, couleurLumiere);

        TRISphere sphere = new TRISphere(Point3D.O0, 10);
        TRISphere sphereL = new TRISphere(position, 2);
        TRISphere sphereI = new TRISphere(Point3D.O0, 9);

        TRISphere[] spheres = new TRISphere[]{sphere, sphereL, sphereI};

        for (TRISphere triSphere : spheres) {
            triSphere.setMaxX(100);
            triSphere.setMaxY(100);
        }
        sphere.texture(new ColorTexture(Color.BLUE));
        sphereI.texture(new ColorTexture(Color.GREEN));
        sphereL.texture(new ColorTexture(Color.YELLOW));
        scene().add(sphere);
        scene().add(sphereI);
        scene().add(sphereL);
        scene().cameraActive(new Camera(Point3D.Z.mult(-30), Point3D.O0));

        scene().lumieres().add(lp);

    }

    public class LumiereUtil {
        private double[][] coefficients;

        private void initCoefficients(int l) {
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {

                }
            }
        }

        public double calculer(double composante,
                               double[] composanteLumiere) {
            if (coefficients == null) {
                initCoefficients(1 + composanteLumiere.length);
            }
            return composante;

        }
    }
}
