/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.dna;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestDH extends TestObjetSub {

    public static void main(String[] args) {
        TestDH dh = new TestDH();

        dh.loop(false);


        dh.setGenerate(GENERATE_MODEL);

        dh.setResx(1000);
        dh.setResy(1000);
        new Thread(dh).start();
    }

    @Override
    public void testScene() throws Exception {
        DoubleHelice1 doubleHelice1 = new DoubleHelice1(new double[]{20, 5, .2}, 2, new double[]{4, 8, 2}, 0);

        doubleHelice1.texture(new TextureCol(Color.RED));

        doubleHelice1.setMaxX(200);
        doubleHelice1.setMaxY(200);

        scene().add(doubleHelice1);

        /*doubleHelice1 = new DoubleHelice1(new double [] {8.8, 1.0, .2}, 2, new double[] {4, 8, 2}, 180);

        doubleHelice1.texture(new TextureCol(Color.RED));

        doubleHelice1.setMaxX(200);
        doubleHelice1.setMaxY(200);

        scene().add(doubleHelice1);
        */
        //Camera c = new Camera(Point3D.Z.mult(-20.0), Point3D.O0);

        //s//cene().lumieres().add(new LumierePonctuelle(Point3D.O0, Color.WHITE));

        //scene().cameraActive(c);

    }

}
