package one.empty3.library.core.raytracer.tree;

/**
 * Created by manue on 21-08-19.
 */
public class PowerTreeNodeType extends TreeNodeType {
    private double sign1 = 1; // 1=*

    public PowerTreeNodeType(double sign1) {
        super(sign1);
    }


    public Double eval() {
        return null;
    }


    public String toString() {
        return super.toString() + "\nSign:" + sign1;
    }
}
