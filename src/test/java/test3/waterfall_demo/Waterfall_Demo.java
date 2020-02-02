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

package test3.waterfall_demo;

import one.empty3.library.Point3D;
import one.empty3.library.StructureMatrix;
import one.empty3.library.core.nurbs.CourbeParametriquePolynomialeBezier;
import one.empty3.library.core.nurbs.ParametricCurve;
import one.empty3.library.core.testing.TestObjetSub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manue on 02-02-20.
 *
 *
 * Idées :
 * 1) Tetris : les courbes bougent but remplir l'écran
 * 2) Des gouttes tombent le long des courbes, remplir des bacs genre casse-brique
 * 
 */
public class Waterfall_Demo extends TestObjetSub {
    int nCurves = 20;
    int nodeMeanY = 5;
    private StructureMatrix<ParametricCurve> curves = new StructureMatrix<>(1, ParametricCurve.class);


    public void ginit() {
        int[] height = new int[10];
        for (int curveN = 0; curveN < nCurves; curveN++) {

            List<Point3D> pointsCurveN = new ArrayList<Point3D>();

            pointsCurveN.add(new Point3D(
                    (Math.random() - 0.5) * getDimension().x() * 2,
                    -0. + -getDimension().y(), 0.));

            int pointN = 1;

            boolean TRUE = true;


            Point3D pointNcandidate = pointsCurveN.get(0);
            while (TRUE) {


                pointNcandidate = pointsCurveN.get(pointN - 1).plus(new Point3D((Math.random() - 0.5) * getDimension().x() / nCurves,
                        Math.random() * getDimension().y() / nodeMeanY, 0.));

                while (!(pointNcandidate.getX() >= -this.getDimension().x() && pointNcandidate.getX() < this.getDimension().x()))
                    pointNcandidate = pointsCurveN.get(pointN - 1).plus(new Point3D((Math.random() - 0.5) * getDimension().x() / nCurves,
                            Math.random() * getDimension().y() / nodeMeanY, 0.));

                if (pointNcandidate.getY() >= -this.getDimension().y() & pointNcandidate.getY() < this.getDimension().y())
                    pointsCurveN.add(pointNcandidate);
                else
                    break;


                pointN++;
            }

            //pointsCurveN.add(new Point3D(0., (double) getDimension().y(), 0.));

            Point3D[] c = new Point3D[pointN];

            curves.setElem(new CourbeParametriquePolynomialeBezier(pointsCurveN.toArray(c)), curveN);
        }

        curves.data1d.forEach(parametricCurve -> scene().add(parametricCurve));

        System.out.println(curves.toString());

        scene().cameraActive().setEye(new Point3D(0., 0., -Math.max((double) getDimension().x(), (double) getDimension().y()) * 2));
    }

    public void finit() {
    }

    public void testScene() {

    }

    public static void main(String[] args) {
        Waterfall_Demo waterfall_demo = new Waterfall_Demo();
        waterfall_demo.setMaxFrames(1);
        new Thread(waterfall_demo).start();
    }
}
