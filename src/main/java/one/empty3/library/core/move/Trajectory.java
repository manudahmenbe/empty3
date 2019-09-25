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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package one.empty3.library.core.move;

import one.empty3.library.*;

import java.util.Collection;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public interface Trajectory {

    int POINTS_INTERMEDIATE_LINE = 0;
    int POINTS_INTERMEDIATE_BEZIER = 0;

    boolean hasMorePoints();

    Point3D getNextPointAndRemove();

    Point3D[] getIntermediatePointsUntilNext();

    void addPoints(Collection<Point3D> points);

    void addPoints(Point3D[] points);
}
