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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.javafx.experiments.importers.maya.types.MComponentListType;
import com.javafx.experiments.importers.maya.values.MComponentList;

public class MComponentListImpl extends MDataImpl implements MComponentList {

    private List<Component> components = new ArrayList<Component>();

    public MComponentListImpl(MComponentListType type) {
        super(type);
    }

    public void set(List<Component> value) {
        components = value;
    }

    public List<Component> get() {
        return components;
    }

    public void parse(Iterator<String> values) {
        try {
            int num = Integer.parseInt(values.next());
            for (int i = 0; i < num; i++) {
                components.add(Component.parse(values.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(getType().getName());
        for (Component c : components) {
            res.append(" ");
            res.append(c);
        }
        return res.toString();
    }
}
