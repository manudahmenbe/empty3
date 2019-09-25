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

package one.empty3.apps.pad.models;

/**
 * Created by Win on 19-10-18.
 */
public class ModelTools {
    public class AxesPrincipaux
    {

    }
    public class VolumeAxes
    {

    }
    public static Model createModel(int type)
    {
        switch (type)
        {
            case 0:
                return new HumanoidModel();
            default:
                return new HumanoidModel();
        }
    }
}
