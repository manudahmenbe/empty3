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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.empty3.library.core.gdximports;

import one.empty3.library.*;
import com.badlogic.gdx.math.Vector3;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class Conv {
    public static Vector3 conv(Vector3 out, Point3D in) {
        out.set(new float[]{(float) (double) in.get(0), (float) (double) in.get(1), (float) (double) in.get(2)});
        return out;
    }

    public static Point3D conv(Point3D out, Vector3 in) {
        out.set(0, (double) in.x);
        out.set(1, (double) in.y);
        out.set(2, (double) in.z);
        return out;
    }
}
