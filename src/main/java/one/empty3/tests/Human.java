package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.lighting.Colors;
import one.empty3.library.core.nurbs.ExtrusionCurveCurve;
import one.empty3.library.core.nurbs.TourRevolution;
import one.empty3.library.core.tribase.TubulaireN2;

import java.util.Arrays;

public class Human extends RepresentableConteneur {

    protected RepresentableConteneur actualBody = new RepresentableConteneur();
    protected Membre troncHaut;
    protected Membre troncBas;
    protected Membre tronc;
    protected Membre jambeHautGauche;
    protected Membre jambeHautDroite;
    protected Membre jambeBasGauche;
    protected Membre jambeBasDroite;
    protected Membre piedGauche;
    protected Membre piedDroit;
    protected Membre brasHautGauche;
    protected Membre brasHautDroit;
    protected Membre brasBasGauche;
    protected Membre brasBasDroit;
    protected Membre mainGauche;
    protected Membre mainDroite;
    protected Membre[] doigtsMainGauche;
    protected Membre[] doigtsMainDroite;
    protected Membre tete;
    private final double hauteurSommet = 2.0;
    private final double hauteurTete = 1.8;
    private final double hauteurTroncHaut = 1.4;
    private final double hauteurTroncBas = 1.05;
    private final double hauteurBassin = 0.9;
    private final double hauteurRotule = 0.5;
    private final double hauteurCheville = 0.1;
    private final double hauteurSol = 0.0;
    private final double largeurBassin = 0.3;
    private final double largeurTete = 0.4;
    private final double largeurEpaule = largeurBassin * 3 / 2;
    private final double rayonMembres = 0.25;
    private final double rayonMembresHaut = 0.15;

    public Human() {

    }

    public void init() {
        actualBody.getListRepresentable().clear();
        troncBas = new Membre(new Sphere(new Axe(Point3D.Z.mult(hauteurTroncHaut).plus(Point3D.Z), Point3D.Z.mult(hauteurTroncHaut).moins(Point3D.Z)),
                (largeurBassin) / 3.));

        TubulaireN2 tronc2 = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurBassin).plus(Point3D.Y.mult(0)),
                Point3D.Z.mult(hauteurTete).plus(Point3D.Y.mult(0))
        ), largeurBassin / 2);
        tronc = new Membre(tronc2);


        RepresentableConteneur t = new RepresentableConteneur();
        for (Axe axe : Arrays.asList(
                new Axe(new Point3D(0.0, largeurBassin * 2 / 3, hauteurTroncHaut),
                        new Point3D(0.0, largeurBassin * 2 / 3, hauteurTroncBas)),
                new Axe(new Point3D(0.0,-largeurBassin * 2 / 3, hauteurTroncHaut),
                        new Point3D(0.0, -largeurBassin * 2 / 3, hauteurTroncBas)))) {

            Sphere sphere = new Sphere(axe,
                    largeurBassin * 2 / 3);

            sphere.texture(new ColorTexture(Colors.random()));


            t.getListRepresentable().add(sphere);
        }

        troncHaut = new Membre(t);


        TubulaireN2 bhg = new TubulaireN2(new LineSegment(new Point3D(0.0, largeurEpaule, hauteurTroncHaut),
                new Point3D(0.0, largeurEpaule, hauteurTroncBas)), rayonMembresHaut);
        TubulaireN2 bhd = new TubulaireN2(new LineSegment(new Point3D(0.0, -largeurEpaule, hauteurTroncHaut),
                new Point3D(0.0, -largeurEpaule, hauteurTroncBas)), rayonMembresHaut);
        brasHautGauche = new Membre(bhg);
        brasHautDroit = new Membre(bhd);


        TubulaireN2 bbg = new TubulaireN2(new LineSegment(new Point3D(0.0, largeurEpaule, hauteurTroncBas),
                new Point3D(0.0, largeurEpaule, hauteurBassin)), rayonMembresHaut);
        TubulaireN2 bbd = new TubulaireN2(new LineSegment(new Point3D(0.0, -largeurEpaule, hauteurTroncBas),
                new Point3D(0.0, -largeurEpaule, hauteurBassin)), rayonMembresHaut);
        brasBasGauche = new Membre(bbg);
        brasBasDroit = new Membre(bbd);


        TubulaireN2 jhgT = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurRotule).plus(Point3D.Y.mult(largeurBassin)),
                Point3D.Z.mult(hauteurBassin).plus(Point3D.Y.mult(largeurBassin))
        ), rayonMembres);
        TubulaireN2 jhdT = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurRotule).plus(Point3D.Y.mult(-largeurBassin)),
                Point3D.Z.mult(hauteurBassin).plus(Point3D.Y.mult(-largeurBassin))
        ), rayonMembres);
        jambeHautGauche = new Membre(jhgT);
        jambeHautDroite = new Membre(jhdT);
        TubulaireN2 jambeBasG = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurCheville).plus(Point3D.Y.mult(largeurBassin)),
                Point3D.Z.mult(hauteurRotule).plus(Point3D.Y.mult(largeurBassin))
        ), rayonMembres);
        TubulaireN2 jambeBasD = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurCheville).plus(Point3D.Y.mult(-largeurBassin)),
                Point3D.Z.mult(hauteurRotule).plus(Point3D.Y.mult(-largeurBassin))
        ), rayonMembres);
        jambeBasGauche = new Membre(jambeBasG);
        jambeBasDroite = new Membre(jambeBasD);


        TubulaireN2 piedG = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurCheville).plus(Point3D.Y.mult(largeurBassin)),
                Point3D.Z.mult(hauteurSol).plus(Point3D.Y.mult(largeurBassin)).plus(Point3D.X.mult(0.2))), rayonMembres);
        TubulaireN2 piedD = new TubulaireN2(new LineSegment(Point3D.Z.mult(hauteurCheville).plus(Point3D.Y.mult(-largeurBassin)),
                Point3D.Z.mult(hauteurSol).plus(Point3D.Y.mult(-largeurBassin)).plus(Point3D.X.mult(0.2))), rayonMembres);
        piedGauche = new Membre(piedG);
        piedDroit = new Membre(piedD);

        // Tete
        tete = new Membre(new Sphere(new Axe(Point3D.Z.mult(hauteurSommet),
                Point3D.Z.mult(hauteurTete)),largeurTete));
    }

    public synchronized void update() {
        for (Membre membre : Arrays.asList(tronc, troncBas, troncHaut,
                jambeBasDroite, jambeBasGauche, jambeHautDroite, jambeHautGauche,
                brasBasDroit, brasBasGauche, brasHautGauche, brasHautDroit, tete, piedGauche, piedDroit)) {
            actualBody.add(membre.getRepresentable());
        }
        add(actualBody);

        addSexe(true);
    }
    public void addSexe(boolean man) {
        if(man) {
            TubulaireN2 sexe = new TubulaireN2(new LineSegment(
                    new Point3D(0.2, 0.0, hauteurTroncBas),
                    new Point3D(0.3, 0.0, hauteurBassin)

            ), 0.13);
            Sphere [] spheres = new Sphere[] {
                    new Sphere(new Axe(
                            new Point3D( 1.0,largeurBassin/3*4, (hauteurBassin+hauteurTroncBas)/2),
                            new Point3D( -1.0,largeurBassin/3*4, (hauteurBassin+hauteurTroncBas)/2)
                        ), 0.13),

                    new Sphere(new Axe(
                            new Point3D(1.0,- largeurBassin/3*4, (hauteurBassin+hauteurTroncBas)/2),
                            new Point3D(-1.0,- largeurBassin/3*4, (hauteurBassin+hauteurTroncBas)/2)
                    ), 0.13)
            };
            actualBody.add(sexe);
            actualBody.add(sexe);
            actualBody.add(spheres[0]);
            actualBody.add(spheres[1]);

        } else {
            ExtrusionCurveCurve extrusionCurveCurve = new ExtrusionCurveCurve();
            extrusionCurveCurve.getBase().setElem(new Circle(new Axe(

                            new Point3D(1.0, largeurBassin/8, (hauteurBassin)/2).plus(Point3D.Z),
                            new Point3D(-1.0,- largeurBassin/8, (hauteurBassin)/2).plus(Point3D.Z)
                    ), 0.2));
        }
    }

}
