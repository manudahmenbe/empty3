package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by mary on 15-12-16.
 */
public class TreeNodeFunction extends TreeNodeValue  {
    public TreeNodeFunction(TreeNode parent, String expressionString) {
        super(parent, expressionString);
    }

    @Override
    public Object eval() {
        return null;
    }
}
