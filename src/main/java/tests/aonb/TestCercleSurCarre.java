package tests.aonb;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.core.aonb.AonB;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

public class TestCercleSurCarre extends TestObjetSub {
    public void ginit()
    {
        CercleSurCarre cercleSurCarre = new CercleSurCarre(null, 0);

        Carre carre = new Carre();
        carre.texture(new TextureCol(Color.BLUE));
        AonB aonB = new AonB(cercleSurCarre, carre);
        carre.texture(new TextureCol(Color.GREEN));
        scene().add(aonB);
        scene().cameraActive(new Camera(Point3D.Z, Point3D.O0));
    }
    public static void main(String[] args) {
        TestCercleSurCarre testCercleSurCarre = new TestCercleSurCarre();
        testCercleSurCarre.loop(false);
        new Thread(testCercleSurCarre).start();
    }
}
