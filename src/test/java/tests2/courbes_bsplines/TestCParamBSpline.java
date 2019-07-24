/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests2.courbes_bsplines;


import one.empty3.library.Point3D;
import one.empty3.library.TextureCol;
import one.empty3.library.core.nurbs.CourbeParametriqueBSpline;
import one.empty3.library.core.testing.TestObjet;

import java.awt.*;

/**
 * Test BAD UGLY COMME TA MERE
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestCParamBSpline extends TestObjet {
    private CourbeParametriqueBSpline b;

    public static void main(String[] args) {
        TestCParamBSpline ts = new TestCParamBSpline();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.unterminable(false);

        ts.loop(true);

        ts.setMaxFrames(200);

        new Thread(ts).start();


    }

    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void finit() {
        scene().clear();

        b = new CourbeParametriqueBSpline(TestsBSpline.u(frame() + 1), TestsBSpline.p(frame()), 5);

        b.texture(new TextureCol(Color.WHITE));
        scene().add(b);

        scene.cameraActive().setEye(Point3D.Z.mult(-2d * frame() - 2));

    }

    @Override
    public void ginit() {

    }

    @Override
    public void testScene() throws Exception {

    }

    public void afterRender() {

    }


}
