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

package one.empty3.library;

/**
 * Created by manuel on 21-10-16.
 */
public class Intersects {
    public Ray ray;
    public Intersection intersection;

    public class Ray {
        public Point3D start;
        public Point3D direction;

    }

    public class Intersection {
        public Representable intersection;
        public Point3D interPoint;
    }
}
