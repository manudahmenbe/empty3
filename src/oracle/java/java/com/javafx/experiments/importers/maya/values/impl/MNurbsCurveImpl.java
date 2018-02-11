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
import com.javafx.experiments.importers.maya.types.MNurbsCurveType;
import com.javafx.experiments.importers.maya.values.MData;
import com.javafx.experiments.importers.maya.values.MNurbsCurve;

public class MNurbsCurveImpl extends MDataImpl implements MNurbsCurve {
    int degree;
    int spans;
    int form;
    boolean rational;
    int dimension;
    int numKnots;
    float[] knots;
    int numCvs;
    float[] cvs;

    public MNurbsCurveImpl(MNurbsCurveType type) {
        super(type);
    }

    public MData getData(int start, int end) {
        return this; // hack?
    }

    public int getDegree() {
        return degree;
    }

    public int getSpans() {
        return spans;
    }

    public int getForm() {
        return form;
    }

    public boolean isRational() {
        return rational;
    }

    public int getDimension() {
        return dimension;
    }

    public int getNumKnots() {
        return numKnots;
    }

    public float[] getKnots() {
        return knots;
    }

    public int getNumCVs() {
        return numCvs;
    }

    public float[] getCVs() {
        return cvs;
    }


    public void parse(Iterator<String> values) {
        degree = Integer.parseInt(values.next());
        //        System.out.println("degree="+degree);
        spans = Integer.parseInt(values.next());
        //        System.out.println("spans="+spans);
        form = Integer.parseInt(values.next());
        //        System.out.println("form="+form);
        String tok = values.next();
        //        rational = tok.equals("yes");
        //        System.out.println("rational="+rational);
        dimension = Integer.parseInt(values.next());
        //        System.out.println("dimension="+dimension);
        numKnots = Integer.parseInt(values.next());
        //        System.out.println("numKnots="+numKnots);
        knots = new float[numKnots];
        for (int i = 0; i < numKnots; i++) {
            knots[i] = Float.parseFloat(values.next());
            //            System.out.println("knot="+knots[i]);
        }
        numCvs = Integer.parseInt(values.next());
        cvs = new float[numCvs * dimension];
        for (int i = 0; i < cvs.length; i++) {
            cvs[i] = Float.parseFloat(values.next());
        }
    }

}
