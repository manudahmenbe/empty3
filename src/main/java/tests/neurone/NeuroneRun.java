/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.neurone;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * @author Se7en
 */
public class NeuroneRun extends TestObjetSub {
    Neurone[] neurones;

    public NeuroneRun() {
    }

    public static void main(String[] args) {
        NeuroneRun nr = new NeuroneRun();
        nr.loop(true);

        nr.run();
    }

    @Override
    public void ginit() {
        neurones = new tests.neurone.NeuronePoint[100];

        for (int x = 0; x < 10; x++)
            for (int y = 0; y < 10; y++) {
                neurones[x * 10 + y] = new tests.neurone.NeuronePoint();
                ((tests.neurone.NeuronePoint) (neurones[x * 10 + y]))
                        .objet = new Point3D(x - 5, y - 5, 0).mult(1000);
            }
    }

    @Override
    public void testScene() throws Exception {
        scene().clear();


        tests.neurone.NeuronePoint.dmax = -1;


        Neurone.sortie(neurones);


        Point3D O = Point3D.O0;


        int n = 0;
        for (int x = 0; x < 10; x++)
            for (int y = 0; y < 10; y++) {
                Point3D p0 = (Point3D) neurones[x * 10 + y].objet;

                p0.texture(new ColorTexture(Color.WHITE));

                O = O.plus(p0);

                TRISphere s = new TRISphere(p0, 1);

                s.texture(new ColorTexture(Color.WHITE));

                scene().add(s);

                n++;
            }

        O = O.mult(1.0 / n);
        System.out.println("Dist: " + tests.neurone.NeuronePoint.dmax);
       /* scene().cameraActive(
                new Camera(
                O.moins(Point3D.Z.mult(-NeuronePoint.dmax*2)),
                O));
        */
        scene().cameraActive(
                new Camera(
                        Point3D.Z.mult(tests.neurone.NeuronePoint.dmax * 4),
                        Point3D.O0));
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
