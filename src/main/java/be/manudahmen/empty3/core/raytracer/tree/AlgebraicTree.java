package be.manudahmen.empty3.core.raytracer.tree;

import java.lang.reflect.Method;

/**
 * Created by mary on 15-12-16.
 */
public class AlgebraicTree extends  Tree{

    private Tree t;

    public AlgebraicTree(String formula)
    {

    }

    public TreeNode add(TreeNode src, String subformula)
    {

        return src;
    }

    public TreeNode<TreeNode[]> split(String subformula)
    {

        return null;
    }

    public void addFactors(TreeNode t, String [] values)
    {

    }
    public void addTerms(TreeNode t, String [] values)
    {

    }

    /***
     * signMMantisseSignEExponent
     * @param t
     */
    public void addExponent(TreeNode t, String [] values)
    {

    }
    public void addFunction(Method m, String values)
    {}
    private void grammar()
    {
        t = new Tree();

    }
}
