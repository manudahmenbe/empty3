package be.manudahmen.empty3.core.raytracer.tree;

import java.util.ArrayList;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class TreeNode<E extends TreeNodeType> {
    private E type;
    private TreeNodeValue value;
    private ArrayList<TreeNode<E>> children;
    private TreeNode<E> parent;
    private String expressionString;
    public TreeNode(String expStr)
    {
        this.parent = null;
        this.expressionString = expStr;
    }
    public TreeNode(TreeNode<E> parent, String expressionString) {
        this.parent = parent;
        this.expressionString = expressionString;
    }

    public void setValue(TreeNodeValue value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Object  eval(){return false;}

    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
    }

    public ArrayList<TreeNode<E>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode<E>> children) {
        this.children = children;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public String getExpressionString() {
        return expressionString;
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }
}
