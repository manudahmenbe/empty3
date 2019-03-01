/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.videotexture;


import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRIBezier2D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
class TestVideoTextureB2 extends TestObjetSub {
    public String moviefilename;
    TRI tri = null;
    VideoTexture videoTexture;

    private TestVideoTextureB2(String arg) {
        moviefilename = arg;
    }

    public static void testing(String arg) {
        TestObjetSub to;
        to = new TestVideoTextureB2(arg);
        to.setMaxFrames(25 * 60 * 120);
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
        Point3D[][] controle = new Point3D[][]
                {
                        {P.n(-100, -100, 0), P.n(-100, -33, 0), P.n(-100, 33, 0), P.n(-100, 100, 0)},
                        {P.n(-33, -100, 0), P.n(-33, -33, 0), P.n(33, 33, 0), P.n(100, 100, 0)},
                        {P.n(33, -100, 0), P.n(33, -33, 0), P.n(33, 33, 0), P.n(33, 100, 0)},
                        {P.n(100, -100, 0), P.n(100, -33, 0), P.n(100, 33, 0), P.n(100, 100, 0)}
                };
        TRIBezier2D b2 = new TRIBezier2D(new BezierCubique2D(controle));

        scene().add(b2);
    }

    @Override
    public void testScene() throws Exception {
        videoTexture.nextFrame();
    }

    @Override
    public void finit() {

    }

}
