/*

    Vous êtes libre de :

*/

package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ECBufferedImage;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TColor;
import be.manudahmen.empty3.core.testing.TestObjetStub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel DAHMEN
 * @date
 */
public class TestSphere extends TestObjetStub {

    public static void main(String[] args) {
        TestSphere ts = new TestSphere();
        ts.run();
    }

    @Override
    public void testScene() {
        TRISphere s;
        s = new TRISphere(Point3D.X.mult(3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        s = new TRISphere(Point3D.X.mult(-3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        s = new TRISphere(Point3D.Y.mult(3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        s = new TRISphere(Point3D.Y.mult(-3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        scene().cameraActive(new Camera(new Point3D(0, 0, -4), new Point3D(0, 0, 0)));

        description = "4 be.manudahmen.empty3.library.tests.spheres with textures";
    }
}
