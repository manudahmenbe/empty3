package be.manudahmen.emptycanvas.library.empty3.library.object;

import be.manudahmen.emptycanvas.library.empty3.library.tribase.ApproximationFonction1D;

import java.util.ArrayList;

/**
 * Created by manuel on 29-07-16.
 * <p>
 * Opacités
 * Lumières diffuse
 * Lumière ambiante
 * Diffraction
 * Réffraction
 * Réflexion
 * Ombres
 */
public class Trainee {
    private ArrayList<Point3D> traines;
    private ApproximationFonction1D taillesF;
    private ArrayList<Double> taille;
    /***
     * Distance Unité : px
     */
    private Double distMax;
    /***
     * Distance Unité : px
     */
    private Double distMin;
    /***
     * double 0..1
     */
    private ArrayList<Double> opacites;
    /***
     * Fonction définie sur [0,taille] à valeur dans [0,1]
     */
    private ApproximationFonction1D opacitesF;

    public Trainee() {

    }

    public ApproximationFonction1D getOpacitesF() {
        return opacitesF;
    }

    public void setOpacitesF(ApproximationFonction1D opacitesF) {
        this.opacitesF = opacitesF;
    }

    public ApproximationFonction1D getTaillesF() {
        return taillesF;
    }

    public void setTaillesF(ApproximationFonction1D taillesF) {
        this.taillesF = taillesF;
    }

    public ArrayList<Double> getOpacites() {
        return opacites;
    }

    public void setOpacites(ArrayList<Double> opacites) {
        this.opacites = opacites;
    }

    public ArrayList<Double> getTaille() {
        return taille;
    }

    public void setTaille(ArrayList<Double> taille) {
        this.taille = taille;
    }

    public ArrayList<Point3D> getTraines() {
        return traines;
    }

    public void setTraines(ArrayList<Point3D> traines) {
        this.traines = traines;
    }

    public Double getDistMax() {
        return distMax;
    }

    public void setDistMax(Double distMax) {
        this.distMax = distMax;
    }

    public Double getDistMin() {
        return distMin;
    }

    public void setDistMin(Double distMin) {
        this.distMin = distMin;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
