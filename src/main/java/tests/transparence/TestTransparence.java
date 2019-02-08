/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests.transparence;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ECBufferedImage;
import be.manudahmen.empty3.ImageTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetStub;
import be.manudahmen.empty3.core.tribase.Plan3D;

import javax.imageio.ImageIO;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestTransparence extends TestObjetStub {

    public static void main(String[] ar) {
        TestTransparence tth = new TestTransparence();

        tth.loop(false);
        tth.setResx(2000);
        tth.setResy(1500);

        new Thread(tth).start();
    }

    @Override
    public void testScene() throws Exception {
        Plan3D plan3D = new Plan3D();
        plan3D.pointOrigine(new Point3D(-1, -1, 0));
        plan3D.pointXExtremite(new Point3D(1, 0, 0));
        plan3D.pointYExtremite(new Point3D(0, 1, 0));
        ImageTexture tColor = new ImageTexture(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("be.manudahmen.empty3.library.tests.cubes-be.manudahmen.empty3.library.tests.transparence.png"))));
        //tColor.setTransparent(Color.GREEN);
        plan3D.texture(tColor);

        scene().add(plan3D);
        scene().cameraActive(new Camera(Point3D.Z.mult(3), Point3D.O0));

    }
}
