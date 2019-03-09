package be.manudahmen.empty3.library.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;


/**
 * Created by manuel on 03-10-15.
 */
class Forme extends ParametricSurface {
    public Point3D P0 = Point3D.O0;

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D p = be.manudahmen.empty3.core.move.Trajectoires.sphere(u, v, 1);
        return p.moins(P0).mult(Math.pow(p.moins(P0).norme(), 2) * Math.exp(1 * Point3D.distance(P0, p) * Point3D.distance(P0, p)) * u * v);
    }

    @Override
    public Point3D calculerVitesse3D(double v, double v1) {
        return null;
    }
}

public class TriTest extends TestObjetSub {

    private Forme f;

    public static void main(String[] args) {
        TriTest test = new TriTest();
        test.setMaxFrames(100);
        test.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        new Thread(test).start();
    }

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {

    }

    @Override
    public void ginit() {
        f = new Forme();
        f.texture(new TextureCol(Color.BLUE));
        scene().add(f);
    }

    public void afterRender() {

    }

    @Override
    public void testScene() throws Exception {
        scene().cameraActive(new Camera(Point3D.Z.mult(-100 + 100 * ((float) frame) / getMaxFrames()), Point3D.O0));

    }

}
