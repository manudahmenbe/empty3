/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.sphererotation;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.renderer.TestObjet;
import be.manudahmen.empty3.core.renderer.TestObjetStub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * cette classe produit une image de sphère avec "Manuel Dahmen" écrit dessus. La sphère tourne
 * puis s'en va et revient à l'écran.
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestSphereManuelDahmen extends TestObjetStub {
    double distance = 35;
    double rayon = 10;
    int maxx = 100;
    int maxy = 100;
    TRISphere tp = new TRISphere(Point3D.O0, rayon);

    public static void main(String[] args) {

        TestSphereManuelDahmen ts = new TestSphereManuelDahmen();

        ts.setGenerate(TestObjet.GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(true);

        ts.setMaxFrames(500);

        new Thread(ts).start();
    }

    @Override
    public void ginit() {
        scene().add(tp);
        scene().cameraActive(new Camera(Point3D.Z.mult(distance), Point3D.O0));

        //tp.setRotation(tp.new Rotation(new Matrix33(new Point3D[] {Point3D.Z, Point3D.X, Point3D.Y}), Point3D.O0));
        tp.setMaxX(maxx);
        tp.setMaxY(maxy);

        try {
            ImageTexture imageTexture = new ImageTexture(new ECBufferedImage(ImageIO.read(this.getClass().getResourceAsStream("map2.png"))));
            imageTexture.setColorMask(ITexture.COLOR_MIROR_XY);
            tp.texture(imageTexture);
        } catch (IOException ex) {
            Logger.getLogger(TestSphereManuelDahmen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void testScene() throws Exception {

        scene().cameraActive().setEye(Matrix33.rot(90 / 360.0 * 2 * Math.PI, 0).mult(be.manudahmen.empty3.core.move.Trajectoires.sphere(0, 1.0 * frame() / 250, distance)));

    }

    @Override
    public void finit() {
    }
}
