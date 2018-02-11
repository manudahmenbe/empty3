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

/**
 * Created by manuel on 16-12-16.
 */
public class FunctionTreeNodeType extends TreeNodeType {
    private AlgebraicTree algebraicTree;
    private double exp1;
    private String fName;
    private double[] objects;

    public AlgebraicTree getAlgebraicTree() {
        return algebraicTree;
    }

    public void setAlgebraicTree(AlgebraicTree algebraicTree) {
        this.algebraicTree = algebraicTree;
    }

    @Override
    public Object eval() {
        return null;
    }

    @Override
    protected void instantiate(Object[] objects) {
        this.fName = (String) objects[0];
    }

    public String getFName() {
        return fName;
    }

    public Double compute() {
        return 0.0;
    }

    public void setObjects(double[] objects) {
        this.objects = objects;
    }

    public double[] getValue() {
        return objects;
    }

}
