/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package tests.trigenerateurabstract.triextrusiongeneralisee;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.*;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestTore extends TestObjetSub {
    public static void main(String[] args) {
        TestTore tp = new TestTore();
        tp.setGenerate(GENERATE_IMAGE | GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }

    @Override
    public void ginit() {
        Surface s = new SurfaceCercle(1);
        Chemin c = new CheminCercle(10);

        TRIExtrusionGeneralisee tri = new TRIExtrusionGeneralisee();

        tri.setCirculaireX(true);
        tri.setCirculaireY(true);

        tri.setSurface(s);

        tri.setChemin(c);

        tri.setMaxX(100);
        tri.setMaxY(100);

        tri.texture(new TextureCol(Color.WHITE));

        scene().add(tri);
    }

    @Override
    public void finit() {
    }

    @Override
    public void testScene() throws Exception {
    }

}
