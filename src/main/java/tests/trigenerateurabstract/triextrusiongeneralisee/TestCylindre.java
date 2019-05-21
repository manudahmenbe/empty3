/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package tests.trigenerateurabstract.triextrusiongeneralisee;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.LineSegment;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.CheminDroite;
import be.manudahmen.empty3.core.tribase.SurfaceCercle;
import be.manudahmen.empty3.core.tribase.TRIExtrusionGeneralisee;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestCylindre extends TestObjetSub {

    private TRIExtrusionGeneralisee eg;

    public static void main(String[] args) {
        TestCylindre tp = new TestCylindre();
        tp.setGenerate(GENERATE_IMAGE | GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }

    @Override
    public void ginit() {
        eg = new TRIExtrusionGeneralisee();
        CheminDroite cd = new CheminDroite(new LineSegment(Point3D.X, Point3D.Y, new TextureCol(Color.WHITE)));

        eg.setChemin(cd);

        eg.setSurface(new SurfaceCercle(2));

        eg.setMaxX(100);

        eg.setMaxY(100);

        eg.texture(new TextureCol(Color.WHITE));

        this.description = "Cylindre ";
    }

    @Override
    public void testScene() throws Exception {
        scene().clear();
        scene().add(eg);

        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0));
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
