package be.manudahmen.empty3.library.tests.spherestournent;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetStub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * Created by Win on 24-01-16.
 */
public class TestSpheresTournent extends TestObjetStub {
    private TRISphere[] sps;
    private Trajectoire tr;
    private Matrix33[] matricess = new Matrix33[]{Matrix33.I, Matrix33.XYZ, Matrix33.YZX, Matrix33.ZXY};
    private Matrix33 matrix;

    public static void main(String[] args) {
        TestSpheresTournent ts = new TestSpheresTournent();

        ts.setMaxFrames(3000);

        new Thread(ts).start();
    }

    public void ginit() {
        sps = new TRISphere[1];

        int i = 0;
        for (i = 0; i < sps.length; i++) {
            sps[i] = new TRISphere(Point3D.X.mult(i), 1);

            sps[i].texture(new ColorTexture(Color.blue));
        }

        camera(new Camera(Point3D.Z.mult(-sps.length), Point3D.O0));
    }

    public void testScene() {


    }
}
