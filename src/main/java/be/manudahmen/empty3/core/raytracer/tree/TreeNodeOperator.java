package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by mary on 15-12-16.
 */
public class TreeNodeOperator extends TreeNodeValue
{
    public TreeNodeOperator(TreeNode t, String subsubstring, String substring2, String exp) {
        super(t, subsubstring+"^"+substring2);
    }

    @Override
    public Object eval() {
        final Object v1 = getChildren().get(0);
        final Object v2 = getChildren().get(1);

        if(v1 instanceof Double && v2 instanceof Double)
        return (Double) Math.exp(Math.log((Double) v1)*(Double)v2);
        else
            return false;
    }
}
