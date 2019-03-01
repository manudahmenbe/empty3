/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.tests.trigenerateurabstract.triextrusiongeneralisee;

import be.manudahmen.empty3.BezierCubique;
import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.CheminBezier;
import be.manudahmen.empty3.core.tribase.SurfaceCercle;
import be.manudahmen.empty3.core.tribase.TRIExtrusionGeneralisee;

import java.awt.*;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestArc extends TestObjetSub {

    private TRIExtrusionGeneralisee eg;

    public static void main(String[] args) {
        TestArc tp = new TestArc();
        tp.setGenerate(GENERATE_IMAGE | GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }

    @Override
    public void ginit() {
        eg = new TRIExtrusionGeneralisee();
        //CheminDroite cd = new CheminDroite(new SegmentDroite(Point3D.X, Point3D.Y, new ColorTexture(Color.WHITE)));
        BezierCubique bezierCubique = new BezierCubique();
        bezierCubique.add(Point3D.O0);
        bezierCubique.add(Point3D.X);
        bezierCubique.add(Point3D.X.plus(Point3D.Y));
        bezierCubique.add(Point3D.Y);
        CheminBezier cheminBezier = new CheminBezier(bezierCubique);

        eg.setChemin(cheminBezier/*new CheminDroite(new SegmentDroite(Point3D.O0, Point3D.Y.mult(5)))*/);

        eg.setSurface(new SurfaceCercle(2));

        eg.setMaxX(100);

        eg.setMaxY(100);

        eg.texture(new ColorTexture(Color.WHITE));

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
