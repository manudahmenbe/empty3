/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3.library.tests.courbes_bsplines;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.BSplineCurve;
import be.manudahmen.empty3.core.testing.TestObjet;

import java.awt.*;

/**
 * Test BAD UGLY COMME TA MERE
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
@Deprecated
public class TestBSplineCurve extends TestObjet {
    private BSplineCurve b;

    public static void main(String[] args) {
        TestBSplineCurve ts = new TestBSplineCurve();

        ts.setGenerate(GENERATE_IMAGE);

        ts.loop(false);

        ts.setMaxFrames(10);

        new Thread(ts).start();


    }

    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void finit() {

        scene().add(b);

        scene.cameraActive().setEye(Point3D.Z.mult(-24));

    }

    @Override
    public void ginit() {
        b = new BSplineCurve();
        //TestsBSpline.u(), TestsBSpline.p(), 4);
        b.texture(new TextureCol(Color.WHITE));
    }

    @Override
    public void testScene() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void afterRender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
