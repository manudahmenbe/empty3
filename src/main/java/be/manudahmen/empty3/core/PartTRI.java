package be.manudahmen.empty3.core;

import be.manudahmen.empty3.ITexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;

/**
 * Created by manue on 01-03-19.
 */
public class PartTRI extends TRI {
    public PartTRI(Point3D point3D, Point3D point3D1, Point3D point3D2, ITexture texture,
        double u, double v
                   ) {
        super(point3D, point3D1, point3D2, texture);
    }
}
