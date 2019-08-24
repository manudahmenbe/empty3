package one.empty3.library.core.nurbs;

import one.empty3.library.Point3D;
import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebricTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;

import java.util.HashMap;

public class FunctionSurface extends ParametricSurface {
    private String x = "0";
    private String y = "0";
    private String z = "0";
    private AlgebricTree treeX;
    private AlgebricTree treeY;
    private AlgebricTree treeZ;
    final HashMap<String, Double> hashMap = new HashMap<>(2);
    private boolean drawable;

    public FunctionSurface() throws AlgebraicFormulaSyntaxException {
        super();

        recomputeTrees();
    }

    FunctionSurface(String xEqFuv, String yEqFuv, String zEqFuv) throws AlgebraicFormulaSyntaxException {
        this();
        hashMap.put("u", 0d);
        hashMap.put("v", 0d);

        this.x = xEqFuv;
        this.y = yEqFuv;
        this.z = zEqFuv;




        treeX = new AlgebricTree(xEqFuv);
        treeX.getParametersValues().putAll(hashMap);
        treeX.construct();
        treeY = new AlgebricTree(yEqFuv);
        treeY.getParametersValues().putAll(hashMap);
        treeY.construct();
        treeZ = new AlgebricTree(zEqFuv);
        treeZ.getParametersValues().putAll(hashMap);
        treeZ.construct();
        setDrawable(true);
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
        recomputeTrees();
    }

    private void recomputeTrees() {
        try {
            treeX = new AlgebricTree(x);
            treeX.setParametersValues(hashMap);
            treeX.construct();
            treeY = new AlgebricTree(y);
            treeY.setParametersValues(hashMap);
            treeY.construct();
            treeZ = new AlgebricTree(z);
            treeZ.setParametersValues(hashMap);
            treeZ.construct();
            setDrawable(true);
            declareProperties();
        } catch (AlgebraicFormulaSyntaxException e) {
            setDrawable(false);
            e.printStackTrace();
        }
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
        recomputeTrees();
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
        recomputeTrees();
    }

    public Point3D calculerPoint3D(double u, double v) {
        try {
            hashMap.put("u", u);
            hashMap.put("v", v);
            double evalX = treeX.eval();
            double evalY = treeY.eval();
            double evalZ = treeZ.eval();
            return new Point3D(evalX, evalY, evalZ);
        } catch (TreeNodeEvalException | AlgebraicFormulaSyntaxException | NullPointerException exceptione) {
            exceptione.printStackTrace();
        }

        return null;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredString().put("coordArr/function (coordArr = f(u,v))", x);
        getDeclaredString().put("y/function (y = f(u,v))", y);
        getDeclaredString().put("z/function (z = f(u,v))", z);
    }

}