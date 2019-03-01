/***
 Global license :


 author Manuel Dahmen <manuel.dahmen@gmail.com>

 Creation time 06-nov.-2014

 Updated 08/09/2015
 ***/


package tests.spheres;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Cube;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;
import tests.TestSphere.Trajectoires;

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

        ts.texture(new ColorTexture(Color.RED));
        c.texture(new ColorTexture(Color.BLUE));


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
