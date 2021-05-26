package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.lighting.Colors;
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
    protected final double hauteurSommet = 2.0;
    private final double hauteurTete = 1.8;
    private final double hauteurTroncHaut = 1.4;
    private final double hauteurTroncBas = 1.05;
    private final double largeurBassin = 0.5;
    private final double hauteurBassin = 0.9;
    private final double hauteurRotule = 0.5;
    private final double hauteurCheville = 0.1;
    private final double largeurTete = 0.4;
    private final double rayonMembres = 0.2;
    private final double hauteurSol = 0.0;
    private final double largeurEpaule = largeurBassin *3/2;

    public Human() {

    }

    public void init() {
        actualBody.getListRepresentable().clear();
        troncBas = new Membre(new Sphere(new Axe(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.Y), Point3D.Y.mult(hauteurTroncHaut).moins(Point3D.Y)),
                (largeurBassin) / 3.));

        TubulaireN2 tronc2 = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTroncBas).plus(Point3D.X.mult(0)),
                Point3D.Y.mult(hauteurTete).plus(Point3D.X.mult(0))
        ), largeurBassin /2);
        tronc = new Membre(tronc2);


        RepresentableConteneur t = new RepresentableConteneur();
        for (
                Axe axe :

                Arrays.asList(new Axe(

                        Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(largeurBassin * 2 / 3)),
                Point3D.Y.mult(hauteurTroncHaut).moins(Point3D.Y).plus(Point3D.X.mult(largeurBassin * 2 / 3))),

                        new Axe(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(-largeurBassin * 2 / 3)),
                Point3D.Y.mult(hauteurTroncHaut).moins(Point3D.Y).plus(Point3D.X.mult(-largeurBassin * 2 / 3)))

            )) {

            Sphere sphere = new Sphere(axe,
                    largeurBassin * 2 / 3);

            sphere.texture(new ColorTexture(Colors.random()));


            t.getListRepresentable().add(sphere);
        }

        troncHaut = new Membre(t);
        TubulaireN2 jhgT = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(largeurBassin)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(largeurBassin))
        ), rayonMembres);
        TubulaireN2 jhdT = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(-largeurBassin)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(-largeurBassin))
        ), rayonMembres);
        jambeHautGauche = new Membre(jhgT);
        jambeHautDroite = new Membre(jhdT);
        TubulaireN2 jambeBasG = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(largeurBassin)),
                Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(largeurBassin))
        ), rayonMembres);
        TubulaireN2 jambeBasD = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(-largeurBassin)),
                Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(-largeurBassin))
        ), rayonMembres);
        jambeBasGauche = new Membre(jambeBasG);
        jambeBasDroite = new Membre(jambeBasD);


        TubulaireN2 bhg = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTete).plus(Point3D.X.mult(largeurEpaule)),
                Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(largeurEpaule))
        ), rayonMembres);
        TubulaireN2 bhd = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTete).plus(Point3D.X.mult(-largeurEpaule)),
                Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(-largeurEpaule))
        ), rayonMembres);
        brasHautGauche = new Membre(bhg);
        brasHautDroit  = new Membre(bhd);


        TubulaireN2 bbg = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(largeurEpaule)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(largeurEpaule))
        ), rayonMembres);
        TubulaireN2 bbd = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(-largeurEpaule)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(-largeurEpaule))
        ), rayonMembres);
        brasBasGauche = new Membre(bbg);
        brasBasDroit  = new Membre(bbd);

        TubulaireN2 piedG = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(largeurBassin)),
                Point3D.Y.mult(hauteurSol).plus(Point3D.X.mult(largeurBassin))
        ), rayonMembres);
        TubulaireN2 piedD = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(-largeurBassin)),
                Point3D.Y.mult(hauteurSol).plus(Point3D.X.mult(-largeurBassin))
        ), rayonMembres);
        piedGauche = new Membre(piedG);
        piedDroit  = new Membre(piedD);

        // Tete
        tete = new Membre(new Sphere(new Axe(Point3D.Y.mult(hauteurSommet),
                Point3D.Y.mult(hauteurTete).moins(Point3D.Y)), (hauteurSommet-hauteurTete)/2.));
    }

    public synchronized void update() {
        actualBody.add(troncBas.getRepresentable());
        actualBody.add(troncHaut.getRepresentable());
        actualBody.add(tronc.getRepresentable());
        actualBody.add(jambeHautGauche.getRepresentable());
        actualBody.add(jambeHautDroite.getRepresentable());
        actualBody.add(jambeBasGauche.getRepresentable());
        actualBody.add(jambeBasDroite.getRepresentable());
        actualBody.add(brasHautGauche.getRepresentable());
        actualBody.add(brasHautDroit.getRepresentable());
        actualBody.add(brasBasGauche.getRepresentable());
        actualBody.add(brasBasDroit.getRepresentable());
        actualBody.add(tete.getRepresentable());
//        actualBody.add(piedGauche.getRepresentable());
//        actualBody.add(piedDroit.getRepresentable());

        add(actualBody) ;


    }


}
