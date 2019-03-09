/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.courbes_bsplines;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.CourbeParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.testing.TestObjet;

import java.awt.*;

/**
 * Test OK
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestBezierN extends TestObjet {
    private CourbeParametriquePolynomialeBezier b;

    public static void main(String[] args) {
        TestBezierN ts = new TestBezierN();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(false);

        ts.setMaxFrames(10);

        new Thread(ts).start();


    }

    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void finit() {
        scene().clear();

        b = new CourbeParametriquePolynomialeBezier(TestsBSpline.p(frame()));

        b.texture(new TextureCol(Color.WHITE));


        scene().add(b);

        scene.cameraActive().setEye(Point3D.Z.mult(-(2 * frame() + 2)));

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
