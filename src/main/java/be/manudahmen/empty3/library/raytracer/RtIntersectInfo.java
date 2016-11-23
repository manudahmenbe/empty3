package be.manudahmen.empty3.library.raytracer;

import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.object.Representable;

public class RtIntersectInfo {

    public Point3D mIntersection;    // Position de l'intersection
    public Point3D mNormal;        // Normale au point d'intersection
    public RtNode mNode;            // Node touch�e par l'intersection
    public Representable mRepres;
    public RtMatiere mMaterial;        // Material au point d'intersection

    public RtIntersectInfo() {
        super();
        mIntersection = new Point3D();    // Position de l'intersection
        mNormal = new Point3D();// Normale au point d'intersection
        mNode = new RtDefaultRtNode();            // Node touch�e par l'intersection
        mRepres = null;
        mMaterial = new RtMatiere();        // Material au point d'intersection
    }
}