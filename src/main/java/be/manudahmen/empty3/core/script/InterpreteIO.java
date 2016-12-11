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
package be.manudahmen.empty3.core.script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel DAHMEN
 * @date
 */
public class InterpreteIO {

    public static File getFile(String filename, String repertoire) throws FileNotFoundException {
        File f = new File(filename);
        if (f.exists()) {
            return f;
        }

        Properties config = new Properties();
        try {
            config.load(new FileInputStream(System.getProperty("user.home") + File.separator + java.util.ResourceBundle.getBundle("info/emptycanvas/library/gui/Bundle").getString("NOM DU FICHIER DE CONFIGURATION PROPERTIES")));
            f = new File(config.getProperty("folder.textures") + File.separator + filename);
        } catch (IOException ex) {
            Logger.getLogger(InterpreteIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (f != null && f.exists()) {
            return f;
        }

        f = new File(repertoire + File.separator + filename);
        if (f != null && f.exists()) {
            return f;
        }
        throw new FileNotFoundException(
                "Default Folders: \n\t" + repertoire
                        + (config == null ? "\n\t" : "\n\t" + File.pathSeparator
                        + config.getProperty("folder.textures"))
                        + "\nFile: \n\t" + filename);
    }
}
