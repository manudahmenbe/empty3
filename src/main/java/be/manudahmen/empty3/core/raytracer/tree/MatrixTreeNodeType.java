package be.manudahmen.empty3.core.raytracer.tree;

import be.manudahmen.empty3.Matrix33;

/**
 * Created by mary on 15-12-16.
 */
public class MatrixTreeNodeType extends TreeNodeValue
{
    private Matrix33 m;

    public MatrixTreeNodeType(TreeNode parent, String expressionString) {
        super(parent, expressionString);
    }

    @Override
    public Object eval() {
        return m;
    }
}
