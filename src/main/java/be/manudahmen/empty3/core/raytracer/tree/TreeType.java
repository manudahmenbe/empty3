package be.manudahmen.empty3.core.raytracer.tree;

import java.util.HashMap;

/**
 * Created by mary on 15-12-16.
 */
public class TreeType {
    public final HashMap<String, Class>
    types = new HashMap<String, Class>();

    public TreeType()
    {
        types.put("reel", DoubleTreeType.class);
        types.put("vector", VectorTreeType.class);
        types.put("matrix", MatrixTreeType.class);


    }
}
