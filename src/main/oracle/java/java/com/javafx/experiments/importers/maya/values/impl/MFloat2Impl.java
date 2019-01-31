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

package com.javafx.experiments.importers.maya.values.impl;

import java.util.Iterator;
import com.javafx.experiments.importers.maya.types.MFloat2Type;
import com.javafx.experiments.importers.maya.values.MData;
import com.javafx.experiments.importers.maya.values.MFloat;
import com.javafx.experiments.importers.maya.values.MFloat2;

public class MFloat2Impl extends MDataImpl implements MFloat2 {

    private float[] data = new float[2];

    class MFloat2Component extends MDataImpl implements MFloat {
        private int index;

        MFloat2Component(int index) {
            super(MFloat2Impl.this.getEnv().findDataType("float"));
            this.index = index;
        }

        public void set(float value) {
            data[index] = value;
        }

        public float get() {
            return data[index];
        }

        public void parse(Iterator<String> elements) {
            data[index] = Float.parseFloat(elements.next());
        }
    }

    public MFloat2Impl(MFloat2Type type) {
        super(type);
    }

    public void set(float x, float y) {
        data[0] = x; data[1] = y;
    }

    public float[] get() {
        return data;
    }

    public float getX() {
        return data[0];
    }

    public float getY() {
        return data[1];
    }

    public float get(int index) {
        return data[index];
    }

    public void parse(Iterator<String> elements) {
        for (int i = 0; i < 2; i++) {
            data[i] = Float.parseFloat(elements.next());
        }
    }

    public MData getData(int index) {
        return new MFloat2Component(index);
    }

    public MData getData(String name) {
        if (name.equals("x")) {
            return getData(0);
        } else if (name.equals("y")) {
            return getData(1);
        }
        return super.getData(name);
    }
}
