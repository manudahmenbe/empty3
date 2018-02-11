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

package be.manudahmen.empty3.core.animation;

import be.manudahmen.empty3.Representable;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         14 déc. 2011
 */
public class AnimationMouvements {

    private Animation animation;
    private Fonction fonction;
    private Representable representable;

    public AnimationMouvements(Representable representable, FonctionTemps fp) {
        this.representable = representable;
        fonction = fp;
    }

    protected void setFonctionModele(FonctionModele fm) {
        this.fonction = fm;
    }

    protected void setFonctionPosition(FonctionTemps fp) {
        this.fonction = fp;
    }

    public void updateObject(AnimationTime time) {

    }
}
