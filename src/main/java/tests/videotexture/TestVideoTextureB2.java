/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests.videotexture;


import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRIBezier2D;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
class TestVideoTextureB2 extends TestObjetSub {
    public String moviefilename;
    TRI tri = null;
    TextureMov textureMov;

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
        String arg = "samples/mov/tannoir.mp4";
        if (args.length > 0) {
            arg = args[0];
        }
        testing(arg);

    }

    @Override
    public void ginit() {
        textureMov = new TextureMov(moviefilename);
        Point3D[][] control = new Point3D[][]
                {
                        {P.n(-100, -100, 0), P.n(-100, -33, 0), P.n(-100, 33, 0), P.n(-100, 100, 0)},
                        {P.n(-33, -100, 0), P.n(-33, -33, 0), P.n(33, 33, 0), P.n(100, 100, 0)},
                        {P.n(33, -100, 0), P.n(33, -33, 0), P.n(33, 33, 0), P.n(33, 100, 0)},
                        {P.n(100, -100, 0), P.n(100, -33, 0), P.n(100, 33, 0), P.n(100, 100, 0)}
                };
        TRIBezier2D b2 = new TRIBezier2D(new BezierCubique2D(control));
        b2.texture(textureMov);
        scene().add(b2);
        scene().cameraActive(new Camera(Point3D.Z.mult(200), Point3D.O0));
    }

    @Override
    public void testScene() throws Exception {
        textureMov.nextFrame();
    }

    @Override
    public void finit() {

    }

}
