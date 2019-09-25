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

package one.empty3.library;

/**
 * Created by Win on 26-01-16.
 */
public class Rotation {
    protected Matrix33 rot;
    protected Point3D centreRot;
    protected boolean unmodified = true;
    public Rotation() {
        if (isUnmodified())
        {
            rot  = new Matrix33(Matrix33.I);
            centreRot = new Point3D(Point3D.O0);
        }
    }
    public Rotation(Matrix33 rot, Point3D centreRot) {
        this.rot = rot;
        this.centreRot = centreRot;
    }

    public boolean isUnmodified() {
        return unmodified;
    }

    public void setUnmodified(boolean unmodified) {
        this.unmodified = unmodified;
    }

    public Point3D rotation(Point3D p ) {
        if(rot==null)
            rot = new Matrix33(Matrix33.I);
        if(centreRot==null)
            centreRot = p;
        if(p!=null) {
            return p.plus(centreRot).plus(rot.mult(p.scale()));
        }
        else return p;
    }

    public Point3D rotationAxe(Point3D p, int axe, double angle) {

        return Matrix33.rotationX(angle).mult(p);
    }

    public Point3D getCentreRot() {
        return centreRot;
    }

    public void setCentreRot(Point3D centreRot) {
        this.centreRot = centreRot;
    }

    public Matrix33 getRot() {
        return rot;
    }

    public void setRot(Matrix33 rot) {
        this.rot = rot;
    }
}
