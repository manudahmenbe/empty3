/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.tests.trigenerateurabstract.paraboloidehyperbolique;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.LumierePointSimple;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.renderer.TestObjet;
import be.manudahmen.empty3.core.tribase.ParaboloideHyperbolique;

import java.awt.*;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestPH1 extends TestObjet {

    private ParaboloideHyperbolique ph = null;

    public static void main(String[] argd) {
        TestPH1 tth = new TestPH1();

        tth.loop(true);
        tth.setMaxFrames(250);
        tth.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        new Thread(tth).start();
    }

    @Override
    public void afterRenderFrame() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finit() {
        double a = Math.sqrt(frame() + 1);
        double b = Math.sqrt(frame() + 1);
        ph = new ParaboloideHyperbolique(a, b, 2);
        ph.setMaxX(100);
        ph.setMaxY(100);
        scene().add(ph);
        ph.texture(new ColorTexture(Color.RED));
    }

    @Override
    public void ginit() {

    }

    @Override
    public void testScene() throws Exception {
        scene().cameraActive(new Camera(Point3D.Z.mult(4).mult(new Point3D(1.0 * frame() / getMaxFrames() * 2 * Math.PI, 0, 0)), Point3D.O0));
        scene().lumieres().add(new LumierePointSimple(Color.WHITE, Point3D.X.plus(Point3D.Y), 1));
    }

    public void afterRender() {

    }
}
