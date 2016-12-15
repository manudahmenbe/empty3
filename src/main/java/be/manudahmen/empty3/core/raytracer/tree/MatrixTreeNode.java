package be.manudahmen.empty3.core.raytracer.tree;

import be.manudahmen.empty3.Matrix33;

/**
 * Created by mary on 15-12-16.
 */
public class MatrixTreeNode extends TreeNodeValue
{
    private Matrix33 m;
    @Override
    public Object eval() {
        return m;
    }
}
