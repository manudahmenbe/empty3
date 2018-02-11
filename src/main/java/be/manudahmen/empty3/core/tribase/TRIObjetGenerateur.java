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
package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;

/**
 * Implémentations requises: TRIGenerable, TourDeRevolution, Tubulaire, Spheres
 *
 * @author manuel
 */
public interface TRIObjetGenerateur {

    Point3D coordPoint3D(int x, int y);

    boolean getCirculaireX();

    void setCirculaireX(boolean cx);

    boolean getCirculaireY();

    void setCirculaireY(boolean cy);

    int getMaxX();

    void setMaxX(int maxX);

    int getMaxY();

    void setMaxY(int maxX);

    Point3D getPoint3D(TRI[] tris, int numX, int numY, double ratioX, double ratioY);

    /**
     * *
     *
     * @param numX           numéro de valeur de x par rapport à maxX
     * @param numY           numéro de valeur de y par rapport à maxY
     * @param tris_LEFT_NORD
     */
    void getTris(int numX, int numY, TRI[] tris);

}
