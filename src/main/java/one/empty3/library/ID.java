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
package one.empty3.library;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         21 oct. 2011
 */
public class ID {

    private String name;

    public ID(String id) {
        this.name = id;
    }

    public static String GEN(Object o) {
        String id = "";
        if (o instanceof Representable) {
            id = "19780626-091-33-05h--" + o.getClass().getName() + "--"
                    + System.currentTimeMillis();
        }
        return id;
    }

    public String getName() {
        return name;
    }
}
