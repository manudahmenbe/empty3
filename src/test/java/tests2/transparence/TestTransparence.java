/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests2.transparence;

import one.empty3.library.Camera;
import one.empty3.library.ECBufferedImage;
import one.empty3.library.Point3D;
import one.empty3.library.TextureImg;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.Plan3D;

import javax.imageio.ImageIO;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestTransparence extends TestObjetSub {

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
        TextureImg TextureCol = new TextureImg(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("be.manudahmen.empty3.tests2.cubes-be.manudahmen.empty3.tests2.transparence.png"))));
        //TextureCol.setTransparent(Color.GREEN);
        plan3D.texture(TextureCol);

        scene().add(plan3D);
        scene().cameraActive(new Camera(Point3D.Z.mult(3), Point3D.O0));

    }
}
