package be.manudahmen.empty3.library.tests.position;

import be.manudahmen.empty3.Barycentre;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * @author Se7en
 */
public class TestTRISphere extends TestObjetSub {

    public TestTRISphere() {
    }

    public static void main(String[] args) {
        TestTRISphere ts = new TestTRISphere();
        ts.loop(false);
        ts.run();

    }

    @Override
    public void testScene() throws Exception {
        scene().cameraActive().eye().setZ(-10);

        TRISphere s = new TRISphere(Point3D.O0, 1);
        Barycentre barycentre = new Barycentre();
        barycentre.position = Point3D.Y.mult(5);

        s.position(barycentre);
        s.texture(new TextureCol(Color.WHITE));
        scene().add(s);

    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
