package tests.courbes_bsplines;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.gdximports.gdx_BSplineCurve;
import be.manudahmen.empty3.core.testing.TestObjet;
import be.manudahmen.empty3.core.tribase.TubulaireN2;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestGDXBSpline1 extends TestObjet {
    private static final double INCR_PRECISION = 0.00001;
    TubulaireN2 t ;
    private gdx_BSplineCurve b;

    public static void main(String[] args) {
        TestGDXBSpline1 ts = new TestGDXBSpline1();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(false);

        ts.setMaxFrames(10);

        new Thread(ts).start();

    }

    @Override
    public void finit() {

        b = new gdx_BSplineCurve();
        t = new TubulaireN2<>(b);

        b.getParameters().setIncrU(INCR_PRECISION);


        b.instantiate(TestsBSpline.p2(frame()), 6);

        b.texture(new TextureCol(Color.WHITE));

        t.curve(b);

        t.nbrAnneaux((int) (1 / INCR_PRECISION));
        t.diam(1);
        t.nbrRotations(10);
        t.texture(new TextureCol(Color.WHITE));

        scene().add(t);

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
