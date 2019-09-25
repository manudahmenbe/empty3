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
 * Created by manue on 28-05-19.
 */
public abstract class TextureOp2D extends ITexture {
    protected ITexture upText;

    @Override
    public void iterate() throws EOFVideoException {

    }


    @Override
    public void timeNext() {

    }

    @Override
    public void timeNext(long milli) {

    }

    public abstract int getColorAt(double u, double v);

    public void setUpText(ITexture upText) {
        this.upText = upText;
    }
}
