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

/***
 * Global license :
 * <p>
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package one.empty3.library.core.tribase;

import one.empty3.library.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class CheminCercle extends Chemin {
    private final double rayon;

    public CheminCercle(double r) {
        this.rayon = r;
    }

    @Override
    public double getLength() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public Point3D calculerPoint3D(double t) {
        return new Point3D(
                Math.cos(2 * Math.PI * t),
                Math.sin(2 * Math.PI * t),
                0d)
                .mult(rayon);

    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
