package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.Representable;

public class CIntersectInfo {

    public Point3D mIntersection;    // Position de l'intersection
    public Point3D mNormal;        // Normale au point d'intersection
    public CNode mNode;            // Node touch�e par l'intersection
    public Representable mRepres;
    public Matiere mMaterial;        // Material au point d'intersection

    public CIntersectInfo() {
        super();
        mIntersection = new Point3D();    // Position de l'intersection
        mNormal = new Point3D();// Normale au point d'intersection
        mNode = new CDefaultCNode();            // Node touch�e par l'intersection
        mRepres = null;
        mMaterial = new Matiere();        // Material au point d'intersection
    }
}