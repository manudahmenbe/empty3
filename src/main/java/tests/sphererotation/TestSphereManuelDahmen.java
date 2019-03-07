/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package tests.sphererotation;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjet;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;
import tests.TestSphere.Trajectoires;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * cette classe produit une image de sphère avec "Manuel Dahmen" écrit dessus. La sphère tourne
 * puis s'en va et revient à l'écran.
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestSphereManuelDahmen extends TestObjetSub {
    double distance = 35;
    double rayon = 10;
    int maxx = 100;
    int maxy = 100;
    TRISphere triSphere = new TRISphere(Point3D.O0, rayon);

    public static void main(String[] args) {

        TestSphereManuelDahmen ts = new TestSphereManuelDahmen();

        ts.setGenerate(TestObjet.GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(true);

        ts.setMaxFrames(500);

        new Thread(ts).
                start();
    }

    @Override
    public void ginit() {
        scene().add(triSphere);
        scene().cameraActive(new Camera(Point3D.Z.mult(distance), Point3D.O0));

        //triSphere.setRotation(triSphere.new Rotation(new Matrix33(new Point3D[] {Point3D.Z, Point3D.X, Point3D.Y}), Point3D.O0));
        triSphere.setMaxX(maxx);
        triSphere.setMaxY(maxy);

        try {
            ImageTexture imageTexture = new ImageTexture(new ECBufferedImage(ImageIO.read(new File("samples/img/map2-modif.png"))));
            imageTexture.setColorMask(ITexture.COLOR_MIROR_XY);
            triSphere.texture(imageTexture);
        } catch (IOException ex) {
            Logger.getLogger(TestSphereManuelDahmen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void testScene() throws Exception {

        scene().cameraActive().setEye(Trajectoires.sphere(Math.random()/2+0.5, 2.0 * frame() / getMaxFrames(), distance));

    }

    @Override
    public void finit() {
    }
}
