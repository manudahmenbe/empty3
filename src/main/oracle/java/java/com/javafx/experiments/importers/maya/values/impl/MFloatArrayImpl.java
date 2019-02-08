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
import com.javafx.experiments.importers.maya.types.MFloatArrayType;
import com.javafx.experiments.importers.maya.values.MData;
import com.javafx.experiments.importers.maya.values.MFloatArray;

public class MFloatArrayImpl extends MDataImpl implements MFloatArray {

    private float[] data;

    static class Parser {
        private MFloatArray array;

        Parser(MFloatArray array) {
            this.array = array;
        }

        public void parse(Iterator<String> elements) {
            int i = 0;
            //        System.out.println("PARSING FLOAT ARRAY");
            while (elements.hasNext()) {
                String str = elements.next();
                if ("nan".equals(str)) {
                    str = "0";
                }
                array.set(
                        i++,
                        Float.parseFloat(str));
            }
        }
    }

    static class MFloatArraySlice extends MDataImpl implements MFloatArray {
        private MFloatArray array;
        private int base;
        private int length;

        MFloatArraySlice(
                MFloatArray array,
                int base,
                int length) {
            super((MFloatArrayType) array.getType());
            this.array = array;
            this.base = base;
            this.length = length;
        }

        public void setSize(int size) {
            array.setSize(base + size);
        }

        public int getSize() {
            return length;
        }

        public void set(int index, float x) {
            if (index >= length) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            array.set(base + index, x);
        }

        public float[] get() {
            // FIXME
            throw new RuntimeException("Probably shouldn't fetch the data behind a slice");
        }

        public float get(int index) {
            return array.get(base + index);
        }

        public void parse(Iterator<String> elements) {
            new Parser(this).parse(elements);
        }
    }

    public MFloatArrayImpl(MFloatArrayType type) {
        super(type);
    }

    public void setSize(int size) {
        if (data == null || size > data.length) {
            float[] newdata = new float[size];
            if (data != null) {
                System.arraycopy(data, 0, newdata, 0, data.length);
            }
            data = newdata;
        }
    }

    public int getSize() {
        return data == null ? 0 : data.length;
    }


    public void set(int index, float x) {
        setSize(index + 1);
        data[index] = x;
    }

    public float[] get() {
        return data;
    }

    public float get(int index) {
        return data[index];
    }

    public MData getData(int index) {
        return getData(index, index + 1);
    }

    public MData getData(int start, int end) {
        return new MFloatArraySlice(this, start, end - start + 1);
    }

    public void parse(Iterator<String> elements) {
        new Parser(this).parse(elements);
    }

    public String toString() {
        String result = getType().getName();
        String sep = " ";
        if (data != null) {
            for (float f : data) {
                result += sep;
                result += f;
            }
        }
        return result;
    }
}
