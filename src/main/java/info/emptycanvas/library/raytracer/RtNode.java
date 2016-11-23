package info.emptycanvas.library.raytracer;

public abstract class RtNode {
    public static final int LIGHT = 0x0001000;
    public static final int OMNILIGHT = 0x0001002;
    public static final int CAMERA = 0x0010004;
    public static final int TARGETCAMERA = 0x0010008;

    protected int mNodeType;
    protected String mName;

    // constructeurs et destructeur
    public RtNode() {
        mName = null;
    }

    public RtNode(int nodeType, String name) {
        mNodeType = nodeType;
        mName = name;
    }

    // raytrace related
    public abstract boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo);

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

    public final RtNode getNodeInstance() {
        return this;
    }
}