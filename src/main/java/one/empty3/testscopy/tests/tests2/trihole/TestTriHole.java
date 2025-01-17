package one.empty3.testscopy.tests.tests2.trihole;

import one.empty3.library.Camera;
import one.empty3.library.LumierePonctuelle;
import one.empty3.library.Point3D;
import one.empty3.library.TextureCol;
import one.empty3.library.core.extra.Polyhedron;
import one.empty3.library.core.testing.TestObjetSub;

import java.awt.*;

/*__
 * @author Se7en
 */
public class TestTriHole extends TestObjetSub {
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

        th.texture(new TextureCol(Color.GREEN));

        scene().add(th);

        scene().cameraActive(new Camera(Point3D.Z.mult(-2d), Point3D.O0));
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.O0, Color.YELLOW);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.BLUE);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);


        th2 = new Polyhedron();

        th2.texture(new TextureCol(Color.RED));

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
