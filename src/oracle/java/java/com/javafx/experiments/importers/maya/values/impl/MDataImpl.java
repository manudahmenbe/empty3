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
import java.util.List;
import com.javafx.experiments.importers.maya.MEnv;
import com.javafx.experiments.importers.maya.types.MDataType;
import com.javafx.experiments.importers.maya.values.MData;

public abstract class MDataImpl implements MData {

    private MDataType dataType;

    public MEnv getEnv() {
        return getType().getEnv();
    }

    public MDataImpl(MDataType type) {
        dataType = type;
    }

    public MDataType getType() {
        return dataType;
    }

    public void setSize(int size) {
        // nothing
    }

    public void parse(String field, List<String> values) {
        MData value = doGet(field, 0);
        if (value == null) {
            //            System.out.println("field value is null: " +field + " in " + getType().getName());
        }
        value.parse(values);
    }

    public void parse(List<String> values) {
        parse(values.iterator());
    }

    public abstract void parse(Iterator<String> iter);

    // Get the data associated with the given string path
    public MData getData(String path) {
        //        System.out.println("get: "+ path);
        return doGet(path, 0);
    }

    // Field access for those values which support it, such as compound values
    public MData getFieldData(String name) {
        if (name.length() == 0) {
            return this;
        }
        return null;
    }

    // Index access for those values which suport it, such as array values
    public MData getData(int index) {
        if (index == 0) {
            return this;
        }
        return null;
    }

    // Slice access for those values which support it, such as array values
    public MData getData(int start, int end) {
        if (start == 0 && end == 0) {
            return this;
        }
        return null;
    }

    // Dereference from this MData down the path, starting parsing at the current point
    protected MData doGet(String path, int start) {
        if (start == path.length())
            return this;
        int dot = path.indexOf('.', start);
        int bracket = path.indexOf('[', start);
        if (dot == start) {
            return doGet(path, start + 1);
        } else if (bracket == start) {
            int endBracket = path.indexOf(']', start);
            int sliceStart = 0;
            int sliceEnd = 0;
            int i = start + 1;
            for (; i < endBracket; i++) {
                if (path.charAt(i) == ':')
                    break;
                sliceStart *= 10;
                sliceStart += path.charAt(i) - '0';
            }
            if (path.charAt(i) == ':') {
                i++;
                for (; i < endBracket; i++) {
                    sliceEnd *= 10;
                    sliceEnd += path.charAt(i) - '0';
                }
                // FIXME: downcast undesirable
                return ((MDataImpl) getData(sliceStart, sliceEnd)).doGet(path, endBracket + 1);
            } else {
                // FIXME: downcast undesirable
                return ((MDataImpl) getData(sliceStart)).doGet(path, endBracket + 1);
            }
        } else {
            int endIdx;
            if (dot < 0 && bracket < 0) {
                endIdx = path.length();
            } else {
                if (dot < 0) {
                    endIdx = bracket;
                } else if (bracket < 0) {
                    endIdx = dot;
                } else {
                    endIdx = Math.min(dot, bracket);
                }
            }
            String field = path.substring(start, endIdx);
            MData data = getFieldData(field);
            if (data == null) {
                //                System.err.println("WARNING: field data not found: "+field + " in "+ getType().getName());
                return null;
            } else {
                // FIXME: downcast undesirable
                return ((MDataImpl) data).doGet(path, endIdx);
            }
        }
    }
}
