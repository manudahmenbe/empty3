/*
 *     3D game
 *     Copyright (C) 2010-2017  Manuel DAHMEN
 *
 *     This program is free software: you can redistribute it and/or modify
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
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package one.empty3.apps.pad;

import one.empty3.library.Point2D;
import one.empty3.library.Representable;

/**
 * Created by manuel on 07-05-17.
 */
public abstract class Boss {
    protected Point2D position;
    protected float energy;
    protected Representable anima;

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public Representable getAnima() {
        return anima;
    }

    public void setAnima(Representable anima) {
        this.anima = anima;
    }

    protected abstract boolean contact();
}
