/**
 * *
 * Global license :  *
 * CC Attribution
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.tests.beziers;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Point3D.P;
import be.manudahmen.empty3.VideoTexture;
import be.manudahmen.empty3.core.nurbs.SurfaceParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.io.File;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestBezierTextVideo extends TestObjetStub {

    private final Point3D[][] coeff = new Point3D[][]{
            {Point3D.P.n(2., -2, 0), P.n(2, -1, 0), P.n(2, 0, 0), P.n(2, 1, 0), P.n(2, 2, 0)},
            {P.n(1, -2, 0), P.n(1, -1, 0), P.n(1, 0, 0), P.n(1, 1, 0), P.n(1, 2, 0)},
            {P.n(0, -2, 0), P.n(0, -1, 0), P.n(0, 0, 0), P.n(0, 1, 0), P.n(0, 2, 0)},
            {P.n(-1, -2, 0), P.n(-1, -1, 0), P.n(-1, 0, 0), P.n(-1, 1, 0), P.n(-1, 2, 0)},
            {P.n(-2, -2, 0), P.n(-2, -1, 0), P.n(-2, 0, 0), P.n(-2, 1, 0), P.n(-2, 2, 0)}
    };
    VideoTexture videoTexture;
    private SurfaceParametriquePolynomialeBezier s = new SurfaceParametriquePolynomialeBezier(coeff);

    public TestBezierTextVideo() {
    }

    public static void main(String[] args) {

        TestBezierTextVideo tss = new TestBezierTextVideo();
        tss.setMaxFrames(2000);
        tss.setResx(1024);

        tss.setResy(480);
        tss.loop(true);
        tss.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        new Thread(tss).start();
    }

    @Override
    public void testScene(File f) throws Exception {
    }

    @Override
    public void ginit() {
        videoTexture = new VideoTexture("C:\\Emptycanvas\\textures\\Il embrasse sur la bouche.mp4");
        s.texture(videoTexture);
        scene().add(s);
        scene().cameraActive().setEye(Point3D.Z.mult(-6));
    }

    @Override
    public void finit() {
        videoTexture.nextFrame();
    }

    @Override
    public void testScene() throws Exception {

    }

}
