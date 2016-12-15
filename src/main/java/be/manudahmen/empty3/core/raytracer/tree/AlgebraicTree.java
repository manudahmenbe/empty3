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

        if(addTerms(src, subformula) || addFactors(src, subformula)||addExponent(src,subformula)||addFunction(src, subformula))
        {
            for(TreeNode children : src.getChildren())
            {
                add(children, children.getExpressionString());
            }
        }
        return src;
    }


    public boolean addFactors(TreeNode t, String values)
    {
        return false;
    }
    public boolean addTerms(TreeNode t, String values)
    {
        return false;
    }

    /***
     * signMMantisseSignEExponent
     * @param t
     * @param values
     */
    public boolean addExponent(TreeNode t, String values)
    {
        return false;
    }
    public boolean addFunction(TreeNode t,  String values)
    {
        return false;
    }
    private void grammar()
    {
        t = new Tree();

    }
}
