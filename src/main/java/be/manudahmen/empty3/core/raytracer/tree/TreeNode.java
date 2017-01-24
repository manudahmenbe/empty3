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

import java.util.ArrayList;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class TreeNode {
    protected TreeNodeType type = null;
    private TreeNodeValue value;
    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
    private TreeNode parent;
    private String expressionString;

    public TreeNode(String expStr) {
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
        expressionString = (String) objects[0];
    }

    public Object getValue() {
        return value;
    }

    public void setValue(TreeNodeValue value) {
        this.value = value;
    }


    public Object eval() throws TreeNodeEvalException {
        TreeNodeType cType = (getChildren().size() == 0) ? type : getChildren().get(0).type;
        /*if (type instanceof IdentTreeNodeType) {
            return getChildren().get(0).eval();
        }*/
        if (cType instanceof EquationTreeNodeType) {
            return (Double) getChildren().get(0).eval() - (Double) getChildren().get(1).eval() == 0;
        }
        if (cType instanceof IdentTreeNodeType) {
            return getChildren().get(0).eval();
        }
        if (cType instanceof DoubleTreeNodeType) {
            return cType.eval();
        } else if (cType instanceof ExponentTreeNodeType) {
            return Math.pow((Double) getChildren().get(0).eval(), (Double) getChildren().get(1).eval());
        } else if (cType instanceof FactorTreeNodeType) {
            if (getChildren().size() == 1) {
                return ((Double) getChildren().get(0).eval()) * getChildren().get(0).type.getSign1();
            }
            double dot = 1;
            for (int i = 0; i < getChildren().size(); i++) {
                TreeNode treeNode = getChildren().get(i);
                int op1 = treeNode.type.getSign1();
                if (op1 == 1)


                    dot *= op1 * (Double) treeNode.eval();
                else

                    dot /= (Double) treeNode.eval();
            }
            return dot;


        } else if (cType instanceof FunctionTreeNodeType) {
            return (((FunctionTreeNodeType) cType).compute());
        } else if (cType instanceof TermTreeNodeType) {
            if (getChildren().size() == 1) {
                return getChildren().get(0).eval();
            }
            double sum = 0;
            for (int i = 0; i < getChildren().size(); i++) {
                TreeNode treeNode = getChildren().get(i);
                int op1 = treeNode.type.getSign1();
                sum += op1 * (Double) treeNode.eval();
                }


            return sum;
        }
        if (cType instanceof SignTreeNodeType) {
            int s1 = ((SignTreeNodeType) cType).getSign();
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


    public String toString() {
        String s = "TreeNode " + this.getClass().getSimpleName() +
                "\nExpression string: " + expressionString +
                (type == null ? "\nType null" :
                        "\nType: " + type.getClass() + "\n " + type.toString()) +
                "\nChildren: \n";
        int i = 0;
        for (TreeNode t :
                getChildren()) {
            s += "Child (" + i++ + ") : " + t.toString();
        }
        return s;
    }
}
