package one.empty3.library.utils;

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;

public class Mesh {
    public static StructureMatrix<Point3D> createMesh(Point3D center, Point3D directions, int[] sizes) {
        StructureMatrix<Point3D> matrix = new StructureMatrix<>(sizes.length, Point3D.class);
    }
}
