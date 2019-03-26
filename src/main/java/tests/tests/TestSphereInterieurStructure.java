/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.tests;

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
public class TestSphereInterieurStructure extends TestObjetSub {
    public static void main(String[] args) {
        TestSphereInterieurStructure to = new TestSphereInterieurStructure();
        to.setStructure(true);
        to.run();
    }

    @Override
    public void testScene() {
        try {
            setResx(1200);
            setResy(1000);
            TRISphere ts = new TRISphere(new Point3D(0, 0, 0), 100);

            ts.texture(new TextureImg(new ECBufferedImage(ImageIO.read(getClass().getResource("Coucherdesoleil.jpg")))));
            ts.setMaxY(200);
            ts.setMaxY(200);
            scene().add(ts);

            scene().cameraActive(new Camera(new Point3D(0, 0, -200), new Point3D(0, 0, 0)));
            description("Textured sphere seen from inside");
        } catch (IOException ex) {
            Logger.getLogger(TestSphereInterieurStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
