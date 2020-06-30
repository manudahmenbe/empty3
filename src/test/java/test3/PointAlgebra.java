package test3;
import one.empty3.library.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
/*__
 * Created by manue on 11-09-19.
 */
public class PointAlgebra {
    @Test
    public void testPoint3DInit() {
      //Double [] ds2 = new Double [] {1.4, 2.3, 3.1};
      double [] ds1 = new double [] {1.4, 2.3, 3.1};
      //assertTrue(new Point3D(ds1).equals(new Point3D(ds2)));
      assertTrue(new Point3D(ds1).equals(new Point3D(1.4, 2.3, 3.1)));
      assertFalse(new Point3D(ds2).equals(Point3D.O0));
      assertTrue(new Point3D().equals(Point3D.O0));
    }

    @Test
    public void testPoint3D() {
        new Point3D();
    }
}
