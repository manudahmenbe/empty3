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

package be.manudahmen.empty3.core.raytracer;

import be.manudahmen.empty3.Point3D;

public class RtRay {
    public Point3D mVStart;
    public Point3D mVDir;
    public double mT;
    public Point3D mVDirX1;
    public Point3D mVDirX_1;
    public Point3D mVDirY1;
    public Point3D mVDirY_1;
    public double distance;

    public RtRay() {
    }
}
