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

package one.empty3.library.core.raytracer.tree;

import one.empty3.library.core.raytracer.tree.functions.MathFunctionTreeNodeType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public class AlgebricTree extends Tree {

    private String formula ="0.0";
    Map<String, Double> parametersValues = new HashMap<>();
    private Tree t;
    private TreeNode root;

    public AlgebricTree(String formula) throws AlgebraicFormulaSyntaxException {
        this.formula = formula;
    }

    public AlgebricTree(String fParamString, Map<String, Double> parametersValues) {
        this.formula = formula;
        this.parametersValues = parametersValues;
    }

    public AlgebricTree construct() throws AlgebraicFormulaSyntaxException {
        root = new TreeNode(formula);
        add(root, formula);
        return this;
    }
    public boolean add(TreeNode src, String subformula) throws AlgebraicFormulaSyntaxException {

        if (src == null || subformula == null || subformula.length() == 0)
            return false;

        if (
                addFormulaSeparator(src, subformula) ||
                        addTerms(src, subformula) ||
                        addFactors(src, subformula) ||
                        addExponent(src, subformula) ||
                        addSingleSign(src, subformula) ||
                        addDouble(src, subformula) ||
                        addVariable(src, subformula) ||
                        addFunction(src, subformula) ||
                        addBracedExpression(src, subformula)

                ) {
            /*Iterator<TreeNode> it = src.getChildren().iterator();
            while (it.hasNext()) {
                TreeNode children = it.next();
                if (!add(children, children.getExpressionString())) {
                    //throw new AlgebraicFormulaSyntaxException();
                }
            }*/
        } else
            throw new AlgebraicFormulaSyntaxException(this);
        return true;
    }

    private boolean addFormulaSeparator(TreeNode src, String subformula) {
        String[] s;
        s = subformula.split("=");
        if (s.length > 1) {
            EquationTreeNode tt = new EquationTreeNode(subformula);
            tt.getChildren().add(new EquationTreeNode(s[0]));
            tt.getChildren().add(new EquationTreeNode(s[1]));
        } else
            return false;
        return true;
    }

    private boolean addVariable(TreeNode src, String subformula) {
        if (Character.isLetter(subformula.charAt(0))) {
            int i = 1;
            while (i < subformula.length() && Character.isLetterOrDigit(i)) {
                i++;
            }
            if (i == subformula.length() && i > 0) {
                VariableTreeNodeType variableTreeNodeType = new VariableTreeNodeType();
                variableTreeNodeType.setValues(new Object[]{subformula, parametersValues});
                src.getChildren().add(new TreeNodeVariable(src, new Object[]{subformula, parametersValues}, variableTreeNodeType));

                return true;
            }
        }
        return src.getChildren().size() > 0;
    }


    private boolean addDouble(TreeNode src, String subformula) {
        try {
            Double d = Double.parseDouble(subformula);
            DoubleTreeNodeType doubleTreeNodeType = new DoubleTreeNodeType();
            doubleTreeNodeType.setValues(new Object[]{subformula, d});
            src.getChildren().add(new TreeNodeDouble(src, new Object[]{subformula, d}, doubleTreeNodeType));

            return true;
        } catch (NumberFormatException ex) {
            return src.getChildren().size() > 0;
        }
    }
//
//
//    private boolean addConstant(TreeNode src, String subformula) {
//        try {
//            Double d = Double.parseDouble(subformula);
//            src.getChildren().add(new TreeNode(src, new Object[]{subformula}, new DoubleTreeNodeType(d)));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
/*
        if (Character.isDigit(subformula.charAt(0)) || subformula.charAt(0) == '-') {
            int i = 1;
            while (i < subformula.length() && (Character.isDigit(i) || Character.toUpperCase(subformula.charAt(i)) == 'E'
                    || subformula.charAt(i) == '-'
                    || subformula.charAt(i) == '.')) {
                i++;
            }
            if (i == subformula.length()) {
                src.getChildren().add(new TreeNode(src, new Object[]{subformula}, new DoubleTreeNodeType(Double.parseDouble(subformula))));

                return true;
            }

        }
        */
    //return src.getChildren().size() > 0;
    //}

    private boolean addSingleSign(TreeNode src, String subformula) {
        if (subformula.charAt(0) == '-') {
            src.getChildren().add(new TreeNode(src, new Object[]{subformula.substring(1)}, new SignTreeNodeType(-1.0)));
            return true;
        }
        return false;

    }


    public boolean addFactors(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int countTerms = 0;

        TreeNode t2;
        int i = 0;
        boolean firstTermFound = false;
        boolean isNewFactor = false;
        int count = 0;
        int newFactorPos = 0;
        int oldFactorPos = 0;
        char newFactor = '*';
        double newFactorSign = 1;
        double oldFactorSign = 1;
        while (i < values.length()) {
            if (values.charAt(i) == '(') {
                count++;
            } else if (values.charAt(i) == ')') {
                count--;
            } else if (values.charAt(i) == '*' && /*9(i < values.length() - 1 || values.charAt(i + 1) != '*') &&*/ count == 0) {
                newFactor = '*';
                newFactorPos = i;
                isNewFactor = true;
                firstTermFound = true;
                newFactorSign = 1;
            } else if (values.charAt(i) == '/' && count == 0) {
                newFactor = '/';
                isNewFactor = true;
                newFactorPos = i;
                firstTermFound = true;
                newFactorSign = -1;
            } else if (i == values.length() - 1 && count == 0 && firstTermFound) {
                isNewFactor = true;
                newFactorPos = i + 1;
                /*if (values.charAt(oldFactorPos - 1) == '/') {
                    newFactorSign = -1;
                    newFactor = '/';//??
                } else if (values.charAt(oldFactorPos - 1) == '*') {
                    newFactorSign = 1;
                    newFactor = '*';//??
                } else throw new AlgebraicFormulaSyntaxException("Ni + ni -");
            */
            }


            if (isNewFactor) {
                countTerms++;
                String subsubstring = values.substring(oldFactorPos, newFactorPos);


                if (subsubstring.length() > 0) {
                    t2 = new TreeNode(t, new Object[]{subsubstring}, new FactorTreeNodeType(oldFactorSign));
                    t.getChildren().add(t2);
                    if (!add(t2, subsubstring)) {
                        return false;
                    }
                }


                isNewFactor = false;
                count = 0;
                newFactorPos = i + 1;
                oldFactorPos = i + 1;
                newFactor = 0;
                oldFactorSign = newFactorSign;
            }

            i++;


        }
        return t.getChildren().size() > 0 && countTerms > 0;
    }

    public boolean addTerms(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int countTerms = 0;

        TreeNode t2;
        int i = 0;
        boolean firstTermFound = false;
        boolean isNewFactor = false;
        int count = 0;
        int newFactorPos = 0;
        int oldFactorPos = 0;
        char newFactor = '+';
        double newFactorSign = 1;
        double oldFactorSign = 1;
        while (i < values.length()) {
            if (values.charAt(i) == '(') {
                count++;
            } else if (values.charAt(i) == ')') {
                count--;
            } else if (values.charAt(i) == '+' /*&& (i < values.length() - 1 || values.charAt(i + 1) != '+')*/ && count == 0) {
                newFactor = '+';
                newFactorPos = i;
                isNewFactor = true;
                firstTermFound = true;
                newFactorSign = 1;
            } else if (values.charAt(i) == '-' && count == 0) {
                newFactor = '-';
                isNewFactor = true;
                newFactorPos = i;
                firstTermFound = true;
                newFactorSign = -1;
            }
            if (i == values.length() - 1 && count == 0 && firstTermFound) {
                isNewFactor = true;
                newFactorPos = i + 1;
/*                if (values.charAt(oldFactorPos - 1) == '-') {
                    newFactorSign = -1;
                    newFactor = '-';
                } else if (values.charAt(oldFactorPos - 1) == '+') {
                    newFactorSign = 1;
                    newFactor = '+';
                }
*/               // else throw new AlgebraicFormulaSyntaxException("Ni + ni -");

            }


            if (isNewFactor) {
                countTerms++;
                isNewFactor = false;
                char op = newFactor;

                String subsubstring = values.substring(oldFactorPos, newFactorPos);


                if (subsubstring.length() > 0) {
                    t2 = new TreeNode(t, new Object[]{subsubstring}, new TermTreeNodeType(oldFactorSign));
                    t.getChildren().add(t2);
                    if (!add(t2, subsubstring)) {
                        return false;
                    }
                }


                isNewFactor = false;
                newFactorPos = i + 1;
                oldFactorPos = i + 1;
                newFactor = 0;
                oldFactorSign = newFactorSign;
            }

            i++;


        }

        return t.getChildren().size() > 0 && countTerms > 0;
    }

    /***
     * signMMantisseSignEExponent
     *
     * @param t
     * @param values
     */
    public boolean addExponent(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int i = 0;
        boolean isNewFactor = false;
        int count = 0;
        int newFactorPos = 0;
        int oldFactorPos = 0;
        char newFactor = 0;
        while (i < values.length()) {
            if (values.charAt(i) == '(') {
                count++;
            } else if (values.charAt(i) == ')') {
                count--;
            } else if (values.charAt(i) == '*' && (i < values.length() - 1 && values.charAt(i + 1) != '*') && count == 0) {
                newFactor = '^';
                newFactorPos = i;
                isNewFactor = true;
            }


            if (isNewFactor) {
                isNewFactor = false;
                char op = newFactor;

                String subsubstring = values.substring(oldFactorPos, newFactorPos - 1);
                String substring2 = values.substring(newFactorPos + 1);
                TreeNode t2 = new TreeNode(t, new Object[]{subsubstring, substring2}, new ExponentTreeNodeType(1.0, 1.0));


                t.getChildren().add(t2);

                add(t, substring2);

                if (!add(t, subsubstring)) {
                    throw new AlgebraicFormulaSyntaxException();
                }

                isNewFactor = false;
                count = 0;
                newFactorPos = i + 2;
                oldFactorPos = i + 2;
                newFactor = 0;

            }

            i++;


        }

        return t.getChildren().size() > 0;
    }

    public boolean addFunction(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int i = 1;
        boolean isNewFactor = false;
        int count = 0;
        int newFactorPos = 0;
        int oldFactorPos = 0;
        char newFactor = 0;
        int countLetters = 0;

        while (i < values.length()) {
            if (Character.isLetter(values.charAt(0)) && Character.isLetterOrDigit(values.charAt(i)) && count == 0) {
                countLetters++;
            } else if (values.charAt(i) == '(') {
                if (count == 0) {
                    newFactorPos = i + 1;
                }
                count++;
            } else if (values.charAt(i) == ')') {
                count--;
            }


            if (i == values.length() - 1 && count == 0 && values.charAt(i) == ')') {


                String fName = values.substring(oldFactorPos, newFactorPos - 1);
                String fParamString = values.substring(newFactorPos, i);


                MathFunctionTreeNodeType mathFunctionTreeNodeType = new MathFunctionTreeNodeType();

                AlgebricTree algebricTree = new AlgebricTree(fParamString, parametersValues);
                algebricTree.getParametersValues().putAll(parametersValues);
                algebricTree.construct();
                mathFunctionTreeNodeType.setAlgebricTree(algebricTree);

                TreeNode t2 = new TreeNode(t, new Object[]{fName}, mathFunctionTreeNodeType);


                t.getChildren().add(t2);

/*                if (!add(t2, fName)) // (add () parameters)
                {
                    throw new AlgebraicFormulaSyntaxException();
                } else {
*/
                return true;
                //              }
            }


            i++;

        }

        return t.getChildren().size() > 0;
    }

    public boolean addBracedExpression(TreeNode t, String values) throws AlgebraicFormulaSyntaxException {
        int i = 1;
        int count = 0;
        if (values.charAt(0) == '(') {
            count++;
            while (i < values.length()) {
                if (values.charAt(i) == ')') {
                    count--;
                }
                if (values.charAt(i) == '(') {
                    count++;
                }

                if (i == values.length() - 1 && count == 0 && values.charAt(i) == ')') {
                    String subsubstring = values.substring(1, values.length() - 1);

                    TreeNode t2 = new TreeNode(t, new Object[]{subsubstring}, new IdentTreeNodeType());

                    //System.err.println(subsubstring);

                    t.getChildren().add(t2);

                    if (!add(t2, subsubstring)) // (add () parameters)
                    {
                        throw new AlgebraicFormulaSyntaxException();
                    } else {
                        return true;
                    }

                }


                i++;

            }

        }

        return t.getChildren().size() > 0;
    }

    private void grammar() {
        t = new Tree();

    }


    public Double eval() throws TreeNodeEvalException, AlgebraicFormulaSyntaxException {
        //System.out.println(parametersValues.size());
        return root.eval();
    }

    public String toString() {
        String s = "Arbre algébrique\n" +
                "Racine: " + root.getClass() + root.toString();
        return s;
    }

    public void setParametersValues(Map<String, Double> parametersValues) {
        this.parametersValues = parametersValues;
    }

    public Map<String, Double> getParametersValues() {
        return parametersValues;
    }
}
