package one.empty3.library;

import one.empty3.library.core.nurbs.SurfaceParametriquePolynomiale;

public class Polygons extends SurfaceParametriquePolynomiale {
    @Override
    public Point3D calculerPoint3D(double u, double v) {
        try {
            int u0 = (int) (u * coefficients.getData2d().get(0).size());
            int v0 = (int) (v * coefficients.getData2d().size());
            if(u0>=coefficients.getData2d().get(0).size())
                u0 = coefficients.getData2d().get(0).size()-1;
            if(v0>=coefficients.getData2d().size())
                v0 = coefficients.getData2d().size();
            int u1 = (int) ((u + getIncrU()) * coefficients.getData2d().get(0).size());
            int v1 = (int) ((v + getIncrV()) * coefficients.getData2d().size());
            if(u1>=coefficients.getData2d().get(0).size())
                u1 = coefficients.getData2d().get(0).size()-1;
            if(v1>=coefficients.getData2d().size())
                v1 = coefficients.getData2d().size()-1;
            Point3D[] points = new Point3D[]{
                    coefficients.getElem(u0, v0), coefficients.getElem(u1, v0),
                    coefficients.getElem(u1, v1), coefficients.getElem(u0, v1)
            };
            double U = Math.IEEEremainder(u, coefficients.getData2d().get(0).size());
            double V = Math.IEEEremainder(v, coefficients.getData2d().size());
            Point3D pUv0 = points[0].plus(points[1].moins(points[0]).mult(U));
            Point3D pUv1 = points[3].plus(points[2].moins(points[3]).mult(U));
            Point3D pU0v = points[0].plus(points[3].moins(points[0]).mult(V));
            Point3D pU1v = points[2].plus(points[3].moins(points[2]).mult(V));

            return points[0].plus(pUv1.plus(pUv0).mult(V)); // Discutable
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
