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

package one.empty3.library.utils;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by manuel on 30-11-16.
 */
public class ConsoleUtils {
    protected static DateFormat dateFormat;

    static {
        DateFormatter dfer = new DateFormatter();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss-SSSXX");

    }

    public static String currentDate() {

        return dateFormat.format(new Date());
    }
}
