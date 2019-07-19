package one.empty3.pointset;
/***

 Empty3
 Copyright (C) 2010-2019  Manuel DAHMEN

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

import one.empty3.library.Point3D;

/**
 * Created by manue on 16-07-19.
 */
public class ComposanteForceAttraction {


    public Point3D fun(Gravity t1, Gravity t2, double G, double powerD, double powerM1, double powerM2)
    {
        Point3D plus = t2.dv1.plus(t1.moins(t2).mult(G * Math.pow(t1.m, powerM1) * Math.pow(t2.m, powerM2) / (
                Math.pow(t1.moins(t2).norme(), powerD))));
        return plus;
    }
}
