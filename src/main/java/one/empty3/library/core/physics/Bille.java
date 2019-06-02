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

package one.empty3.library.core.physics;

import one.empty3.library.*;

import java.awt.*;


public class Bille implements IPoint {
    public Color color;
    public String nom;
    public Point3D position;
    public Point3D vitesse = new Point3D(0, 0, 0);
    public double attraction;
    public double repulsion;
    public double masse = 1;
    public double amortissement = 1;


    public Bille(Color color, int statut, String nom, Point3D position,
                 Point3D vitesse, double attraction, double repulsion, double masse,
                 double amortissement) {
        super();
        this.color = color;
        this.nom = nom;
        this.position = position;
        this.vitesse = vitesse;
        this.attraction = attraction;
        this.repulsion = repulsion;
        this.masse = masse;
        this.amortissement = amortissement;
    }

    public Bille(Bille b) {
        super();
        this.color = b.color;
        this.nom = b.nom;
        this.position = b.position;
        this.vitesse = b.vitesse;
        this.attraction = b.attraction;
        this.repulsion = b.repulsion;
        this.masse = b.masse;
        this.amortissement = b.amortissement;
    }

    public Bille() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

    public Point3D getVitesse() {
        return vitesse;
    }

    public void setVitesse(Point3D vitesse) {
        this.vitesse = vitesse;
    }

    public double getAttraction() {
        return attraction;
    }

    public void setAttraction(double attraction) {
        this.attraction = attraction;
    }

    public double getRepulsion() {
        return repulsion;
    }

    public void setRepulsion(double repulsion) {
        this.repulsion = repulsion;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) {
        this.masse = masse;
    }

    public double getAmortissement() {
        return amortissement;
    }

    public void setAmortissement(double amortissement) {
        this.amortissement = amortissement;
    }

}
