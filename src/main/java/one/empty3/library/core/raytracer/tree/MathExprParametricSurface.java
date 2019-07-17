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

package one.empty3.library.core.raytracer.tree;

import one.empty3.library.Point3D;
import one.empty3.library.core.nurbs.ParametricSurface;

import java.util.HashMap;

/**
 * Created by manuel on 05-02-17.
 */
public class MathExprParametricSurface extends ParametricSurface {
    /***
     * a, b: parameters
     */
    private final String[] exprStringXyz;
    AlgebricTree[] algebricTree;

    public MathExprParametricSurface(String[] exprStringXyz) {
        this.exprStringXyz = exprStringXyz;
        algebricTree = new AlgebricTree[exprStringXyz.length];
        for (int i = 0; i < exprStringXyz.length; i++) {
            try {
                algebricTree[i] = new AlgebricTree(exprStringXyz[i]);
            } catch (AlgebraicFormulaSyntaxException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D p = new Point3D();
        HashMap<String, Double> stringDoubleHashMap = new HashMap<>();
        stringDoubleHashMap.put("a", u);
        stringDoubleHashMap.put("b", v);
        for (int i = 0; i < algebricTree.length; i++) {
            algebricTree[i].getParametersValues().putAll(stringDoubleHashMap);
            try {
                p.set(i, (Double) algebricTree[i].eval());
            } catch (TreeNodeEvalException e) {
                e.printStackTrace();
            } catch (AlgebraicFormulaSyntaxException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        throw new UnsupportedOperationException("pas encore implanté");
    }
}
