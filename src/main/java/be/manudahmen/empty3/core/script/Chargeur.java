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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.ID;
import be.manudahmen.empty3.Scene;

import java.io.File;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public interface Chargeur {

    void chargerFichierEntier(File f, Scene scene);

    void chercherObjet(ID id, Scene scene);

    void modifierObjet(ID id, String objet, Scene scene);

    String[] supportType();
}
