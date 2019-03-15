package be.manudahmen.empty3;


import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by manue on 07-03-19.
 */
public class Render {
    public static final int TYPE_POINT = 0;
    public static final int TYPE_CURVE = 1;
    public static final int TYPE_SURFACE = 2;
    public static final int POINTS = 4;
    public static final int LINES = 8;
    public static final int FILL = 16;
    protected int objectType = -1;
    protected int renderingType = -1;

    public Render(int objectType, int renderingType) {
        this.objectType = objectType;
        this.renderingType = renderingType;
    }


    public static Render getInstance(int objectType, int renderingType) {
        return new Render (objectType, renderingType);
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public int getRenderingType() {
        return renderingType;
    }

    public void setRenderingType(int renderingType) {
        this.renderingType = renderingType;
    }
}
