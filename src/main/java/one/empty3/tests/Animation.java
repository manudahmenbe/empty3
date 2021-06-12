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

package one.empty3.tests;

import one.empty3.library.Representable;
import one.empty3.tests.Human;
import one.empty3.tests.Move;
import one.empty3.tests.MoveCollection;

import java.util.HashMap;

public class Animation extends Representable {
    private final HashMap<Class, MoveCollection> animations = new HashMap<>();

    public Animation(Class<? extends Representable> anime, MoveCollection moveCollection) {
        this.animations.put(anime.getClass(), moveCollection);
    }

    public Representable anime(Representable item, double t) {
        for (Move move : animations.get(item.getClass()).getMoves()) {
            Object path = item.getPath(move.getProperty());

        }
        return item;
    }
}