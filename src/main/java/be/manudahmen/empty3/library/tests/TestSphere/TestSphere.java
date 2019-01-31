/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.TestSphere;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetStub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestSphere extends TestObjetStub {
    public int size = 10;
    public double taille = 0.2;
    public double incrlong = 0.001;
    public double incrlat = 0.001;
    private double[] longpc;
    private double[] latpc;
    private double[][] incrpc;
    private TRISphere[] s;

    public static void main(String[] args) {
        TestSphere ts = new TestSphere();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(true);

        ts.setMaxFrames(1);

        new Thread(ts).start();


    }

    @Override
    public void ginit() {
        longpc = new double[size];
        latpc = new double[size];
        incrpc = new double[size][2];
        for (int i = 0; i < size; i++) {
            longpc[i] = 0;
            latpc[i] = 0;
            incrpc[i][0] = Math.random() * 0.1;
            incrpc[i][1] = Math.random() * 0.1;
        }

        s = new TRISphere[size - 1];

        for (int i = 0; i < s.length; i++) {
            s[i] = new TRISphere(Point3D.O0, taille);
            try {
                s[i].texture(new ImageTexture(new ECBufferedImage(ImageIO.read(new File("C:\\Users\\Se7en\\Pictures\\manu2.jpg")))));
            } catch (IOException ex) {
                s[i].texture(new ColorTexture(Color.PINK));
                Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
            }
            scene().add(s[i]);
        }
    }

    public double longpc(int item) {
        longpc[item] += incrpc[item][0];
        return longpc[item];
    }

    public double latpc(int item) {
        latpc[item] += incrpc[item][1];
        return latpc[item];
    }

    @Override
    public void testScene() throws Exception {
        scene().cameraActive(new Camera(
                Trajectoires.sphere(longpc(0), latpc(0), incrlong),
                Trajectoires.sphere(longpc(0), latpc(0), incrlat)

        ));
        for (int i = 0; i < s.length; i++)
            s[i].setCentre(Trajectoires.sphere(longpc(i + 1), latpc(i + 1), 1.0));

    }
}
