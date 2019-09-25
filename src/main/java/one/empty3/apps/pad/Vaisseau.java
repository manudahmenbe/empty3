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
 * Global license :  *
 * CC Attribution
 *
 * author Manuel Dahmen <manuel.dahmen@gmx.com>
 *
 **
 */
package one.empty3.apps.pad;

import one.empty3.library.ColorTexture;
import one.empty3.library.Cube;

import java.awt.*;
import java.util.ResourceBundle;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmx.com>
 */
class Vaisseau {
    private final ResourceBundle bundle;
    private final double mlc;

    {
        bundle = ResourceBundle.getBundle("one.empty3.apps.pad.Bundle"); // NOI18N
        mlc = Double.parseDouble(bundle.getString("persoCube.mlc"));
    }
    private final PositionUpdate gm;

    public Vaisseau(PositionUpdate gm) {
        this.gm = gm;
    }

    public Cube getObject() {
        return new Cube(mlc, gm.getPositionMobile().calcPosition(), new ColorTexture(Color.GREEN));
    }
}
