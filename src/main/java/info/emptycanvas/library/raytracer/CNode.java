package info.emptycanvas.library.raytracer;

public abstract class CNode {
    public static final int LIGHT = 0x0001000;
    public static final int OMNILIGHT = 0x0001002;
    public static final int CAMERA = 0x0010000;
    public static final int TARGETCAMERA = 0x0010002;

    protected int mNodeType;
    protected String mName;

    // constructeurs et destructeur
    public CNode() {
        mName = null;
    }

    public CNode(int nodeType, String name) {
        mNodeType = nodeType;
        mName = name;
    }

    // raytrace related
    public abstract boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo);

    // get
    public final int getNodeType() {
        return mNodeType;
    }

    // set
    public void setNodeType(int nodeType) {
        mNodeType = nodeType;
    }

    public final String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public final CNode getNodeInstance() {
        return this;
    }
}