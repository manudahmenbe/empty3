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
    private TreeNode root ;
    public AlgebraicTree(String formula, Map.Entry<TreeNodeParameter, Number> parameters) throws AlgebraicFormulaSyntaxException {
        root = new TreeNode(formula);
        add(root, formula);
    }

    public boolean add(TreeNode src, String subformula) throws AlgebraicFormulaSyntaxException {

        if (addSingleSign(src, subformula) ||
                addFunction(src, subformula) ||
                addTerms(src, subformula) ||
                addFactors(src, subformula) ||
                addExponent(src, subformula) ||
            addVariable(src, subformula) ||
        addConstant(src, subformula)){
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

    private boolean addVariable(TreeNode src, String subformula) {
        if(Character.isLetter(subformula.charAt(0) ))
        {
            int i=0;
            while (i<subformula.length() && Character.isLetterOrDigit(i))
            {
                i++;
            }
            if(i==subformula.length())
            {
                src.getChildren().add(new TreeNodeVariable(src, subformula));

                return true;
            }

        }
        return false;
    }

    private boolean addConstant(TreeNode src, String subformula) {
        if(Character.isDigit(subformula.charAt(0) ) ||subformula.charAt(0)=='-' )
        {
            int i=0;
            while (i<subformula.length() && (Character.isDigit(i) || Character.toUpperCase(subformula.charAt(i))=='E'
             ||subformula.charAt(i)=='-'))
            {
                i++;
            }
            if(i==subformula.length())
            {
                src.getChildren().add(new TreeNodeVariable(src, subformula));

                return true;
            }

        }
        return false;
    }

    private boolean addSingleSign(TreeNode src, String subformula) {
        if(subformula.charAt(0)=='-')
        {
            src.getChildren().add(new TreeNode(src, subformula.substring(1)));
            return true;
        }
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

        return true;
    }

    public boolean addTerms(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {

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
            else if(values.charAt(i)=='+' && (i<values.length()-1 || values.charAt(i+1)!='+') && count==0)
            {
                newFactor='+';
                newFactorPos = i;
                isNewFactor = true;
            }
            else if(values.charAt(i)=='-' && count==0)
            {
                newFactor='-';
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

        return true;
    }

    /***
     * signMMantisseSignEExponent
     * @param t
     * @param values
     */
    public boolean addExponent(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
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
            else if(values.charAt(i)=='*' && (i<values.length()-1 && values.charAt(i+1)!='*') && count==0)
            {
                newFactor='^';
                newFactorPos = i;
                isNewFactor = true;
            }


            if(isNewFactor)
            {
                isNewFactor = false;
                char op = newFactor;

                String  subsubstring = values.substring(oldFactorPos, newFactorPos-1);
                String substring2 =  values.substring(newFactorPos+1);
                TreeNode t2 = new TreeNodeOperator(t, subsubstring, substring2, "exp");


                t.getChildren().add(t2);

                add(t, substring2);

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

        return true;
    }

    public boolean addFunction(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int i=0;
        boolean isNewFactor= false;
        int count = 0;
        int newFactorPos = 0;
        int oldFactorPos = 0;
        char newFactor = 0;
        int countLetters = 0;
        while(i<values.length())
        {
            if(Character.isLetterOrDigit(values.charAt(i)) && count ==0) {
                countLetters ++;
            }
            else
                if(values.charAt(i)=='(')
                {
                    count++;
                }
                else if(values.charAt(i)==')')
                {
                    count--;
                }


            if(i==values.length()-1 && count==0 && values.charAt(i)==')')
            {
                String  subsubstring = values.substring(oldFactorPos, newFactorPos-1);

                TreeNode t2 = new TreeNode(t, subsubstring);


                t.getChildren().add(t2);

                if(!add(t2, subsubstring))
                {
                    throw new AlgebraicFormulaSyntaxException();
                }

                return true;
            }




        }

        return false;
    }

    private void grammar() {
        t = new Tree();

    }


    public double eval() {
        return -1;
    }
}
