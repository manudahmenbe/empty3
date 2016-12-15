package be.manudahmen.empty3.core.raytracer.tree;

/**
 * Created by mary on 15-12-16.
 */
public class TreeNode<E> {
    private E type;
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
