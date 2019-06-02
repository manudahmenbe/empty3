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
package one.empty3.library.core.tribase;

import java.util.HashMap;

public class Params {

    private HashMap<String, Object> params;

    public HashMap<String, Object> getParams() {
        return params;
    }
    // SCREEN PARAMS
    // DISK PARAMS
    // ANIMATION PARAMS
    // 

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }
}
