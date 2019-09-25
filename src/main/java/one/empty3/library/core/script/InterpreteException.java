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

 Vous êtes libre de :

 */
package one.empty3.library.core.script;

@SuppressWarnings("serial")
public class InterpreteException extends Exception {

    private String repertoire;

    public InterpreteException(Exception ex) {
        super(ex);
    }

    public InterpreteException(String string) {
        super(string);
    }

    /**
     * @param string
     * @param e
     */
    public InterpreteException(String string, Exception e) {
        super(string, e);
    }
}
