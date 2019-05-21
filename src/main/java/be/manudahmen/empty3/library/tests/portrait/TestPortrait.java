/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.tests.portrait;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestPortrait extends TestObjetSub {

    public static void main(String[] args) {
        TestPortrait tp = new TestPortrait();
        tp.loop(false);
        tp.run();
    }

    @Override
    public void testScene() throws Exception {

        Cube c1 = new Cube(2.0, new Point3D(0, 0, 0), new TextureCol(Color.RED));

        Cube c2 = new Cube(1.5, new Point3D(1, 1, 0), new TextureCol(Color.YELLOW));

        Cube cy1 = new Cube(0.5, new Point3D(2.1, 0, 0), new TextureCol(Color.GREEN));
        Cube cy2 = new Cube(0.5, new Point3D(2.1, 1, 1), new TextureCol(Color.GREEN));

        Cube c3 = new Cube(1, new Point3D(2, 2, 0), new TextureCol(Color.WHITE));

        TRISphere ts = new TRISphere(new Point3D(0, 6, -5), 4);

        ts.texture(new TextureCol(Color.WHITE));

        scene().add(ts);

        Camera c = new Camera(new Point3D(10, 10, 10), Point3D.O0);

        scene().add(new LineSegment(Point3D.O0, Point3D.X.mult(10), new TextureCol(Color.RED)));
        scene().add(new LineSegment(Point3D.O0, Point3D.X.mult(10), new TextureCol(Color.RED)));
        scene().add(new LineSegment(Point3D.O0, Point3D.Y.mult(10), new TextureCol(Color.GREEN)));
        scene().add(new LineSegment(Point3D.O0, Point3D.Z.mult(10), new TextureCol(Color.BLUE)));
        scene().add(new TRI(new Point3D(3.1, 3, -1), new Point3D(3.1, 1, -1), new Point3D(3.1, 3, 1), new TextureCol(Color.WHITE)));

        scene().add(c1);
        scene().add(c2);
        scene().add(cy1);
        scene().add(cy2);
        scene().add(c3);
        scene().cameraActive(c);
        scene().lumieres()
                .add(
                        new LumierePonctuelle(new Point3D(5, 20, 5), Color.MAGENTA));
        scene().lumieres()
                .add(
                        new LumierePonctuelle(new Point3D(20, 0, 0), Color.CYAN));
    }

    @Override
    public void finit() {

    }

    @Override
    public void ginit() {

    }
}
