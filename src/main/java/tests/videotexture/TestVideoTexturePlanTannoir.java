/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests.videotexture;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.TextureMov;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.Plan3D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestVideoTexturePlanTannoir extends TestObjetSub {
    public String moviefilename;
    TRI tri = null;
    TextureMov textureMov;

    private TestVideoTexturePlanTannoir(String arg) {
        moviefilename = arg;
    }

    public static void testing(String arg) {

        TestVideoTexturePlanTannoir to;

        to = new TestVideoTexturePlanTannoir(arg);
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
        textureMov = new TextureMov("samples/mov/tannoir.mp4");
        Plan3D plan3d = new Plan3D();
        plan3d.pointOrigine(new Point3D(-100, -100, 0));
        plan3d.pointYExtremite(new Point3D(-100, 100, 0));
        plan3d.pointXExtremite(new Point3D(100, -100, 0));
        plan3d.texture(textureMov);
        scene().cameraActive(new Camera(Point3D.Z.mult(200), Point3D.O0));
        scene().add(plan3d);
    }

    @Override
    public void testScene() throws Exception {
        textureMov.nextFrame();
    }

    @Override
    public void finit() {
    }

}
