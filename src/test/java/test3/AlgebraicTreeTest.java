/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package test3;

import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebraicTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class AlgebraicTreeTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void addFactors() throws Exception {

    }

    @Test
    public void addTerms() throws Exception {

    }

    @Test
    public void addExponent() throws Exception {

    }

    @Test
    public void addFunction() throws Exception {

    }

    private boolean testResultVariable(String expr, double expectedResult, Map map, boolean echo) {
        AlgebraicTree algebraicTree = null;
        try {
            algebraicTree = new AlgebraicTree(expr);
            algebraicTree.setParametersValues(map);
            algebraicTree.construct();
            if (echo) System.out.println(algebraicTree);
            try {
                Object result;
                result = algebraicTree.eval();
                if (echo) System.out.println("Result : " + result);
                if (echo) System.out.println("Expected : " + expectedResult);
                assertTrue((double) result == expectedResult);
                return true;
            } catch (TreeNodeEvalException e) {
                e.printStackTrace();
                assertFalse(false);
            }
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean testResult(String expr, double expectedResult, boolean echo) {
        AlgebraicTree algebraicTree = null;
        try {
            algebraicTree = new AlgebraicTree(expr);
            algebraicTree.construct();
            if (echo) System.out.println(algebraicTree);
            try {
                Object result;
                result = algebraicTree.eval();
                if (echo) System.out.println("Result : " + result);
                if (echo) System.out.println("Expected : " + expectedResult);
                assertTrue((double) result == expectedResult);
                return true;
            } catch (TreeNodeEvalException e) {
                e.printStackTrace();
                assertFalse(false);
            }
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Test
    public void testSimpleEquation1() {
        testResult("1", 1.0, false);
    }

    @Test
    public void testSimpleEquationAdd() {
        testResult("1+1", 2.0, false);
    }

    @Test
    public void testSimpleEquationAddSubMult() {
        testResult("2*3+1*6-4", 2.0 * 3 + 1 * 6 - 4, false);
    }

    @Test
    public void testSimpleEquationAddSubMult2() {
        testResult("2*3-1*6-4", 2.0 * 3 - 1 * 6 - 4, false);
    }

    @Test
    public void testSimpleEquationAddMult() {
        testResult("2*3+1*6+4", 2 * 3 + 1 * 6 + 4, false);
    }

    @Test
    public void testSimpleEquationMult() {
        testResult("2*3", 6.0, false);
    }

    @Test
    public void testSimpleEquationAddAdd() {
        testResult("1+2+3+4+5+6", 1.0 + 2 + 3 + 4 + 5 + 6, false);
    }

    @Test
    public void testSimpleEquationAddSub() {
        testResult("1-2+3-4+5-6", 1.0 - 2 + 3 - 4 + 5 - 6, false);
    }

    @Test
    public void testSimpleEquationBracedAddAdd() {
        testResult("1+2+3-(4*2/1.5+5)*22+6", 1 + 2 + 3 - (4 * 2 / 1.5 + 5) * 22 + 6, false);
    }

    @Test
    public void testSimpleEquationAddSub2() {

        testResult("4*2/5", 4 * 2.0 / 5, false);
    }
    @Test
    public void testVariable() {

        HashMap<String, Double> vars = new HashMap<>();
        vars.put("u", 4.0);
        vars.put("v", 13.0);
        testResultVariable("u+v", 4.0+13.0, vars, true);
    }

    @Test
    public void testSimpleEquationBracedMultDiv() {
        testResult("1*2*3/4*5*4", 1.0 * 2.0 * 3.0 / 4.0 * 5.0 * 4.0, false);
    }

    @Test
    public void testSimpleFunction() {
        testResult("sin(3.14)*4", Math.sin(3.14) * 4, false);
    }

    @Test
    public void testSimple() {
        assertTrue(testResult("1", 1.0, false));
    }

    @Test
    public void testSimple2() {
        assertTrue(testResult("1.5", 1.5, false));
    }
}