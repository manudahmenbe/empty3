package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

/**
 * Created by manuel on 03-08-16.
 */
public abstract class CLight extends CNode {
    protected float mDiffuseColor;
    protected float mSpecularColor;
    protected Point3D mPosition = new Point3D();
    protected CColor mColor;
    protected int mLightType;


    // constructeurs et destructeur
    public CLight() {
    }

    public CLight(Point3D position, float diffuseColor, float specularColor, CColor color, int type) {
        super(LIGHT, "LIGHT");
        assert (position != null);
        mPosition = position;
        mDiffuseColor = diffuseColor;
        mSpecularColor = specularColor;
        mColor = color;
        mLightType = type;
    }

    public CLight(int light, String light1) {
        super(light, light1);
    }

    // get
    public Point3D getPosition() {
        return mPosition;
    }

    public CColor getColor() {
        return mColor;
    }

    public int getType() {
        return mLightType;
    }

    // La méthode virtuel pure d'éclairage.
    public abstract CColor getLightAt(Point3D normal, Point3D intersectionPoint, Matiere material);
}
