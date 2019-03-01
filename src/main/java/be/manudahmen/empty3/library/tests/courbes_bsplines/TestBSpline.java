/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3.library.tests.courbes_bsplines;

import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.BSplineCurve;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestBSpline extends TestObjetSub {

    private BSplineCurve b;

    public static void main(String[] args) {
        TestBSpline ts = new TestBSpline();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(false);

        ts.setMaxFrames(10);

        new Thread(ts).start();

    }

    @Override
    public void finit() {
        scene().clear();

        b = new BSplineCurve();

        for (Point3D p : TestsBSpline.p(frame())) {
            b.add(1.0, p);
        }
        b.texture(new ColorTexture(Color.BLACK));

        scene().add(b);

        scene.cameraActive().setEye(Point3D.Z.mult(-(2 * frame() + 2)));

    }

    @Override
    public void afterRenderFrame() {
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
