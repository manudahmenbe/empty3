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
 * Created by Manuel Dahmen on 15-12-16.
 */
public abstract class TreeNodeType {
    protected Object[] values;
    private TreeNodeType d;
    private TreeNodeType tnt;

    public TreeNodeType() {
    }

    public abstract Object eval();

    public void setValues(Object[] values) {
        this.values = values;
    }

    protected void instantiate(Object[] objects) {
        this.tnt = this;


    }

    public String toString() {
        String s = "Type : " + this.getClass() + " \n";
        if (values != null)
            for (Object o : values) {
                s += this.values + " (+) ";
            }
        return s;
    }
}
