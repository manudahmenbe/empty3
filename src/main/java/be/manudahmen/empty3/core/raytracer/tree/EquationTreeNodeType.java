/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
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

/**
 * Created by manuel on 25-12-16.
 */
public class EquationTreeNodeType extends TreeNodeType {
    public final String E1EQE2 = "=";
    public final String E1NTEQE2 = "<>";
    public final String E1EGTE2 = ">";
    public final String E1EGTQE2 = ">=";
    public final String E1ELTE2 = "<=";
    public final String E1LTE2 = "<";

    public EquationTreeNodeType(int sign1) {
        super(sign1);
    }

    @Override
    public Object eval() {
        return null;
    }
}
