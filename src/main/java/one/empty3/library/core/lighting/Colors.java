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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.empty3.library.core.lighting;

import java.awt.*;

/*__
 * @author Manuel Dahmen _manuel.dahmen@gmx.com_
 */
public class Colors {
    public static Color TRANSPARENT = new Color(1f,0f,0f,.5f );
    public static Color random() {
        return new Color(
                (float) Math.random(),
                (float) Math.random(),
                (float) Math.random()
        );
    }
    
    
    public abstract class FArrayElem {
        public abstract double op(double d);
    }
    /***
     * moyenne ponderee
      */
    public static Color mean(Color[] c, double[] d, double norm) {
      float [] r = new float[4];
        float [] f = new float[4];
        float sum = 0f;
        for(int i = 0; i<c.length; i++)
{
            sum += d[i];
        c[i].getRGBComponents(f);
            for (int j=0; j <4; j++) 
                r[j] += (float)(f[j]/d[i]*norm);
        }
        for(int i = 0 ; i<c.length; i++) {
            r[i] /= sum;
            if (r[i].isNan())
                r[i] = 0f;
            }
            return new Color(r[0], r[1], r[2], r[3]);
    }
}
