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
    private double espacementRoues = 300;
    private final Voiture voiture;
    private double largeurMuseau;

    public Chassis(Voiture voiture) {
        this.voiture = voiture;
    }

    public void init() {
        double largeur = voiture.getLargeur();
        double longueur = voiture.getLongueur();
        add( new Polygon(new Point3D[]{
                P.n(-espacementRoues/2, 20, -largeur),
                P.n(espacementRoues/2, 20, -largeur),
                P.n(espacementRoues/2, 20, largeur),
                P.n(-espacementRoues/2, 20, largeur)}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-espacementRoues/2, 0., -largeur),
                P.n(espacementRoues/2, 0., -largeur),
                P.n(espacementRoues/2, 0., largeur),
                P.n(-espacementRoues/2, 0., largeur)}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(-espacementRoues/2, 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(-espacementRoues/2, 20., largeur-voiture.getEpaisseurRoue()),
                P.n(-espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 20., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(-espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(-espacementRoues/2, 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(-espacementRoues/2, 0., largeur-voiture.getEpaisseurRoue()),
                P.n(-espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2, 20., -largeur+voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2, 20., largeur-voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 20., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2, 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2, 0., largeur-voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
        // Largeur avant
        add( new Polygon(new Point3D[]{
                P.n(espacementRoues/2+Voiture.LARGEUR_ROUE+voiture.getEspacementRoues()/2, 20., -largeurMuseau),
                P.n(espacementRoues/2+Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 20., -largeurMuseau),
                P.n(espacementRoues/2, 20., largeurMuseau),
                P.n(espacementRoues/2, 20., largeurMuseau)}, Color.BLACK));
        add( new Polygon(new Point3D[]{
                P.n(espacementRoues/2+Voiture.LARGEUR_ROUE+voiture.getEspacementRoues()/2, 0., -largeurMuseau),
                P.n(espacementRoues/2+Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., -largeurMuseau),
                P.n(espacementRoues/2, 20., largeurMuseau),
                P.n(espacementRoues/2, 20., largeurMuseau)}, Color.BLACK));
        // Largeur arrière
        add( new Polygon(new Point3D[]{
                P.n(espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2, 0., -largeur+voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2, 0., largeur-voiture.getEpaisseurRoue()),
                P.n(espacementRoues/2-Voiture.LARGEUR_ROUE-voiture.getEspacementRoues(), 0., largeur-voiture.getEpaisseurRoue())}, Color.BLACK));
    }

    public static void main(String [] args) {
        TestObjetSub testObjetSub = new TestObjetSub();
        testObjetSub.scene().add(new Voiture());
        testObjetSub.setGenerate(testObjetSub.GENERATE_MODEL|testObjetSub.getGenerate());
        testObjetSub.setPublish(true);
        new Thread(testObjetSub).start();
    }
}
