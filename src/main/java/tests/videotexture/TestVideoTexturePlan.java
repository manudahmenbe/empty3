/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests.videotexture;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.VideoTexture;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.Plan3D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestVideoTexturePlan extends TestObjetSub {
    public String moviefilename;
    TRI tri = null;
    VideoTexture videoTexture;

    private TestVideoTexturePlan(String arg) {
        moviefilename = arg;
    }

    public static void testing(String arg) {
        TestObjetSub to;
        to = new TestVideoTexturePlan(arg);
        to.setMaxFrames(25 * 60 * 120);
        to.setResx(600);
        to.setResy(400);
        to.loop(true);

        new Thread(to).start();
    }

    public static void main(String[] args) {
        String arg = "F:\\Bibliothèque Portable\\Films\\Cinema anglais" + "\\" + "Sailor.Et.Lula.1990.FRENCH.BRRiP.XViD.AC3-HuSh.avi";
        if (args.length > 0) {
            arg = args[0];
        }
        testing(arg);

    }

    @Override
    public void ginit() {
        videoTexture = new VideoTexture(moviefilename);
        Plan3D plan3d = new Plan3D();
        plan3d.pointOrigine(new Point3D(-100, -100, 0));
        plan3d.pointYExtremite(new Point3D(-100, 100, 0));
        plan3d.pointXExtremite(new Point3D(100, -100, 0));
        plan3d.texture(videoTexture);
        scene().add(plan3d);
    }

    @Override
    public void testScene() throws Exception {
        videoTexture.nextFrame();
    }

    @Override
    public void finit() {

    }

}
