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

/**
 * *
 * rotation, translation, scaling
 * <p>
 * Translation et rotation d'objets. (OBJET) @ ((TRANSLATION: V3D) (ROTATION :
 * P3D, M3D)) Homothétie (OBJET) * (CENTRE: P3D, FACTEUR: DOUBLE) L'ordre a de
 * l'importance.
 *
 * @author Manuel
 * @ (T) @ (R) * (H)
 */
public class MODObjet {

    private MODRotation rotation;
    private MODTranslation translation;
    private MODHomothetie homothetie;

    public MODHomothetie homothetie() {
        return homothetie;
    }
    /*
     public Representable place(Representable r)
     {
     return r.place(this);
     }
     * 
     */

    public void modificateurs(MODRotation r, MODTranslation t, MODHomothetie h) {
        this.rotation = r;
        this.translation = t;
        this.homothetie = h;
    }

    public MODRotation rotation() {
        return rotation;
    }

    public MODTranslation translation() {
        return translation;
    }
}
