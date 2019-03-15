/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>

 Creation time 05-nov.-2014
 ***/


package tests.getobjectat;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TColor;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * Future: this should be.manudahmen.empty3.library.tests.be very low level: like :
 * Representable.setSelectionZoneId(long szid);
 * ZBuffer.getSelectionZoneId(int x, int y);
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestGetObjectAt extends TestObjetSub {

    @Override
    public void testScene() throws Exception {
        scene().clear();
        scene().add(new TRI(Point3D.O0, Point3D.X, Point3D.Y, new TColor(Color.BLUE)));
        scene().cameraActive(new Camera(Point3D.Z.mult(-1), Point3D.O0));

    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
