package be.manudahmen.empty3.core.raytracer.tree;

import be.manudahmen.empty3.Point3D;

import java.util.Vector;

/**
 * Created by mary on 15-12-16.
 */
public class VectorTreeNode extends TreeNodeValue {
    private Point3D p;
    @Override
    public Object eval() {
        return p;
    }
}
