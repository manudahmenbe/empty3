package be.manudahmen.empty3.library.tests.courbes_bsplines;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.gdximports.gdx_BSplineCurve;
import be.manudahmen.empty3.core.testing.TestObjet;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestGDXBSpline extends TestObjet {
    private static final double INCR_NBR_OF_SEGMENTS = 0.00001;
    private gdx_BSplineCurve b;

    public static void main(String[] args) {
        TestGDXBSpline ts = new TestGDXBSpline();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(false);

        ts.setMaxFrames(10);

        new Thread(ts).start();

    }

    @Override
    public void finit() {
        scene().clear();

        b = new gdx_BSplineCurve();

        b.incr = INCR_NBR_OF_SEGMENTS;


        b.instantiate(TestsBSpline.p2(frame()), 3);

        b.texture(new TextureCol(Color.WHITE));

        scene().add(b);

        scene.cameraActive().setEye(Point3D.Z.mult(-(2 * frame() + 2)));

    }

    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void ginit() {
    }

    @Override
    public void testScene() throws Exception {
    }

    public void afterRender() {
    }
}
