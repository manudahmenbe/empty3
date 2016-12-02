package be.manudahmen.emptycanvas.library.empty3.library.raytracer;

import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

/**
 * Created by manuel on 02-12-16.
 */
public class RtParameterCamera extends RtTargetCamera {
    public static final int ORIENTATION_HORIZONTALE = 1;
    public static final int ORIENTATION_VERTICALE = 2;
    private double angleH, angleV;
    private int orientation;

    public RtParameterCamera(Point3D camPos, Point3D lookAtPoint, Point3D upVector) {
        super(camPos, lookAtPoint, upVector);
    }

    public double getAngleH() {
        return angleH;
    }

    public void setAngleH(double angleH) {
        this.angleH = angleH;
    }

    public double getAngleV() {
        return angleV;
    }

    public void setAngleV(double angleV) {
        this.angleV = angleV;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
