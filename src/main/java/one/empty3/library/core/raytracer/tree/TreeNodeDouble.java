package one.empty3.library.core.raytracer.tree;

/**
 * Created by manue on 01-07-19.
 */
public class TreeNodeDouble extends TreeNode {
    public TreeNodeDouble(TreeNode src, Object[] objects, DoubleTreeNodeType doubleTreeNodeType) {
        super(src, objects, doubleTreeNodeType);
    }

    @Override
    public Double eval() {
        return (Double) objects[1];
    }
}
