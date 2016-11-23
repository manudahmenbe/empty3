package info.emptycanvas.library.raytracer;

/**
 * Created by manuel on 03-08-16.
 */
public abstract class RtObject extends RtNode {

    protected RtNode mNode;
    protected RtMatiere mMaterial;

    public RtObject() {
        mNode = getNodeInstance();
    }

    // get
    public RtMatiere getMaterial() {
        return mMaterial;
    }

    public void setMaterial(RtMatiere material) {
        mMaterial = material;
    }

    public RtNode getNode() {
        return mNode;
    }

    // set
    public void setNode(RtNode node) {
        mNode = node;
    }

}
