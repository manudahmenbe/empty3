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

package com.javafx.experiments.importers.maya.types;

import com.javafx.experiments.importers.maya.MEnv;
import com.javafx.experiments.importers.maya.values.MData;
import com.javafx.experiments.importers.maya.values.MFloatArray;
import com.javafx.experiments.importers.maya.values.impl.MFloatArrayImpl;

public class MMatrixType extends MFloatArrayType {

    public static final String NAME = "matrix";

    public MMatrixType(MEnv env) {
        super(env, NAME);
    }

    public MData createData() {
        MFloatArray array = new MFloatArrayImpl(this);
        array.setSize(16);
        // Make the default value the identity matrix
        array.set(0, 1);
        array.set(5, 1);
        array.set(10, 1);
        array.set(15, 1);
        return array;
    }
}
