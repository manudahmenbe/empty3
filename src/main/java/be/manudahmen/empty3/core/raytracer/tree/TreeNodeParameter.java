package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class TreeNodeParameter extends TreeNodeValue  {
    public TreeNodeParameter(TreeNode parent, String expressionString) {
        super(parent, expressionString);
    }

    @Override
    public Object eval() {
        return null;
    }
}
