/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

package one.empty3.library.core.nurbs;

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;

/*__
 * Created by manue on 23-11-19.
 */
public class ExtrusionCurveCurve extends ParametricSurface {
    private StructureMatrix<ParametricCurve> base = new StructureMatrix<>(0, ParametricCurve.class);
    private StructureMatrix<ParametricCurve> path = new StructureMatrix<>(0, ParametricCurve.class);


    public ExtrusionCurveCurve() {
        base.setElem(new CourbeParametriquePolynomialeBezier());
        path.setElem(new CourbeParametriquePolynomialeBezier());
    }


    public Point3D calculerPoint3D(double u, double v) {

        Point3D Op, T, NX, NY, pO;

        Op = path.getElem().calculerPoint3D(u);

        T = path.getElem().tangente(u);


        /*__
         * Plan normal pour le chemin
         *
         */
        Point3D normale = path.getElem().calculerNormale(u);
        /*if ((normale.norme() < 0.001 || normale.prodVect(T).norme() < 0.001)) {
            if (normaleFixe == null) {
                normaleFixe = T.prodVect(Point3D.r(1));
            }
            NX = normaleFixe.norme1();
        } else {
            NX = normale.norme1();
        }//*/
        T = T.norme1();
        NX = normale.norme1();
        NY = NX.prodVect(T).norme1();
/*
        System.err.println("\nT "+T );
        System.err.println("NX"+NX);
        System.err.println("NY"+NY);
 */
        pO = Op.plus(NX.mult(base.getElem().calculerPoint3D(v))).plus(NY.mult(base.getElem().calculerPoint3D(v)));
        return pO;

    }


    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("base/Surface à extruder", base);
        getDeclaredDataStructure().put("path/Chemin d'extrusion", path);
    }

    public StructureMatrix<ParametricCurve> getBase() {
        return base;
    }

    public void setBase(StructureMatrix<ParametricCurve> base) {
        this.base = base;
    }

    public StructureMatrix<ParametricCurve> getPath() {
        return path;
    }

    public void setPath(StructureMatrix<ParametricCurve> path) {
        this.path = path;
    }
}
