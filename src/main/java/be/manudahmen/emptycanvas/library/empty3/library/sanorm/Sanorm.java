/***
 * Copyright Manuel Dahmen 2015
 * <p>
 * Courbe, surface, volume de type "variation fonctionnelle sur un tracé polygonal ou paramétrique
 * <p>
 * f(t) = |sin(4*2*PI*n*t| t E [0,1]
 * <p>
 * CheminBezier = ((-1,-1), (-1,1), (1,-1),(-1,-1))
 * Ordre 1.
 * <p>
 * CB'(t) = vecteur tangent à la courbe au point CB(t)
 * <p>
 * -> |t->| = 1
 * <p>
 * CB^CB'=k . |n->| où |n->|=1
 * <p>
 * nuage->(t) = CB->(t) + a . f(t)
 * <p>
 * Varier le tracé d'une courbe à partir d'une fonction
 * <p>
 * Paramètre type forme Bézier ordre n (âme de la courbe)
 * Paramètre type forme fonction f(t) (variation de la courbe)
 * Paramètre type forme a (mise à l'échelle)
 * Calcul de t-> et n->
 * Calcul et dessin par itérations successives
 * <p>
 * Intérêt d'une définition de surface :
 * S(u,v) = Ame->(u) + f(v) . n->
 * <p>
 * Intérêt de volume (prochaine étape de la réflexion)
 */
package be.manudahmen.emptycanvas.library.empty3.library.sanorm;

import be.manudahmen.emptycanvas.library.empty3.library.math.E3MathWaw;
import be.manudahmen.emptycanvas.library.empty3.library.nurbs.ParametrizedCurve;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;
import be.manudahmen.emptycanvas.library.empty3.library.tribase.TRIObjetGenerateurAbstract;

/**
 * @author Dahmen Manuel ::
 *         2. Extrusion 3D.
 */
public class Sanorm extends TRIObjetGenerateurAbstract {
    ParametrizedCurve curveBase;
    ParametrizedCurve curveRepeat;
    double intervalleApproxTgt = 0.00001;

    public Sanorm(ParametrizedCurve curveBase, ParametrizedCurve curveRepeat) {
        this.curveBase = curveBase;
        this.curveRepeat = curveRepeat;
    }


    public Sanorm() {
    }

    public static void main(String[] args) {

    }

    public Point3D dansRepereDeCourbe(double t, Point3D p) {
        E3MathWaw w = new E3MathWaw();

        Point3D[] pts = w.calculRepere(curveBase, t);

        E3MathWaw.Repere r = w.new Repere(pts);

        return r.transform(p);
    }

    public ParametrizedCurve getCurveBase() {
        return curveBase;
    }

    public void setCurveBase(ParametrizedCurve curveBase) {
        this.curveBase = curveBase;
    }

    public ParametrizedCurve getCurveRepeat() {
        return curveRepeat;
    }

    public void setCurveRepeat(ParametrizedCurve curveRepeat) {
        this.curveRepeat = curveRepeat;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        double u = 1.0 * x / getMaxX();
        double v = 1.0 * y / getMaxY();

        return dansRepereDeCourbe(u, curveRepeat.calculerPoint3D(v));
    }

}
