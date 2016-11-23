package be.manudahmen.empty3.library.raytracer;

import be.manudahmen.empty3.library.object.Point3D;

/**
 * Created by manuel on 03-08-16.
 */
public abstract class RtLight extends RtNode {
    protected float mDiffuseColor;
    protected float mSpecularColor;
    protected Point3D mPosition = new Point3D();
    protected RtColor mColor;
    protected int mLightType;


    public RtLight(Point3D position, float diffuseColor, float specularColor, RtColor CColor, int type) {
        super(LIGHT, "LIGHT");
        assert (position != null);
        mPosition = position;
        mDiffuseColor = diffuseColor;
        mSpecularColor = specularColor;
        mColor = CColor;
        mLightType = type;
    }

    public RtLight(int light, String light1) {
        mLightType = light;
        mNodeType = LIGHT;
    }

    /*public RtLight(int light, String light1) {
        super(light, light1);
    }*/

    // get
    public Point3D getPosition() {
        return mPosition;
    }

    public RtColor getColor() {
        return mColor;
    }

    public int getType() {
        return mLightType;
    }

    // La méthode virtuel pure d'éclairage.
    public abstract RtColor getLightAt(Point3D normal, Point3D intersectionPoint, RtMatiere material);
}
