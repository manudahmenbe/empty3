package test4;

import one.empty3.library.*;
import one.empty3.library.core.nurbs.FctXY;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.*;
import java.util.function.Predicate;

public class Humain extends RepresentableConteneur {
    public Point3D rotate1(Tubulaire3 tubulaire3, int index0, int indexP, double angle, double fract) {
        return null;
    }
    public void tubeAddPoint(Tubulaire3 tube, Point3D p) {
        tube.getSoulCurve().getElem().getCoefficients().getData1d().add(p);
    }

    public Humain() {
        Tubulaire3[] patte = new Tubulaire3[4];
        Point3D tete = new Point3D(0., 21., 0.); //tête
        Point3D queue = new Point3D(1., 0., 1.); // queue
        Sphere tetes = new Sphere(tete, 2.); //sphère
        tetes.texture(new TextureCol(Color.RED));
        queue.texture(new TextureCol(Color.BLACK));

        Cube ventre = new Cube(5.0, P.n(0., 15., 0));
        for (int i = 0; i < 4; i++) {
            patte[i] = new Tubulaire3();
            patte[i].getSoulCurve().getElem().getCoefficients().getData1d().clear();
            patte[i].texture(new TextureCol(Color.ORANGE));
            ((FctXY) (patte[i].getDiameterFunction().getElem())).setFormulaX("0.6");
        }
        Tubulaire3 corps;
        corps = new Tubulaire3();
        corps.getSoulCurve().getElem().getCoefficients().getData1d().clear();
        corps.getSoulCurve().getElem().getCoefficients().setElem(P.n(0., 1., 0.));
        corps.getSoulCurve().getElem().getCoefficients().setElem(P.n(1., 1., 0.));
        corps.texture(new TextureCol(Color.ORANGE));
        ((FctXY) (corps.getDiameterFunction().getElem())).setFormulaX("1.5");
// JAMBE AVANT DROIT
// §1
        for (int i = 0; i < 2; i++) {
            tubeAddPoint(patte[0], new Point3D(-1., 0., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 0., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 5., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 10., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 11., 0.));
            tubeAddPoint(patte[0], new Point3D(0., 15., 0.));
            tubeAddPoint(patte[0], new Point3D(0., 20., 0.));
            tubeAddPoint(patte[0], new Point3D(0., 21., 0.));
        }
        for (int i = 0; i < 2; i++) {
            tubeAddPoint(patte[0], new Point3D(0., 20., 1. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 20., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 15., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 10., 2. * (2 * i - 1)));
            tubeAddPoint(patte[0], new Point3D(0., 9., 2. * (2 * i - 1)));
        }
        for (int i = 0; i < 2; i++) {
        }
        add(corps);
        add(tetes);
        add(ventre);
        for (int i = 0; i < 4; i++) {
            add(patte[i]);

        }
    }

}
