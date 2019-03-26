/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests.gradient;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.Plan3D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestTextureGradPlanTannoir extends TestObjetSub {
    private String moviefilename;
    TRI tri = null;
    TextGrad textGrad;

    private TestTextureGradPlanTannoir(String arg) {
        moviefilename = arg;
    }

    public static void testing(String arg) {

        TestTextureGradPlanTannoir to;

        to = new TestTextureGradPlanTannoir(arg);
        to.moviefilename = arg;

        to.setMaxFrames(25 * 60 * 120);
        to.loop(true);

        new Thread(to).start();
    }

    public static void main(String[] args) {
        String arg = "samples/mov/tannoir.mp4";
        if (args.length > 0) {
            arg = args[0];
        }
        testing(arg);

    }

    @Override
    public void ginit() {
        textGrad = new TextGrad("samples/mov/tannoir.mp4");
        Plan3D plan3d = new Plan3D();
        plan3d.pointOrigine(new Point3D(-100, -100, 0));
        plan3d.pointYExtremite(new Point3D(-100, 100, 0));
        plan3d.pointXExtremite(new Point3D(100, -100, 0));
        plan3d.texture(textGrad);
        scene().cameraActive(new Camera(Point3D.Z.mult(200), Point3D.O0));
        scene().add(plan3d);
    }

    @Override
    public void testScene() throws Exception {
        textGrad.nextFrame();
    }

    @Override
    public void finit() {
    }

}
