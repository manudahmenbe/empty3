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

import one.empty3.library.Matrix33;
/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class MatrixTreeNodeType extends TreeNode
{
    private Matrix33 m;

    public MatrixTreeNodeType(String expStr) {
        super(expStr);
    }

    public MatrixTreeNodeType(TreeNode src, Object[] objects, TreeNodeType clazz) {
        super(src, objects, clazz);
    }


    @Override
    public Object eval() {
        return m;
    }
}
