package one.empty3.tests;

import one.empty3.library.P;
import one.empty3.library.Point3D;
import one.empty3.library.Polygon;
import one.empty3.library.RepresentableConteneur;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.testing.TestObjetSub;
import org.jcodec.codecs.common.biari.Packed4BitList;
import tests2.getobjectat.TestGetObjectAt;

import java.awt.*;

public class Chassis extends RepresentableConteneur {
    private final Voiture voiture;
    private double largeurMuseau;
    private double longueurArriere = 100.;

    public Chassis(Voiture voiture) {
        this.voiture = voiture;
        init();
    }

    public void init() {
        double largeur = voiture.getLargeur();
        double longueur = voiture.getLongueur();
        largeurMuseau = largeur;
        // Mettre 2 rectangles entre les roues Un sur le sol, un à 20cm de hauteur
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2, 20, -largeur),
                P.n(voiture.getLongueur() /2, 20, -largeur),
                P.n(voiture.getLongueur() /2, 20, largeur),
                P.n(-voiture.getLongueur() /2, 20, largeur)}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2, 0., -largeur),
                P.n(voiture.getLongueur() /2, 0., -largeur),
                P.n(voiture.getLongueur() /2, 0., largeur),
                P.n(-voiture.getLongueur() /2, 0., largeur)}, Color.BLACK));
        // Metre 4 rectangles pour l'epace entre les roues
        // 2 pour l'arrière
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 20., largeur-voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 20., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 0., largeur-voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 0., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        // 2 pour l'avant
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 20., largeur-voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 20., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2, 0., largeur-voiture.getEpaisseurRoue()),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()-voiture.getEspacementRoues(), 0., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        // Largeur avant
        double longueurAvant = 100;
        add( new Polygon(new Point3D[]{
                P.n(voiture.getLongueur() /2+voiture.getRayonRoue()+longueurAvant, 20., -largeurMuseau),
                P.n(voiture.getLongueur() /2+voiture.getRayonRoue(), 20., -largeurMuseau),
                P.n(voiture.getLongueur() /2, 20., largeurMuseau),
                P.n(voiture.getLongueur() /2+voiture.getRayonRoue()+longueurAvant, 20., largeurMuseau)}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(voiture.getLongueur() /2+voiture.getRayonRoue()+longueurAvant, 0., -largeurMuseau),
                P.n(voiture.getLongueur() /2+voiture.getRayonRoue(), 0., -largeurMuseau),
                P.n(voiture.getLongueur() /2, 0., largeurMuseau),
                P.n(voiture.getLongueur() /2+voiture.getRayonRoue()+longueurAvant, 0., largeurMuseau)}, Color.BLACK));
        // Coffre et arrière
        add( new Polygon(new Point3D[]{
                P.n(voiture.getLongueur() /2-voiture.getRayonRoue()+longueurArriere, 20., -largeurMuseau),
                P.n(voiture.getLongueur() /2-voiture.getRayonRoue(), 20., -largeurMuseau),
                P.n(voiture.getLongueur() /2-voiture.getRayonRoue(), 20., largeurMuseau),
                P.n(voiture.getLongueur() /2-voiture.getRayonRoue()+longueurArriere, 20., largeurMuseau)}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()+longueurArriere, 0., -largeurMuseau),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue(), 0., -largeurMuseau),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue(), 0., largeurMuseau),
                P.n(-voiture.getLongueur() /2-voiture.getRayonRoue()+longueurArriere, 0., largeurMuseau)}, Color.BLACK));
    }

}
