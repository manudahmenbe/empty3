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

package be.manudahmen.empty3.core.raytracer.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    @Test
    public void testSimpleEquation()
    {
        AlgebraicTree algebraicTree = null;
        try {
            algebraicTree = new AlgebraicTree("1+1", null);
            assertTrue((int) algebraicTree.eval() == 2);
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSimple() {
        AlgebraicTree algebraicTree = null;
        try {
            algebraicTree = new AlgebraicTree("1", null);
            assertTrue((int) algebraicTree.eval() == 1);
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }

    }

}