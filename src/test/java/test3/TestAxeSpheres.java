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
            Point3D.random().norme1(), r=Math.random()*100.,
               0, 0,  
            ).norme()==r));
    }
}
