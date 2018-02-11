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
import com.javafx.experiments.importers.maya.MNode;
import com.javafx.experiments.importers.maya.MPath;
import com.javafx.experiments.importers.maya.types.MPointerType;
import com.javafx.experiments.importers.maya.values.MData;
import com.javafx.experiments.importers.maya.values.MPointer;

public class MPointerImpl extends MDataImpl implements MPointer {

    private MPath target;

    public MPointerImpl(MPointerType type) {
        super(type);
    }

    public void setTarget(MPath path) {
        target = path;
    }

    public MPath getTarget() {
        return target;
    }

    public void set(MData data) {
        //targetNode.setAttr(targetAttribute, data);
    }

    public MData get() {
        return target.apply();
    }

    public void parse(Iterator<String> iter) {
        // Nothing
    }

    public String toString() {
        if (target != null) {
            return target.toString();
        } else {
            return "Null Pointer";
        }
    }

    public MNode getTargetNode() {
        return target.getTargetNode();
    }
}
