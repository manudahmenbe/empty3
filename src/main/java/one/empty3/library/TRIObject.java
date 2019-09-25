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

/*

 Vous êtes libre de :

 */
package one.empty3.library;

import java.util.ArrayList;
import java.util.Iterator;

public class TRIObject extends Representable {

    private StructureMatrix<TRI> triangles = new StructureMatrix<>(1, TRI.class);
    private Barycentre position;

    public TRIObject() {

    }

    /**
     * @param t
     */
    public TRIObject(TRI t) {
        triangles.add(1, t);
    }

    public boolean add(TRI arg0) {
        triangles.add(1, arg0);
        return true;
    }

    public void clear() {
        triangles.getData1d().clear();
    }

    public ArrayList<TRI> getTriangles() {
        return (ArrayList<TRI>) triangles.getData1d();
    }

    public Iterator<TRI> iterator() {
        return triangles.getData1d().iterator();
    }

    public Representable place(MODObjet aThis) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Barycentre position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Point3D rotation(Point3D p0, double a, double b) {
        Point3D p1 = new Point3D();
        p1.setX(p0.getX() * Math.cos(a) * Math.cos(b) + p0.getY() * Math.cos(a)
                * Math.sin(b) + p0.getZ() * Math.sin(a));
        p1.setY(p0.getX() * Math.cos(a) * Math.sin(b) + p0.getY() * Math.cos(a)
                * Math.cos(b) + p0.getZ() * Math.sin(a));
        p1.setZ(p0.getX() * Math.sin(a) * Math.cos(b) + p0.getY() * Math.sin(a)
                * Math.sin(b) + p0.getZ() * Math.cos((b)));

        if (position != null) {
            p1 = position.calculer(p1);
        }

        return p1;
    }


    public TextureCol texture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toLongString() {
        String s = "tris(\n";
        Iterator<TRI> tris = iterator();
        while (tris.hasNext()) {
            s += "\n\ttri" + tris.next().toString() + "\n";
        }
        return s + ")\n";
    }

    @Override
    public String toString() {
        String s = "tris(\n";
        Iterator<TRI> tris = iterator();
        while (tris.hasNext()) {
            s += "\n\t" + tris.next().toString() + "\n";
        }
        return s + ")\n";
    }

}
