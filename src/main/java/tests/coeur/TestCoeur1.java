/**
 * *
 * Global license : * GNU GPL v3
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * Creation time 25-oct.-2014 SURFACE D'ÉLASTICITÉ DE FRESNEL Fresnel's
 * elasticity surface, Fresnelsche Elastizitätfläche
 * http://www.mathcurve.com/surfaces/elasticite/elasticite.shtml *
 */
package tests.coeur;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestCoeur1 extends TestObjet {

    private SurfaceElasticite coeur;

    public static void main(String[] args) {
        TestCoeur1 tc = new TestCoeur1();

        tc.loop(false);
        tc.setMaxFrames(400);
        tc.setGenerate(GENERATE_MODEL | GENERATE_IMAGE);
        new Thread(tc).start();
    }

    @Override
    public void ginit() {
        coeur = new SurfaceElasticite(5, 3, 1);
        try {
            coeur.texture(new TextureImg(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("moi1.jpg")))));
        } catch (IOException ex) {
            coeur.texture(new TextureCol(Color.PINK));
            Logger.getLogger(TestCoeur1.class.getName()).log(Level.SEVERE, null, ex);
        }

        coeur.setMaxX(100);
        coeur.setMaxY(100);

        scene().add(coeur);

        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0));

    }

    @Override
    public void testScene() throws Exception {

    }

    @Override
    public void finit() {

    }

    @Override
    public void afterRenderFrame() {

        //coeur.drawStructureDrawFast(getZ());

    }

    public void afterRender() {

    }

}
