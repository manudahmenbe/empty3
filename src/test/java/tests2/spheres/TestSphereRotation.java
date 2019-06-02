/***
 Global license :


 author Manuel Dahmen <manuel.dahmen@gmail.com>

 Creation time 06-nov.-2014

 Updated 08/09/2015
 ***/


package tests2.spheres;

import one.empty3.library.Camera;
import one.empty3.library.Cube;
import one.empty3.library.Point3D;
import one.empty3.library.TextureCol;
import one.empty3.library.core.move.Trajectoires;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.TRISphere;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestSphereRotation extends TestObjetSub {
    TRISphere ts;

    public static void main(String[] args) {
        TestSphereRotation tsr = new TestSphereRotation();

        tsr.loop(true);
        tsr.setMaxFrames(300);
        tsr.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        tsr.unterminable(false);
        new Thread(tsr).start();


    }

    @Override
    public void ginit() {
        ts = new TRISphere(Point3D.O0, 1);
        ts.setMaxX(400);
        ts.setMaxY(400);
        Cube c = new Cube(0.7, Point3D.O0);

        ts.texture(new TextureCol(Color.RED));
        c.texture(new TextureCol(Color.BLUE));


        scene().add(ts);
        scene().add(c);
    }

    @Override
    public void testScene() throws Exception {
        Point3D sphere = Trajectoires.sphere(1.0 * frame() / getMaxFrames(),
                0, 5);
        scene().cameras().clear();
        scene().cameraActive(new Camera(sphere, Point3D.O0));

    }

    @Override
    public void finit() {

    }


}
