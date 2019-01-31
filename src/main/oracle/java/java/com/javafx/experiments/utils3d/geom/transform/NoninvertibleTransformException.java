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

package com.javafx.experiments.utils3d.geom.transform;

/**
 * The <code>NoninvertibleTransformException</code> class represents
 * an exception that is thrown if an operation is performed requiring
 * the inverse of a {@link com.javafx.experiments.utils3d.geom.transform.BaseTransform} object but the
 * <code>BaseTransform</code> is in a non-invertible state.
 *
 * @version 1.25, 05/05/07
 */

public class NoninvertibleTransformException extends Exception {
    /**
     * Constructs an instance of
     * <code>NoninvertibleTransformException</code>
     * with the specified detail message.
     *
     * @param s the detail message
     */
    public NoninvertibleTransformException(String s) {
        super(s);
    }
}
