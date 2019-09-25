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

package one.empty3.library.core.script;

/**
 * Created by manue on 30-05-19.
 */
public class InterpreteTRIEllipsoide implements Interprete{
    @Override
    public InterpreteConstants constant() {
        return null;
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        return null;
    }

    @Override
    public void setConstant(InterpreteConstants c) {

    }

    @Override
    public void setRepertoire(String r) {

    }
}
