/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.empty3.core.suvoxel;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Polygon;
import be.manudahmen.empty3.Representable;

/**
 * Created by manuel on 14-01-17.
 */
public class Cell extends Representable {
    private Point3D origin;
    private Polygon avant, arriere, gauche, droite, haut, bas;

    public Cell(Point3D p) {
        generatePolygons();
    }

    private void generatePolygons() {
    }

    public boolean includes(Point3D p) {
        return false;
    }


    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origin) {
        this.origin = origin;
    }

    public Polygon getAvant() {
        return avant;
    }

    public void setAvant(Polygon avant) {
        this.avant = avant;
    }

    public Polygon getArriere() {
        return arriere;
    }

    public void setArriere(Polygon arriere) {
        this.arriere = arriere;
    }

    public Polygon getGauche() {
        return gauche;
    }

    public void setGauche(Polygon gauche) {
        this.gauche = gauche;
    }

    public Polygon getDroite() {
        return droite;
    }

    public void setDroite(Polygon droite) {
        this.droite = droite;
    }

    public Polygon getHaut() {
        return haut;
    }

    public void setHaut(Polygon haut) {
        this.haut = haut;
    }

    public Polygon getBas() {
        return bas;
    }

    public void setBas(Polygon bas) {
        this.bas = bas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (getOrigin() != null ? !getOrigin().equals(cell.getOrigin()) : cell.getOrigin() != null) return false;
        if (getAvant() != null ? !getAvant().equals(cell.getAvant()) : cell.getAvant() != null) return false;
        if (getArriere() != null ? !getArriere().equals(cell.getArriere()) : cell.getArriere() != null) return false;
        if (getGauche() != null ? !getGauche().equals(cell.getGauche()) : cell.getGauche() != null) return false;
        if (getDroite() != null ? !getDroite().equals(cell.getDroite()) : cell.getDroite() != null) return false;
        if (getHaut() != null ? !getHaut().equals(cell.getHaut()) : cell.getHaut() != null) return false;
        return getBas() != null ? getBas().equals(cell.getBas()) : cell.getBas() == null;

    }

    @Override
    public int hashCode() {
        int result = getOrigin() != null ? getOrigin().hashCode() : 0;
        result = 31 * result + (getAvant() != null ? getAvant().hashCode() : 0);
        result = 31 * result + (getArriere() != null ? getArriere().hashCode() : 0);
        result = 31 * result + (getGauche() != null ? getGauche().hashCode() : 0);
        result = 31 * result + (getDroite() != null ? getDroite().hashCode() : 0);
        result = 31 * result + (getHaut() != null ? getHaut().hashCode() : 0);
        result = 31 * result + (getBas() != null ? getBas().hashCode() : 0);
        return result;
    }
}
