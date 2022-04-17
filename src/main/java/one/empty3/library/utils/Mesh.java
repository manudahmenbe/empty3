package one.empty3.library.utils;

import one.empty3.library.Point3D;
import one.empty3.library.Polygons;
import one.empty3.library.StructureMatrix;
import one.empty3.library.core.nurbs.ParametricSurface;

public class Mesh {
    public static Polygons createMesh(Point3D center, Point3D [] directions, int su, int sv) {
        Polygons polygons = new Polygons();
        StructureMatrix<Point3D> point3DStructureMatrix = new StructureMatrix<>(2, Point3D.class);
        for(int i=0; i<su; i++) {
            for(int j=0; j<sv; j++) {
                point3DStructureMatrix.setElem(center.plus(directions[0].mult(i)
                        .plus(directions[1].mult(j))), i, j);
            }
        }
        return polygons;
    }
    public static Polygons createMeshOnSurface(Point3D center, ParametricSurface ps, int su, int sv) {
        Polygons polygons = new Polygons();
        StructureMatrix<Point3D> point3DStructureMatrix = new StructureMatrix<>(2, Point3D.class);
        for(int i=0; i<su; i++) {
            for(int j=0; j<sv; j++) {
                point3DStructureMatrix.setElem(ps.calculerPoint3D(1.0*i/su, 1.0*j/sv), i, j);
            }
        }
        return polygons;
    }
}
