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

package one.empty3.library.core.animation;

import one.empty3.library.Representable;
import one.empty3.library.StructureMatrix;
import one.empty3.tests.Move;
import one.empty3.tests.MoveCollection;
import one.empty3.tests.Path;

import java.util.Collection;
import java.util.HashMap;

public class Animation extends Representable {
    private final HashMap<Class, MoveCollection> animations = new HashMap<>();

    public Animation(Class<? extends Representable> anime, MoveCollection moveCollection) {
        this.animations.put(anime.getClass(), moveCollection);
    }

    public Representable anime(Representable item, double t) {
        Collection<Move> moves = animations.get(item.getClass()).getMoves();
        if(moves!=null)
        for (Move move : moves) {
            if (move.getO() instanceof Representable) {
                Path path = ((Representable) move.getO()).getPath(move.getProperty());
                switch (path.getPathElemType()) {
                    case Representable.PATH_ELEM_STRUCTURE_MATRIX:
                        switch (((StructureMatrix) path.getRepresentable()).getDim()) {
                            case 0:
                                ((StructureMatrix<Object>) path.getRepresentable()).setElem(move.getMoved());

                                break;
                        }
                }
            }
        }
        else System.out.println("Animation anime error moves == null");
        return item;
    }
}
