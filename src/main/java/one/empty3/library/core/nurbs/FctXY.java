package one.empty3.library.core.nurbs;

import one.empty3.library.StructureMatrix;
import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebricTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;

/**
 * Created by manue on 28-05-19.
 */
public class FctXY extends Fct1D_1D {
    private StructureMatrix<String> formulaX = new StructureMatrix<>(0);
    private AlgebricTree treeX;

    public FctXY()
    {
        formulaX.setElem("10.0");

        try {
            treeX = new AlgebricTree(formulaX.getElem());
            treeX.construct();
            treeX.getParametersValues().put("x", 10.0);
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }

    }

    public void setFormulaX(String formulaX)
    {
        this.formulaX.setElem(formulaX);

        try {
            treeX = new AlgebricTree(formulaX);
            treeX.getParametersValues().put("x", 0.0);
            treeX.construct();
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getFormulaX() {
        return formulaX.getElem();
    }

    public double result(double input)
    {
        treeX.getParametersValues().put("x", input);
        try {
            return treeX.eval();
        } catch (TreeNodeEvalException e) {
            e.printStackTrace();
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }
        return Double.NaN;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("formulaX/fonction Y=f(x)", formulaX);
    }

    @Override
    public String toString() {
        return "fctXY( \""+formulaX+"\" )\n";
    }
}
