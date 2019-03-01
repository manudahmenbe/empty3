/*
 * 2013 Manuel Dahmen
 */
package tests.triangles;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

public class TestTriangles extends TestObjetSub {

    public TestTriangles() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TestTriangles tt = new TestTriangles();
        tt.loop(true);
        tt.setMaxFrames(5);
        tt.setResx(1024);
        tt.setResy(768);
        tt.run();
    }

    @Override
    public void testScene() throws Exception {
        scene().clear();


        SiPiKi3D si = new SiPiKi3D();


        si.add(new TRI(Point3D.O0, Point3D.X, Point3D.Y, Color.BLUE), frame);

        scene().add(si);

        scene().cameraActive(new Camera(new Point3D(0.5, 0.5, -1.2), new Point3D(0.5, 0.5, 0)));
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
