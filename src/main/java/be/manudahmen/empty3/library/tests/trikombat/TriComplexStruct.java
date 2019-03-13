package be.manudahmen.empty3.library.tests.trikombat;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.ApproximationFonction1D;
import be.manudahmen.empty3.core.tribase.ApproximationFonction2D;
import be.manudahmen.empty3.core.tribase.Tubulaire;

/**
 * Created by manuel on 15-08-16.
 */
public class TriComplexStruct {
    private Tubulaire tube;
    private ApproximationFonction1D diam;
    private ApproximationFonction1D nbSpires;


    /**
     * Paramètre global, statique
     */
    private Point3D vitesseGlobale;
    /**
     * Vitesse dynamique, propriétés de la fonction à déterminer
     */
    private ApproximationFonction2D vitesseDansLePlanNormaleAuTube;

    public TriComplexStruct(double longueur, int nbrPts, double diam, int nbSpires) {

    }

    public void initPoisition() {

    }
}
