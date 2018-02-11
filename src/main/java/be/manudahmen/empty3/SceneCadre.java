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

/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3;

import java.io.Serializable;

/**
 * cadre à la scène, avec possibilité d'élargir le cadre ou de ne pas en tenir
 * compte
 *
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 24-mars-2012
 */
public class SceneCadre implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2001787693050570304L;
    private Point3D[] points = new Point3D[4];
    private boolean cadre = false;
    private boolean exterieur = false;

    public SceneCadre() {
        cadre = false;
    }

    public SceneCadre(Point3D[] p) {
        this.points = p;
        cadre = true;
    }

    public Point3D get(int i) {
        return points[i];
    }

    public boolean isCadre() {
        return cadre;
    }

    public boolean isExterieur() {
        return exterieur;
    }

    public void setExterieur(boolean b) {
        this.exterieur = b;
    }

    public void set(int i, Point3D p) {
        this.points[i] = p;
    }

}
