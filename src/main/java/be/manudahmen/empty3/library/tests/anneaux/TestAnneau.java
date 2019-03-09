package be.manudahmen.empty3.library.tests.anneaux;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.move.Trajectoires;
import be.manudahmen.empty3.core.nurbs.CourbeParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.testing.TestObjet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestAnneau extends TestObjet {

    private int N = 20;
    List<Point3D> point3DS = new ArrayList<>();
    private double latLat = 0.3;
    private CourbeParametriquePolynomialeBezier courbeParametriquePolynomialeBezier;

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {

    }


    @Override
    public void ginit() {
    }

    @Override
    public void afterRender() {

    }

    @Override
    public void testScene() throws Exception {
        double lgt = 0;
        for (int i = 0; ; i++) {
            Point3D sphere = Trajectoires.sphere(lgt, Math.random() / latLat, 1);
            point3DS.add(sphere);
            lgt += Math.random() / N;
            if (lgt > 1) {
                lgt = 1;
                break;
            }
        }
        Point3D[] ds = new Point3D[this.point3DS.size()];
        courbeParametriquePolynomialeBezier = new CourbeParametriquePolynomialeBezier(this.point3DS.toArray(ds));
        scene().add(courbeParametriquePolynomialeBezier);

        courbeParametriquePolynomialeBezier.texture(new TextureCol(Color.BLUE));
        courbeParametriquePolynomialeBezier.incr = 0.0001;
        camera(new Camera(Point3D.Z.mult(3), Point3D.O0));
    }


    public static void main(String... args) {
        TestAnneau testAnneau = new TestAnneau();
        Thread thread = new Thread(testAnneau);
        testAnneau.setMaxFrames(25 * 60 * 5);
        thread.start();
    }
}
