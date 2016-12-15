package be.manudahmen.empty3.core.raytracer.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary on 15-12-16.
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
            assertEquals(algebraicTree.eval(), 2);
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }

    }

}