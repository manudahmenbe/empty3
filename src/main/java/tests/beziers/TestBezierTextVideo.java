/**
 * *
 * Global license :  *
 * CC Attribution
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package tests.beziers;

import be.manudahmen.empty3.EOFilmException;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Point3D.P;
import be.manudahmen.empty3.TextureMov;
import be.manudahmen.empty3.core.nurbs.SurfaceParametricPolygonalBezier;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestBezierTextVideo extends TestObjetSub {

    private final Point3D[][] coeff = new Point3D[][]{
            {P.n(2., -2, 0), P.n(2, -1, 0), P.n(2, 0, 0), P.n(2, 1, 0), P.n(2, 2, 0)},
            {P.n(1, -2, 0), P.n(1, -1, 0), P.n(1, 0, 0), P.n(1, 1, 0), P.n(1, 2, 0)},
            {P.n(0, -2, 0), P.n(0, -1, 0), P.n(0, 0, 0), P.n(0, 1, 0), P.n(0, 2, 0)},
            {P.n(-1, -2, 0), P.n(-1, -1, 0), P.n(-1, 0, 0), P.n(-1, 1, 0), P.n(-1, 2, 0)},
            {P.n(-2, -2, 0), P.n(-2, -1, 0), P.n(-2, 0, 0), P.n(-2, 1, 0), P.n(-2, 2, 0)}
    };
    TextureMov textureMov;
    private SurfaceParametricPolygonalBezier s;

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
    public void ginit() {
        scene().cameraActive().setEye(Point3D.Z.mult(-6));
        s = new SurfaceParametricPolygonalBezier(coeff);
        s.setIncrU(0.1);
        s.setIncrV(0.1);
        textureMov = new TextureMov(".\\samples\\mov\\tannoir.mp4");
        s.texture(textureMov);
        //s.texture(new TextureCol(Color.BLUE));
        scene().add(s);
    }

    @Override
    public void finit()throws Exception {
//        textureMov.nextFrame();
    }
}
