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

import be.manudahmen.empty3.core.ECDim;
import be.manudahmen.empty3.core.animation.Animation;
import be.manudahmen.empty3.core.extra.SimpleSphere;

import java.awt.*;
import java.util.Random;

public class RandomSpheres extends Animation {

    private Point3D[] ran;
    private Point3D[] next;
    private int n = 10;
    private float t = 0;
    private Random r = new Random();

    public RandomSpheres(Scene s) {
        super(s, new ECDim(1000, 1000));
        n = 10;
        ran = new Point3D[n];
        next = new Point3D[n];
        for (int i = 0; i < n; i++) {
            ran[i] = new Point3D(r.nextDouble() * 100, r.nextDouble() * 100, r.nextDouble() * 100);
            next[i] = new Point3D(r.nextDouble() * 100, r.nextDouble() * 100, r.nextDouble() * 100);

        }

    }

    public void modifier() {
        Scene s = new Scene();
        t += 0.01f;
        if (t > 1) {
            t = 0;
            for (int i = 0; i < n; i++) {
                ran[i] = next[i];
                next[i] = new Point3D(r.nextDouble() * 100, r.nextDouble() * 100, r.nextDouble() * 100);

            }
        }
        for (int i = 0; i < n; i++) {
            SimpleSphere ss = new SimpleSphere(ran[i].mult(1 - t).plus(next[i].mult(t)), i, Color.white);
            s.add(ss);
        }
        scene = s;
    }
}
