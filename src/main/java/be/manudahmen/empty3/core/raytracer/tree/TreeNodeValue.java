package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public abstract  class TreeNodeValue  extends TreeNode
{

    public TreeNodeValue(TreeNode parent, String expressionString) {
        super(parent, expressionString);
    }

    public Object getValue() {
        return null;
    }

    public abstract Object eval();

}
