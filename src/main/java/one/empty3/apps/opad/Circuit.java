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
Global license : 

 Microsoft Public Licence

 author Manuel Dahmen _manuel.dahmen@gmx.com_

 Creation time 05-nov.-2014

 ***/


package one.empty3.apps.opad;


import one.empty3.library.ColorTexture;
import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.Sphere;
import one.empty3.library.core.tribase.TubulaireN;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/*__
 *
 * @author Manuel Dahmen _manuel.dahmen@gmx.com_
 */
public class Circuit extends TubulaireN
{

    public Circuit(ArrayList<Point3D> listPoint3d) {
        listPoint3d.forEach(this::addPoint);
        this.texture(new ColorTexture(Color.ORANGE));
    }

    public Circuit(Bonus bonus) {
        Iterator<Representable> iterator = bonus.getListRepresentable().iterator();
        while(iterator.hasNext()) {
            Representable next = iterator.next();
            if(next != null && next instanceof TRISphere2) {
                addPoint(((Sphere)next).getCircle().getCenter());
            }

            this.texture(new ColorTexture(Color.ORANGE));
        }


    }

    public TubulaireN baseCircuitRepresentable() {
        return this;
    }


}
