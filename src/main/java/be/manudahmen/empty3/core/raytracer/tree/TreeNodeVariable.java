package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class TreeNodeVariable extends TreeNodeValue {
    public TreeNodeVariable(TreeNode src, String subformula) {
        super(src, subformula);
    }

    @Override
    public Object eval() {
        return null;
    }
}
