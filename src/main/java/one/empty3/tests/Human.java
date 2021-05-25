package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.tribase.TubulaireN2;
import one.empty3.library.core.tribase.TubulaireN2;

public class Human extends RepresentableConteneur {

    protected RepresentableConteneur actualBody = new RepresentableConteneur();
    protected Membre troncHaut;
    protected Membre troncBas;
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
    protected double hauteurSommet = 2.0;
    private double hauteurTete = 1.6;
    protected double hauteurTroncHaut = 1.4;
    protected double hauteurTroncBas = 1.05;
    private double largeurPoitrine = 0.4;
    private double hauteurBassin = 0.9;
    private double hauteurRotule = 0.5;
    private double hauteurCheville = 0.1;
    private double largeurTete = 0.4;
    private double rayonMembres = 0.2;
    private double hauteurSol = 0.0;

    public Human() {

    }

    public void init() {
        actualBody.getListRepresentable().clear();
        troncBas = new Membre(new Sphere(new Axe(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.Y), Point3D.Y.mult(hauteurTroncHaut).moins(Point3D.Y)),
                (largeurPoitrine) / 3.));
        RepresentableConteneur t = new RepresentableConteneur();
        t.getListRepresentable().add(new Sphere(new Axe(Point3D.Y.plus(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.Y)).plus(Point3D.X.mult(largeurPoitrine*2/3)),
                Point3D.Y.plus(Point3D.Y.mult(hauteurTroncHaut)).moins(Point3D.Y).plus(Point3D.X.mult(largeurPoitrine*2/3))),
                largeurPoitrine / 4.));
        t.getListRepresentable().add(new Sphere(new Axe(Point3D.Y.plus(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.Y)).plus(Point3D.X.mult(-largeurPoitrine*2/3)),
                Point3D.Y.plus(Point3D.Y.mult(hauteurTroncHaut)).moins(Point3D.Y).plus(Point3D.X.mult(-largeurPoitrine*2/3))),
                largeurPoitrine / 4.));
        troncHaut = new Membre(t);
        TubulaireN2 jhgT = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(largeurPoitrine)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(largeurPoitrine))
        ), rayonMembres);
        TubulaireN2 jhdT = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(-largeurPoitrine)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(-largeurPoitrine))
        ), rayonMembres);
        jambeHautGauche = new Membre(jhgT);
        jambeHautDroite = new Membre(jhdT);
        TubulaireN2 jambeBasG = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(largeurPoitrine)),
                Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(largeurPoitrine))
        ), rayonMembres);
        TubulaireN2 jambeBasD = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(-largeurPoitrine)),
                Point3D.Y.mult(hauteurRotule).plus(Point3D.X.mult(-largeurPoitrine))
        ), rayonMembres);
        jambeBasGauche = new Membre(jambeBasG);
        jambeBasDroite = new Membre(jambeBasD);
        TubulaireN2 bhg = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTete).plus(Point3D.X.mult(largeurPoitrine)),
                Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(largeurPoitrine))
        ), rayonMembres);
        TubulaireN2 bhd = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTete).plus(Point3D.X.mult(-largeurPoitrine)),
                Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(-largeurPoitrine))
        ), rayonMembres);
        brasHautGauche = new Membre(bhg);
        brasHautDroit  = new Membre(bhd);
        TubulaireN2 bbg = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(largeurPoitrine)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(largeurPoitrine))
        ), rayonMembres);
        TubulaireN2 bbd = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurTroncHaut).plus(Point3D.X.mult(-largeurPoitrine)),
                Point3D.Y.mult(hauteurBassin).plus(Point3D.X.mult(-largeurPoitrine))
        ), rayonMembres);
        brasBasGauche = new Membre(bbg);
        brasBasDroit  = new Membre(bbd);
        TubulaireN2 piedG = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(largeurPoitrine)),
                Point3D.Y.mult(hauteurSol).plus(Point3D.X.mult(largeurPoitrine))
        ), rayonMembres);
        TubulaireN2 piedD = new TubulaireN2(new LineSegment(Point3D.Y.mult(hauteurCheville).plus(Point3D.X.mult(-largeurPoitrine)),
                Point3D.Y.mult(hauteurSol).plus(Point3D.X.mult(-largeurPoitrine))
        ), rayonMembres);
        piedGauche = new Membre(bbg);
        piedDroit  = new Membre(bbd);

        // Tete
        tete = new Membre(new Sphere(new Axe(Point3D.Y.mult(hauteurTete).plus(Point3D.Y),
                Point3D.Y.mult(hauteurTete).moins(Point3D.Y)), largeurTete/2.));
    }

    public synchronized void update() {
        actualBody.add(troncBas.getRepresentable());
        actualBody.add(troncHaut.getRepresentable());
        actualBody.add(jambeHautGauche.getRepresentable());
        actualBody.add(jambeHautDroite.getRepresentable());
        actualBody.add(jambeBasGauche.getRepresentable());
        actualBody.add(jambeBasDroite.getRepresentable());
        actualBody.add(brasHautGauche.getRepresentable());
        actualBody.add(brasHautDroit.getRepresentable());
        actualBody.add(brasBasGauche.getRepresentable());
        actualBody.add(brasBasDroit.getRepresentable());
        actualBody.add(tete.getRepresentable());
        actualBody.add(piedGauche.getRepresentable());
        actualBody.add(piedDroit.getRepresentable());


        add(actualBody) ;


    }


}
