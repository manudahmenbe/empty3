package one.empty3.pointset;

import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.raytracer.tree.AlgebricTree;
import one.empty3.library.core.raytracer.tree.TreeNodeEvalException;

import java.util.HashMap;

/**
 * Created by manue on 16-07-19.
 *
 * '"
 * Ici il s'agit de faire évoluer des points à travers des lignes de forces
 * sans corps ni énergje d'un champ abstrait de force. But: waw
 * ""
 */
public class ComposanteForceSurface {


    private AlgebricTree x;
    private HashMap<String, Double> map;
    public HashMap<String, Double> map2 = new HashMap<>();
    private int itereAxes;

    public ComposanteForceSurface(AlgebricTree x, double dv) {
        setItereAxes(5);
        this.x = x;
        declareVar("dv", dv);
        declareVar("x", 1.0);
        declareVar("y", 1.0);
        declareVar("z", 1.0);
        declareVar("R", 1.0);
    }


    public Double evSurface() throws TreeNodeEvalException, AlgebraicFormulaSyntaxException {
        return x.eval();
    }

    public void declareVar(String var, Double value) {
        x.getParametersValues().put(var, value);
    }
    public double diff() throws TreeNodeEvalException, AlgebraicFormulaSyntaxException {
        double max = Double.MAX_VALUE;
        double curr = -1;
        double aCurr = Double.MAX_VALUE;
        double eval = -1;
        boolean trouve = false;
        for (int i = 0; i < itereAxes; i++) {
            declareVar("x", getVar("x") + (Math.random()-0.5)*getVar("dv"));
            declareVar("y", getVar("y") + (Math.random()-0.5)*getVar("dv"));
            declareVar("z", getVar("z") + (Math.random()-0.5)*getVar("dv"));
            declareVar("R", getVar("R") + (Math.random()-0.5)*getVar("dv"));

            curr = Math.abs(evSurface());
            if (curr < aCurr) {
                aCurr = curr;
                map2.put("x", getVar("x"));
                map2.put("y", getVar("y"));
                map2.put("z", getVar("z"));
                map2.put("R", getVar("R"));
                map2.put("dv", getVar("dv"));
                 trouve = true;
            }
        }
        if(trouve) {
            // TODO Itérer selon un axe linéaire, exponotielle, puissance, log, etc.
            // TODO Itérer selon l'axe p0+(p1-p0)*dv Réduire l'écart
            declareVar("x", map2.get("x"));
            declareVar("y", map2.get("y"));
            declareVar("z", map2.get("z"));
            declareVar("R", map2.get("R"));
            declareVar("dv", map2.get("dv")/2);
        }
        else {
            // TODO Itérer selon un axe linéaire, exponotielle, puissance, log, etc.
            // TODO Itérer selon tous les axes (random) et itérer aussi selon trouvé
            // TODO si l'écart est déjà réduit.
            declareVar("dv", map2.get("dv") * 2);
        }

        return curr;
    }

    public double getVar(String var) {
        return x.getParametersValues().get(var);
    }


    public void reset() {

    }

    public int getItereAxes() {
        return itereAxes;
    }

    public void setItereAxes(int itereAxes) {
        this.itereAxes = itereAxes;
    }
}
