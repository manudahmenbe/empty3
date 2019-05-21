/*
 * 2013 Manuel Dahmen
 */
package tests.cubes;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Se7en
 */
public class TestCubes extends TestObjetSub {

    public static void main(String[] args) {
        TestCubes tc = new TestCubes();

        tc.loop(true);


        tc.setResx(640);
        tc.setResy(480);
        tc.setMaxFrames(25 * 60);

        new Thread(tc).start();
    }

    @Override
    public void ginit() {
        scene().add(new Cube(50, 10, Color.RED));


    }

    private double z(double min, double max, int framemin, int nof) {
        return min + (max - min) * (1.0 * (frame() - framemin) / nof);
    }

    @Override
    public void testScene() {
        scene().cameras().clear();

        scene().cameraActive(new Camera(
                new Point3D(0, 0, z(-250, 250, 0, getMaxFrames())),
                new Point3D(0, 0, 1000000)
        ));
    }

    @Override
    public void finit() {

    }
}

class Cube extends RepresentableConteneur {
    private ArrayList<Representable> cube = new ArrayList<Representable>();

    public Cube(double dim, int pas, Color c) {
        if (dim < 0)
            return;
        for (double i = -dim / 2; i < dim / 2 + pas; i += pas)
            for (double j = -dim / 2; j < dim / 2 + pas; j += pas)
                for (double k = -dim / 2; k < dim / 2 + pas; k += pas) {
                    if (1.0 * i + 1.0 * dim / pas < dim / 2 + pas) {
                        cube.add(new LineSegment(
                                        new Point3D(1.0 * i, 1.0 * j, 1.0 * k),
                                        new Point3D(1.0 * i + 1.0 * dim / pas, 1.0 * j, 1.0 * k),
                                        new TextureCol(c)
                                )
                        );
                    }
                    if (1.0 * j + 1.0 * dim / pas < dim / 2 + pas)
                        cube.add(new LineSegment(
                                        new Point3D(1.0 * i, 1.0 * j, 1.0 * k),
                                        new Point3D(1.0 * i, 1.0 * j + 1.0 * dim / pas, 1.0 * k),
                                        new TextureCol(c)
                                )
                        );
                    if (1.0 * k + 1.0 * dim / pas < dim / 2 + pas)
                        cube.add(new LineSegment(
                                        new Point3D(1.0 * i, 1.0 * j, 1.0 * k),
                                        new Point3D(1.0 * i, 1.0 * j, 1.0 * k + 1.0 * dim / pas),
                                        new TextureCol(c)
                                )
                        );
                }
    }

    public void deforme(Point3D p) {
        return;
    }

    @Override
    public List<Representable> getListRepresentable() {
        return cube;
    }

}