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

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

/*__
 * *
 * Global license : * GNU GPL v3
 * <p>
 * author Manuel Dahmen _manuel.dahmen@gmx.com_
 * <p>
 * Creation time 2015-03-25
 * <p>
 * *
 */
package one.empty3.library.core.tribase;

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;
import one.empty3.library.core.gdximports.gdx_BSplineCurve;
import one.empty3.library.core.nurbs.*;
import org.apache.xmlbeans.impl.tool.Extension;

import java.util.Iterator;

public class TubulaireN2 extends ParametricSurface {
    public double TAN_FCT_INCR = 0.000001;
    public double NORM_FCT_INCR = 0.000001;

    //private StructureMatrix<CourbeParametriquePolynomialeBezier> soulCurve = new StructureMatrix<>(0, CourbeParametriquePolynomialeBezier.class);
    private StructureMatrix<ParametricCurve> soulCurve = new StructureMatrix<>(0, ParametricCurve.class);
    private StructureMatrix<FctXY> diameterFunction = new StructureMatrix<>(0, FctXY.class);
    private Point3D lastTan = null;
    private Point3D lastNorm = null;

    public TubulaireN2() {
        super();
        soulCurve.setElem(new CourbeParametriquePolynomialeBezier());
        diameterFunction.setElem(new FctXY());
        declareProperties();
    }

    public TubulaireN2(ParametricCurve curve, double diameter) {
        this();
        soulCurve.setElem(curve);
        FctXY fctXY = new FctXY();
        fctXY.setFormulaX("1.0");
        diameterFunction.setElem(fctXY);
        declareProperties();
    }

    public Point3D calculerNormale(double t) {
        return calculerTangente(t + NORM_FCT_INCR).moins(calculerTangente(t)).mult(1.0 / NORM_FCT_INCR);
    }

    public Point3D calculerTangente(double t) {
        return soulCurve.getElem().calculerPoint3D(t + TAN_FCT_INCR).moins(
                soulCurve.getElem().calculerPoint3D(t)).mult(1.0 / TAN_FCT_INCR);
    }

    public void nbrAnneaux(int n) {
        setIncrU(1.0 / n);
    }

    public void nbrRotations(int r) {
        setIncrV(1.0 / r);
    }

    @Override
    public String toString() {
        String s = "tubulaire3 (\n\t("
                + soulCurve.getElem().toString();
        s += "\n\n)\n\t" + diameterFunction.toString() + "\n\t" + texture().toString() + "\n)\n";
        return s;
    }

    /*old
    private Point3D[] vectPerp(double t) {
        Point3D[][] vecteurs = new Point3D[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                vecteurs[i][j] = Point3D.O0;

        Point3D tangente = calculerTangente(t);


        Point3D[] refs = new Point3D[3];

        refs[0] = new Point3D(0d, 0d, 1d);
        refs[1] = new Point3D(1d, 0d, 0d);
        refs[2] = new Point3D(0d, 1d, 0d);

        tangente = tangente.norme1();
        Point3D normale = calculerNormale(t).norme1();

        double[] maxs = new double[3];


        int j = 0;
        double min = 3;
        for (int i = 0; i < 3; i++) {
            Point3D px = tangente.prodVect(normale.prodVect(refs[i])).norme1();

            Point3D py = px.prodVect(tangente).norme1();


            vecteurs[i][0] = tangente;
            vecteurs[i][1] = px;
            vecteurs[i][2] = py;

            double minI = Math.abs(tangente.plus(px).plus(py).norme() - Math.sqrt(3));
            if (minI < min) {
                min = minI;
                j = i;
            }
        }

        return vecteurs[j];
    }
*/
    private Point3D[] vectPerp(double t) {
        Point3D[][] vecteurs = new Point3D[3][3];

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                vecteurs[i][j] = new Point3D(0., 0., 0.);
                for (int k = 0; k < 3; k++)
                    vecteurs[i][j].set(j, k == i ? 1. : 0.);
            }

        Point3D tangente = calculerTangente(t);
        if(tangente.equals(Point3D.O0)||tangente.isAnyNaN()) {
            if(lastTan!=null) {
                tangente = lastTan;
            } else
                tangente = Point3D.X;//TODO
        } else {
            lastTan = tangente;
        }


        Point3D[] refs = new Point3D[3];

        refs[0] = new Point3D(0d, 0d, 1d);
        refs[1] = new Point3D(1d, 0d, 0d);
        refs[2] = new Point3D(0d, 1d, 0d);

        tangente = tangente.norme1();
        Point3D normal = calculerNormale(t);
        if(normal.equals(Point3D.O0)||normal.isAnyNaN()) {
            if(lastNorm!=null) {
                normal = lastNorm;
            } else
                normal = tangente.prodVect(soulCurve.getElem().calculerPoint3D(0.5));
        }  else {
            lastNorm = tangente;
        }

        normal = normal.norme1();

        double[] maxs = new double[3];


        int j = 0;
        double min = 3;
        double minI = Math.sqrt(3); // TODO
        for (int i = 0; i < 3; i++) {
            Point3D px = tangente.prodVect(normal.prodVect(refs[i])).norme1();

            Point3D py = px.prodVect(tangente).norme1();


            vecteurs[i][0] = px;
            vecteurs[i][1] = py;
            vecteurs[i][2] = tangente;

            if (minI < min) {
                min = minI;
                j = i;
            }
        }
        if(min<minI)
            System.out.println("Error vectPerp : TubulaireN2");
        return vecteurs[j];
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D[] vectPerp = vectPerp(u);
        return soulCurve.getElem().calculerPoint3D(u).plus(
                vectPerp[1].mult(diameterFunction.getElem().result(u) * Math.cos(2 * Math.PI * v))).plus(
                vectPerp[2].mult(diameterFunction.getElem().result(u) * Math.sin(2 * Math.PI * v)));
    }
/*old
    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D[] vectPerp = vectPerp(u);
        return soulCurve.getElem().calculerPoint3D(u).plus(
                vectPerp[1].mult(diameterFunction.getElem().result(u) * Math.cos(2 * Math.PI * v))).plus(
                vectPerp[2].mult(diameterFunction.getElem().result(u) * Math.sin(2 * Math.PI * v)));
    }
*/
    @Override
    public void declareProperties() {
        super.declareProperties();
        soulCurve.getElem().declareProperties();
        diameterFunction.getElem().declareProperties();
        getDeclaredDataStructure().put("soulCurve/ame de la courbe", soulCurve);
        getDeclaredDataStructure().put("diameterFunction/ fonction de la longueur du diamètre", diameterFunction);

    }

    public StructureMatrix<ParametricCurve> getSoulCurve() {
        return soulCurve;
    }


    public StructureMatrix<FctXY> getDiameterFunction() {
        return diameterFunction;
    }


    public void setSoulCurve(gdx_BSplineCurve b) {
        this.soulCurve.setElem(b);
    }

    public void setDiameter(double d) {
        FctXY fctXY = new FctXY();
        fctXY.setFormulaX(""+d);
        this.diameterFunction.setElem(fctXY);
    }
}
