

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

package one.empty3.library.core.move;

import one.empty3.library.*;

public class Trajectoires {

    @Deprecated
    public static Point3D sphere(double longpc, double latpc, double radius) {
        return new Point3D(
                Math.cos(longpc * Math.PI) * Math.cos(Math.PI * (latpc)),
                Math.sin(longpc * Math.PI) * Math.cos(Math.PI * (latpc)),
                Math.sin(Math.PI * (latpc))
        ).mult(radius);

    }

   @Deprecated
    public static Point3D sphere(Point3D axe, double longpc, double latpc, double radius) {
        Point3D base = new Point3D(
                Math.cos(longpc * Math.PI) * Math.cos(Math.PI * (latpc)),
                Math.sin(longpc * Math.PI) * Math.cos(Math.PI * (latpc)),
                Math.sin(Math.PI * (latpc))
        ).mult(radius);
        Matrix33 matrix = new Matrix33(
           Point3D.X, axe.cross(Point3D.X), axe
           
        );

        return matrix.mult(base);
    }
}
 
