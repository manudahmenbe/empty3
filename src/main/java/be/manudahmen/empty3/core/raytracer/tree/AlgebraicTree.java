package be.manudahmen.empty3.core.raytracer.tree;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mary on 15-12-16.
 */
public class AlgebraicTree extends Tree {

    private Tree t;

    public AlgebraicTree(String formula, Map.Entry<TreeNodeParameter, Number> parameters) {

    }

    public boolean add(TreeNode src, String subformula) throws AlgebraicFormulaSyntaxException {

        if (addSingleSign(src, subformula) ||addFunction(src, subformula) || addTerms(src, subformula) || addFactors(src, subformula) || addExponent(src, subformula)) {
            Iterator<TreeNode> it = src.getChildren().iterator();
            while(it.hasNext()) {
                TreeNode children = it.next();
                if(!add(children, children.getExpressionString()))
                {
                    throw new AlgebraicFormulaSyntaxException();
                }
            }
        }
        else
            throw new AlgebraicFormulaSyntaxException();
        return true;
    }

    private boolean addSingleSign(TreeNode src, String subformula) {
        return false;
    }


    public boolean addFactors(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int i=0;
        boolean isNewFactor= false;
        int count = 0;
        int newFactorPos = 0;
        int oldFactorPos = 0;
        char newFactor = 0;
        while(i<values.length())
        {
            if(values.charAt(i)=='(')
            {
                count++;
            }
            else if(values.charAt(i)==')')
            {
                count--;
            }
            else if(values.charAt(i)=='*' && (i<values.length()-1 || values.charAt(i+1)!='*') && count==0)
            {
                newFactor='*';
                newFactorPos = i;
                isNewFactor = true;
            }
            else if(values.charAt(i)=='/' && count==0)
            {
                newFactor='/';
                isNewFactor = true;
                newFactorPos = i;
            }
            
            
            if(isNewFactor)
            {
                isNewFactor = false;
                char op = newFactor;

                String  subsubstring = values.substring(oldFactorPos, newFactorPos-1);

                TreeNode t2 = new TreeNode(t, subsubstring);


                t.getChildren().add(t2);

                if(!add(t2, subsubstring))
                {
                    throw new AlgebraicFormulaSyntaxException();
                }

                isNewFactor= false;
                count = 0;
                newFactorPos = i+2;
                oldFactorPos = i+2;
                newFactor = 0;

            }
            



        }

        return false;
    }

    public boolean addTerms(TreeNode t, String values) {
        return false;
    }

    /***
     * signMMantisseSignEExponent
     * @param t
     * @param values
     */
    public boolean addExponent(TreeNode t, String values) {
        return false;
    }

    public boolean addFunction(TreeNode t, String values) {
        return false;
    }

    private void grammar() {
        t = new Tree();

    }
}
