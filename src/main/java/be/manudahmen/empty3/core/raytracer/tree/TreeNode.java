package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by mary on 15-12-16.
 */
public class TreeNode<E> {
    private E type;
    private TreeNodeValue value;
    private TreeNode<E>[] children;
    private TreeNode<E> parent;
    private String expressionString;
    public void setValue(TreeNodeValue value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
    }

    public TreeNode<E>[] getChildren() {
        return children;
    }

    public void setChildren(TreeNode<E>[] children) {
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
