package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by mary on 15-12-16.
 */
public class DoubleTreeNodeType extends TreeNodeType
{
    private double aValue;

    public DoubleTreeNodeType(Double v)
    {
        aValue = v;
    }

    @Override
    public Object eval() {
        return aValue;
    }
}
