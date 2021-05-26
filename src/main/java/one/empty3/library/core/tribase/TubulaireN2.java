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

import one.empty3.library.ColorTexture;
import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;
import one.empty3.library.core.gdximports.gdx_BSplineCurve;
import one.empty3.library.core.nurbs.*;
import org.apache.xmlbeans.impl.tool.Extension;

import java.awt.*;
import java.util.Iterator;
import java.util.Objects;

public class TubulaireN2 extends ParametricSurface {
    public double TAN_FCT_INCR = 0.00000001;
    public double NORM_FCT_INCR = 0.00001;

    protected StructureMatrix<ParametricCurve> soulCurve = new StructureMatrix<>(0, ParametricCurve.class);
    protected StructureMatrix<FctXY> diameterFunction = new StructureMatrix<>(0, FctXY.class);
    private Point3D lastTan = null;
    private Point3D lastNorm = null;
    private Double MIN_NORMGT0 = 0.00000000001;

    public TubulaireN2() {
        super();
        soulCurve.setElem(new CourbeParametriquePolynomialeBezier());
        diameterFunction.setElem(new FctXY());
        declareProperties();
    }

    public TubulaireN2(ParametricCurve curve, double diameter) {
        soulCurve.setElem(curve);
        soulCurve.getElem().texture(new ColorTexture(Color.BLACK));
        FctXY fctXY = new FctXY();
        fctXY.setFormulaX("" + diameter);
        diameterFunction.setElem(fctXY);
        declareProperties();
    }
/*
    public Point3D calculerNormale(double t) {
        Point3D n = calculerTangente(t + NORM_FCT_INCR).moins(calculerTangente(t)).mult(1.0 / NORM_FCT_INCR);
        if(n.equals(Point3D.O0)) {
            int i=0;
            while (i < 3 && (n.equals(Point3D.O0) ||
                    n.isAnyNaN())) {
                n = calculerTangente(t).prodVect(
                        new Point3D(i==0?1.0:0.0,i==1?1.0:0.0,i==2?1.0:0.0));

                i++;
            }

        }
        return n;
    }
    */
    public Point3D calculerNormale(double t, Point3D tangent) {
    Point3D n = tangent.prodVect(Point3D.X);

    if(n.equals(Point3D.O0)) {
        int i = 0;

        while (i < 3 && (n.norme()!=1.0 ||
                n.isAnyNaN())) {
            n = tangent
                    .prodVect(
                            new Point3D(
                                    i==0?1.0:0.0,
                                    i==1?1.0:0.0,i==2?1.0:0.0));

            i++;
        }

    }
        return n;
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

    public Point3D[] vectPerp(double t, double v) {
        Point3D[][] vecteurs = new Point3D[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                vecteurs[i][j] = new Point3D(0., 0., 0.);
                for (int k = 0; k < 3; k++)
                    vecteurs[i][j].set(j, k == i ? 1. : 0.);
            }

        Point3D tangente = Point3D.O0;
        int k = 0;
        while (tangente.equals(Point3D.O0) && k < 3) {
            tangente = calculerTangente(t);
            if (tangente.equals(Point3D.O0) || tangente.isAnyNaN()) {
                //TODO
                tangente =
                        Objects.requireNonNullElse(lastTan,
                                new Point3D(k == 0 ? 1. : 0,
                                        k == 1 ? 1. : 0, k == 2 ? 1. : 0));
            } else {
                lastTan = tangente;
                break;
            }
            k++;
        }
        if(tangente.norme()==0.0)
            System.out.println("Error in TubulaireN2 tangente==0");

        tangente = tangente.norme1();

        Point3D[] refs = new Point3D[3];

        refs[0] = new Point3D(1d, 0d, 0d);
        refs[1] = new Point3D(0d, 1d, 0d);
        refs[2] = new Point3D(0d, 0d, 1d);

        tangente = tangente.norme1();

        Point3D px = null;
        Point3D py = null;
        int j = 0;
        double min = 1d;
        double minI = 1000d; // TODO
        for (int i = 0; i < 3; i++) {
            Point3D normal = calculerNormale(t, tangente);
            if (normal.equals(Point3D.O0) || normal.isAnyNaN()) {
                normal = refs[i].prodVect(tangente);//TODO .prodVect(refs[i])).norme1();
            }
            lastNorm = normal;

            normal = normal.norme1();
            px = normal;//TODO .prodVect(refs[i])).norme1();
            py = tangente.prodVect(px).norme1();


            vecteurs[i][1] = px;
            vecteurs[i][2] = py;
            vecteurs[i][0] = tangente.norme1();

            minI = Math.abs(px.prodVect(py).norme() - 1.);

            if (minI <= min) {
                min = minI;
                j = i;
            }

        }

        if(px.prodVect(py).norme()==0.0)
            System.out.println("Error in tubulaireN2");


        return vecteurs[j];
    }

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D[] vectPerp = vectPerp(u, v);
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
        getDeclaredDataStructure().put("soulCurve/Ame de la courbe", soulCurve);
        getDeclaredDataStructure().put("diameterFunction/Fonction de positon sur la courbe - diamètre (var='x')", diameterFunction);

    }

    public StructureMatrix<ParametricCurve> getSoulCurve() {
        return soulCurve;
    }


    public StructureMatrix<FctXY> getDiameterFunction() {
        return diameterFunction;
    }


    public void setSoulCurve(ParametricCurve b) {
        this.soulCurve.setElem(b);
    }

    public void setDiameter(double d) {
        FctXY fctXY = new FctXY();
        fctXY.setFormulaX("" + d);
        this.diameterFunction.setElem(fctXY);
    }
}
