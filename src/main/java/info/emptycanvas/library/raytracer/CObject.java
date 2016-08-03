package info.emptycanvas.library.raytracer;

/**
 * Created by manuel on 03-08-16.
 */
public abstract class CObject extends CNode {

    protected CNode mNode;
    protected Matiere mMaterial;

    public CObject() {
        mNode = getNodeInstance();
    }

    // get
    public Matiere getMaterial() {
        return mMaterial;
    }

    public void setMaterial(Matiere material) {
        mMaterial = material;
    }

    public CNode getNode() {
        return mNode;
    }

    // set
    public void setNode(CNode node) {
        mNode = node;
    }

}
