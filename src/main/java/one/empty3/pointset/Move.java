package one.empty3.pointset;

import one.empty3.library.Point3D;
import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebraicTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Created by manue on 16-07-19.
 */
public class Move {


    private static final double G = 10;
    protected final PCont<Gravity> container;
    private AlgebraicTree x[] = new AlgebraicTree[3];
    private HashMap<Gravity, ComposanteForceSurface> composanteForceSurface;
    private ComposanteForceAttraction composanteForceAttraction;
    private HashMap<String, Double> map;

    public Move(PCont<Gravity> cont)

    {
        container = cont;
        composanteForceAttraction = new ComposanteForceAttraction();
        composanteForceSurface = new HashMap<>();
    }


    public void computeMoveAttraction() {
        container.iterator().forEachRemaining(new Consumer<Gravity>() {
            public void accept(Gravity t1) {
                t1.clearTemp();
            }
        });
        container.iterator().forEachRemaining(new Consumer<Gravity>() {
            public void accept(Gravity t1) {
                container.iterator().forEachRemaining(new Consumer<Gravity>() {
                    public void accept(Gravity t2) {
                        if (t1 == t2) {

                        } else {
                            t2.dv1 = composanteForceAttraction.fun(t1, t2, G, -2, 1, 1);
                        }
                    }
                });
            }
        });
        container.iterator().forEachRemaining(new Consumer<Gravity>() {
            public void accept(Gravity t1) {
                t1.changeTo(t1.plus(t1.dv1));
            }
        });
    }
    public void initMoveSurface(String[] formula, HashMap<String, Double> map) throws AlgebraicFormulaSyntaxException {
        for(int i=0; i<3; i++) {
            this.x[i] = new AlgebraicTree(formula[i]).construct();
        }
        this.map = map;
    }
    public void computeMoveSurface(Gravity t1, String param, Double value, double dv) {
        t1.clearTemp();
        try {
            if(!composanteForceSurface.containsKey(t1))
                    composanteForceSurface.put(t1, new ComposanteForceSurface(x[0],x[1],x[2],map));
            t1.changeTo(composanteForceSurface.get(t1).diff2(
                    new Point3D(
                            t1.getX(),
                            t1.getY(),
                            t1.getZ()), param, value, dv));
        } catch (TreeNodeEvalException e) {
            e.printStackTrace();
        } catch (AlgebraicFormulaSyntaxException e) {
            e.printStackTrace();
        }
    }



    public void step(double dt)
    {

    }


    public static double getG() {
        return G;
    }

    public PCont<Gravity> getContainer() {
        return container;
    }

}
