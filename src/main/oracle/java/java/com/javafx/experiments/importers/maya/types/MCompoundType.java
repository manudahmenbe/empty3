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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.javafx.experiments.importers.maya.MEnv;
import com.javafx.experiments.importers.maya.values.MData;
import com.javafx.experiments.importers.maya.values.impl.MCompoundImpl;

public class MCompoundType extends MDataType {

    Map<String, Field> fields = new HashMap();
    List<Field> fieldArray = new ArrayList();

    public MCompoundType(MEnv env, String name) {
        super(env, name);
    }

    public Map<String, Field> getFields() {
        return fields;
    }

    public int getNumFields() {
        return fieldArray.size();
    }

    public int getFieldIndex(String name) {
        Field field = getField(name);
        if (field == null) {
            //            System.out.println("No such field in type " + getName() + ": " + name);
            return -1;
        }
        return getField(name).getIndex();
    }

    public Field getField(String name) {
        return fields.get(name);
    }

    public Field getField(int index) {
        return fieldArray.get(index);
    }

    public Field addField(String name, MDataType type, MData defaultValue) {
        Field field;
        fields.put(name, field = new Field(name, type, defaultValue, fieldArray.size()));
        fieldArray.add(field);
        return field;
    }

    public static class Field {
        String name;
        MDataType type;
        MData defaultValue;
        int index;

        public Field(String name, MDataType type, MData defaultValue, int index) {
            this.name = name;
            this.type = type;
            this.defaultValue = defaultValue;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public MDataType getType() {
            return type;
        }

        public MData getDefault() {
            //return defaultValue;
            return type.createData();
        }

        public int getIndex() {
            return index;
        }
    }

    public MData createData() {
        return new MCompoundImpl(this);
    }
}
