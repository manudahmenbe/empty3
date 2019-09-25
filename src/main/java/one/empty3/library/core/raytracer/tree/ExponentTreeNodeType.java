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

package one.empty3.library.core.raytracer.tree;

/**
 * Created by manuel on 16-12-16.
 */
public class ExponentTreeNodeType extends TreeNodeType {
    private double sign1, sign2;

    public ExponentTreeNodeType(Double d1, Double d2) {
        this.sign1 = d1;
        this.sign2 = d2;
    }


    @Override
    public Double eval() {
        return Math.pow(sign1, sign2);
    }

    @Override
    protected void instantiate(Object[] objects) {
        this.sign1 = (Double) objects[0];
        this.sign2 = (Double) objects[1];
    }


}
