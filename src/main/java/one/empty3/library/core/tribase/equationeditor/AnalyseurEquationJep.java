/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
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
