package test4;

import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebricTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;

import java.util.HashMap;

public class AngleMovment {
        AlgebricTree[] tree;
        HashMap<String, Double> vars;
        public AngleMovment(int size) {
            tree = new AlgebricTree[size];
            vars = new HashMap<>(size);
        }
        public void var(String var, double val) {
            vars.put(var, val);
        }
        public void setFormula(int index, String chars) {

            tree[index] = new AlgebricTree(chars, vars);
            tree[index].setParametersValues(vars);
            try {
                tree[index].construct();
            } catch (AlgebraicFormulaSyntaxException e) {
                e.printStackTrace();
            }
        }
        public double calculerAngle(int index) {
            try {
                return (double)(tree[index].eval());
            } catch (TreeNodeEvalException | AlgebraicFormulaSyntaxException e) {
                e.printStackTrace();
            }
            return Double.NaN;
        }


}
