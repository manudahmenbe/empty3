package one.empty3.library.utils;

import one.empty3.library.Point3D;
import one.empty3.library.Polygons;
import one.empty3.library.StructureMatrix;

public class Mesh {
    public static Polygons createMesh(Point3D center, Point3D [] directions, int[] sizes) {
        Polygons polygons = new Polygons();
        StructureMatrix<Point3D> point3DStructureMatrix = new StructureMatrix<>(2, Point3D.class);
        for(int i=0; i<sizes[0]; i++) {
            for(int j=0; j<sizes[1]; j++) {
                point3DStructureMatrix.setElem(center.plus(directions[0].mult(i)
                        .plus(directions[1].mult(j))), i, j);
            }
        }
        return polygons;
    }
}
