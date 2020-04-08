package one.empty3.library.core.nurbs;
public class FctXD_XD {
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


/**
 * Created by md 2020 4 8 */
public abstract class FctXD_XD {
int dima,dimb;
private AlgebricTree treeF ;
    public FctXD_XD(int dima, int dimb){
this.dima = dima;
this.dimb = dimb;
}
    public class Ixx extends FctXD_XD
    {

        @Override
        public Double [] result(Double [] input, Double [] output) {
            return output;
        }
    }
    public abstract void result(double [] input, double [] output);
}
public class S extends FctXD_XD {
private String fs = "1:1:1.0";
/***
 *
 * @param fs formula:dima(int):dimb(int)
 *
 * @return int[]
*/
public S(String fs)
{

String [] splits = fs.split(fs);

if(splits.length==3) {

this.formula = splits[0];
dima = Integer.parseInt(splits[1]);
dimb = Integer.parseInt(splits[2]);
}
treeF = new AlgrebricTree(formula);


}

public void result(double [] input, double [] output){


}
}
