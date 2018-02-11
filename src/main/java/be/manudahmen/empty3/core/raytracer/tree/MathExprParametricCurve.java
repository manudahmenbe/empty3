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

package be.manudahmen.empty3.core.raytracer.tree;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;

import java.util.HashMap;

/**
 * Created by manuel on 05-02-17.
 */
public class MathExprParametricCurve extends ParametricCurve {
    /***
     * t: parameter
     */
    private final String[] exprStringXyz;
    AlgebraicTree[] algebraicTree;

    public MathExprParametricCurve(String[] exprStringXyz) {
        this.exprStringXyz = exprStringXyz;
        algebraicTree = new AlgebraicTree[exprStringXyz.length];
        for (int i = 0; i < exprStringXyz.length; i++) {
            try {
                algebraicTree[i] = new AlgebraicTree(exprStringXyz[i], null);
            } catch (AlgebraicFormulaSyntaxException e) {
                e.printStackTrace();
            }

        }
    }

    public Point3D calculerPoint3D(double t) {
        Point3D p = new Point3D();
        HashMap<String, Double> stringDoubleHashMap = new HashMap<>();
        stringDoubleHashMap.put("t", t);
        for (int i = 0; i < algebraicTree.length; i++) {
            algebraicTree[i].setParametersValues(stringDoubleHashMap);
            try {
                p.set(i, (Double) algebraicTree[i].eval());
            } catch (TreeNodeEvalException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("pas encore implanté");

    }

}
