package test3;
import one.empty3.library.core.move.Trajectoires;
import one.empty3.library.*;
import org.junit.Test;
import java.awt.Color;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue; 
public class TestAxeSpheres {
    @Test
    public void testSphereTrajectoire() {
         double r;
         assertTrue(Trajectoires.sphere(Point3D.O0,
            Point3D.random().norme1(), Math.random(), Math.random(), r=Math.random()*100.,
               
            ).norme()==r);
  assertTrue(Trajectoires.sphere(Point3D.X,
            Point3D.Z, r,
               0, 0
            ).equals(P.n(r+1., 0., 0.));
  assertTrue(Trajectoires.sphere(Point3D.X,
            Point3D.Z, r,
               0.5, 0
            ).equals(P.n(-r+1., 0., 0.));
  assertTrue(Trajectoires.sphere(Point3D.X,
            Point3D.Z, r,
               1.0, 0
            ).equals(P.n(r+1., 0., 0.));
  assertTrue(Trajectoires.sphere(Point3D.Y,
            Point3D.Z, r,
               1.0, 0
            ).equals(P.n(r, 1., 0.));
    }
}
