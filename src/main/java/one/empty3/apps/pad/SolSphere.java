/*
 *     3D game
 *     Copyright (C) 2010-2017  Manuel DAHMEN
 *
 *     This program is free software: you can redistribute it and/or modify
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
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * *
 * Global license :  *
 * CC Attribution
 *
 * author Manuel Dahmen <manuel.dahmen@gmx.com>
 *
 **
 */
package one.empty3.apps.pad;

import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.RepresentableConteneur;
import one.empty3.library.core.nurbs.ParametricSurface;

import java.util.Iterator;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmx.com>
 */
public class SolSphere extends Terrain {

    private double radius = 1.0;

    private Point3D coord(double u, double v) {
        double a = u * 2 * Math.PI ;//- Math.PI;
        double b = v * Math.PI;
        Point3D p = new Point3D(Math.sin(a) * Math.sin(b)
                * radius, Math.sin(a) * Math.cos(b) * radius,
                Math.cos(a) * radius);
        return p;

    }

    public SolSphere(/*Game game*/) {
        setDessineMurs(false);
        //super(game);
        ps = new ParametricSurface() {
            @Override
            public Point3D calculerPoint3D(double u, double v) {
                return coord(u, v);

            }

            @Override
            public Point3D calculerVitesse3D(double u, double v) {
                Point3D pU = calculerPoint3D(u + 0.001, v).moins(calculerPoint3D(u, v));
                Point3D pV = calculerPoint3D(u, v + 0.001).moins(calculerPoint3D(u, v));
                return pV.plus(pU).norme1();
            }
        };
        SolPP sol = new SolPP(ps);
        RepresentableConteneur generateWire = sol.generateWire();

        Iterator<Representable> it = generateWire.iterator();

        while (it.hasNext()) {
            add(it.next());
        }
    }

}
