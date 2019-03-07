/***
 * ect 14-08-17 Copyright.
 */

package be.manudahmen.empty3.library.tests;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.nurbs.SurfaceParametricPolygonalBezier;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestThierryJaspart extends TestObjetSub {
    private final Point3D[][] coeff = new Point3D[][]{
            {Point3D.P.n(2., -2, 0), Point3D.P.n(2, -1, 0), Point3D.P.n(2, 0, 0), Point3D.P.n(2, 1, 0), Point3D.P.n(2, 2, 0)},
            {Point3D.P.n(1, -2, 0), Point3D.P.n(1, -1, 0), Point3D.P.n(1, 0, 0), Point3D.P.n(1, 1, 0), Point3D.P.n(1, 2, 0)},
            {Point3D.P.n(0, -2, 0), Point3D.P.n(0, -1, 0), Point3D.P.n(0, 0, 0), Point3D.P.n(0, 1, 0), Point3D.P.n(0, 2, 0)},
            {Point3D.P.n(-1, -2, 0), Point3D.P.n(-1, -1, 0), Point3D.P.n(-1, 0, 0), Point3D.P.n(-1, 1, 0), Point3D.P.n(-1, 2, 0)},
            {Point3D.P.n(-2, -2, 0), Point3D.P.n(-2, -1, 0), Point3D.P.n(-2, 0, 0), Point3D.P.n(-2, 1, 0), Point3D.P.n(-2, 2, 0)}
    };
    ITexture texture;
    private SurfaceParametricPolygonalBezier s = new SurfaceParametricPolygonalBezier(coeff);

    public TestThierryJaspart() {
        setMaxFrames(25 * 60 * 5);
        setResx(1024);
        setResy(480);
    }


    @Override
    public void testScene(File f) {
    }

    @Override
    public void ginit() {
        s.texture(texture);
        scene().add(s);
        scene().cameraActive().setEye(Point3D.Z.mult(-20));
        try {
            texture = new ImageTexture(ECBufferedImage.getFromFile(
                    new File("samples/img/thierry-jaspart-catch-a-moustache-saint-gilles-bruxelles-clara-gnagna-vintage-comic-strip-wrestling-duck-pom-pom-girl.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.setIncrU(0.1);
        s.setIncrV(0.1);
        s.texture(texture);
    }


    @Override
    public void testScene() {
        for (int i = 0; i < s.getCoefficients().length; i++)
            for (int j = 0; j < s.getCoefficients()[i].length; j++) {
                Point3D point3D = Point3D.random2(0.1);
                for (int k = 0; k < 3; k++)
                    s.getCoefficients()[i][j].set(k, s.getCoefficients()[i][j].get(k) + point3D.get(k));
            }
    }


    @Override
    public void finit() throws Exception {
        super.finit();
        scene().texture(new ColorTexture(Color.WHITE));

    }

    public static void main(String[] args) {
        new Thread(new TestThierryJaspart()).start();


    }
}
