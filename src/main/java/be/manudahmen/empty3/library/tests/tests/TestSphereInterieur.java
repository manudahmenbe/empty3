/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ECBufferedImage;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TextureImg;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Atelier
 */
public class TestSphereInterieur extends TestObjetSub {
    public static void main(String[] args) {
        TestSphereInterieur to = new TestSphereInterieur();
        to.run();
    }

    @Override
    public void testScene() {
        try {
            //setResx(320);
            //setResy(200);
            TRISphere ts = new TRISphere(new Point3D(0, 0, 0), 100);

            ts.texture(new TextureImg(new ECBufferedImage(ImageIO.read(getClass().getResource("Coucherdesoleil.jpg")))));
            scene().add(ts);

            camera(new Camera(new Point3D(0, 0, -10), new Point3D(0, 0, 0)));
            description("Textured sphere seen from inside");
        } catch (IOException ex) {
            Logger.getLogger(TestSphereInterieur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
