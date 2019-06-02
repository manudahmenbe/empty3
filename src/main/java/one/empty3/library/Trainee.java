/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package one.empty3.library;

import one.empty3.library.core.tribase.ApproximationFonction1D;

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
