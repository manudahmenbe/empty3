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

/***
 * Global license :
 * <p>
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package one.empty3.library.core.tribase.equationeditor;

import org.nfunk.jep.JEP;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class AnalyseurEquationJep {
    private final JEP myParser;
    private String strParser;

    public AnalyseurEquationJep(String eq) {
        myParser = new org.nfunk.jep.JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();
        strParser = eq;
    }

    public static void main(String[] args) {

        AnalyseurEquationJep anlayseurEquationJep = new AnalyseurEquationJep("a*coordArr+b*b");

        anlayseurEquationJep.setContant("a", 1);
        anlayseurEquationJep.setContant("b", 2);


        anlayseurEquationJep.setContant("coordArr", 3);
        System.out.println("Result: " + anlayseurEquationJep.value() + "( expected: 7");
        anlayseurEquationJep.setContant("coordArr", 4);
        System.out.println("Result: " + anlayseurEquationJep.value() + "(expected= 8");
        anlayseurEquationJep.setContant("coordArr", 5);
        System.out.println("Result: " + anlayseurEquationJep.value() + "(expected= 9");


    }

    public void parse(String parse) {
        strParser = parse;
    }

    public double value() {
        myParser.parseExpression(strParser);
        return myParser.getValue();
    }

    public void setVariable(String name, double v) {
        myParser.addVariable(name, v);
    }

    public void setContant(String name, double v) {
        myParser.addVariable(name, v);
    }


}
