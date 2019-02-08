package tests.trihole;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.LumierePonctuelle;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.extra.Polyhedron;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.awt.*;

/**
 * @author Se7en
 */
public class TestTriHole extends TestObjetStub {
    private Polyhedron th;
    private Polyhedron th2;

    public TestTriHole() {
    }

    public static void main(String[] ar) {
        TestTriHole tth = new TestTriHole();

        tth.loop(true);
        tth.setResx(2000);
        tth.setResy(1500);

        tth.setMaxFrames(25 * 10);

        new Thread(tth).start();
    }

    @Override
    public void ginit() {
        th = new Polyhedron();

        th.texture(new ColorTexture(Color.GREEN));

        scene().add(th);

        scene().cameraActive(new Camera(Point3D.Z.mult(-2), Point3D.O0));
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.O0, Color.YELLOW);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.BLUE);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);


        th2 = new Polyhedron();

        th2.texture(new ColorTexture(Color.RED));

        scene().add(th2);


    }

    @Override
    public void testScene() throws Exception {
        th.add(new Point3D(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5));
        th2.add(new Point3D(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5));

        //exportFrame("stl", "Polyhedre"+frame()+".stl");

    }

    @Override
    public void finit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
