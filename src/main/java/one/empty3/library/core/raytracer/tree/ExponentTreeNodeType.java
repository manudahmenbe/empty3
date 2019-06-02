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

package one.empty3.library.core.raytracer.tree;

/**
 * Created by manuel on 16-12-16.
 */
public class ExponentTreeNodeType extends TreeNodeType {
    private double sign1, sign2;

    public ExponentTreeNodeType(Double d1, Double d2) {
        this.sign1 = d1;
        this.sign2 = d2;
    }


    @Override
    public Object eval() {
        return Math.pow(sign1, sign2);
    }

    @Override
    protected void instantiate(Object[] objects) {
        this.sign1 = (Double) objects[0];
        this.sign2 = (Double) objects[1];
    }


}
