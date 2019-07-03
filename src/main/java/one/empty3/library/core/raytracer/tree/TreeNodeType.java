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

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public abstract class TreeNodeType {
    protected Object[] values;
    protected double sign1; // 1=*
    private TreeNodeType d;
    private TreeNodeType tnt;
    public TreeNodeType() {
    }

    public TreeNodeType(double sign1) {
        super();
        this.sign1 = sign1;
    }

    public double getSign1() {
        return sign1;
    }

    public abstract Double eval();

    public void setValues(Object[] values) {
        this.values = values;
    }

    protected void instantiate(Object[] objects) {

        this.tnt = this;


    }

    public String toString() {
        String s = "Type : " + this.getClass() + " \n";
        if (values != null) {
            int i = 0;
            for (Object o : values) {
                s += (o!=null?o.toString():"") + " (+) ";
            }
        }
        return s;
    }

}
