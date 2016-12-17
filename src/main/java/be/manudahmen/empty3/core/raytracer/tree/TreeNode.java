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

import java.util.ArrayList;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class TreeNode {
    private TreeNodeType type = null;
    private TreeNodeValue value;
    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
    private TreeNode parent;
    private String expressionString;
    public TreeNode(String expStr)
    {
        this.parent = null;
        this.expressionString = expStr;
    }

    /*
        public TreeNode(TreeNode parent, String expressionString) {
            this.parent = parent;
            this.expressionString = expressionString;
        }
    */
    public TreeNode(TreeNode src, Object[] objects, TreeNodeType clazz) {
        this.parent = src;
        clazz.instantiate(objects);
        this.type = clazz;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(TreeNodeValue value) {
        this.value = value;
    }


    public Object eval() {
        if (type instanceof DoubleTreeNodeType) {
            return type.eval();
        } else if (type instanceof ExponentTreeNodeType) {
            return Math.pow((Double) getChildren().get(0).eval(), (Double) getChildren().get(1).eval());
        }
        if (type instanceof FactorTreeNodeType) {
            return (Double) getChildren().get(0).eval() * (Double) getChildren().get(1).eval();
        }
        if (type instanceof FunctionTreeNodeType) {
            switch (((FunctionTreeNodeType) type).getFName()) {

            }
            return false;
        }
        if (type instanceof TermTreeNodeType) {
            int s1 = (Integer) ((TermTreeNodeType) type).getSign1();
            int s2 = (Integer) ((TermTreeNodeType) type).getSign2();
            return s1 * (Double) getChildren().get(0).eval() + s2 * (Double) getChildren().get(1).eval();
        }
        if (type instanceof SignTreeNodeType) {
            int s1 = ((SignTreeNodeType) type).getSign();
            return s1 * (Double) getChildren().get(0).eval();
        }

        return type.eval();
    }


    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode> children) {
        this.children = children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getExpressionString() {
        return expressionString;
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }
}
