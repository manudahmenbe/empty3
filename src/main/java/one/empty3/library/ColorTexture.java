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

import java.awt.*;

/**
 * @author Manuel Dahmen
 */
public class ColorTexture extends ITexture {

    private Color color;

    public ColorTexture() {
        color = Color.BLACK;
    }

    public ColorTexture(Color c) {
        this();
        if (c != null) {
            color = c;
        }
    }

    public Color color() {
        return color;
    }

    public void color(Color c) {
        color = c;
    }

    @Override
    public void iterate() throws EOFVideoException {

    }

    public int getColorAt(double x, double y) {
        return color.getRGB();
    }

    public void timeNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void timeNext(long milli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Quadrilatère numQuadX = 1, numQuadY = 1, coordArr, y 3----2 ^2y |\ | | 4 |
     * 0--\-1 1 -> 2x
     *
     * @param numQuadX nombre de maillage en coordArr
     * @param numQuadY nombre de maillage en y
     * @param x        valeur de coordArr
     * @param y        valeur de y
     * @return
     */
    public Color getMaillageTexturedColor(int numQuadX, int numQuadY, double x,
                                          double y) {
        return color;
    }
}
