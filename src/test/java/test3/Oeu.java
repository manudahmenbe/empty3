package test3;

/**
 * Created by manue on ${date}
 */

import one.empty3.library.Point3D;
import one.empty3.library.core.raytracer.tree.AlgebraicFormulaSyntaxException;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.pointset.Gravity;
import one.empty3.pointset.Move;
import one.empty3.pointset.PCont;

import java.util.HashMap;

/***
 *
 * Rassembler et améliorer les calculs sur des ensembles de points dans un package
 * utilisable et extensible.
 *
 * delta(x2+y2+z2-R) pente force 1
 * delta(mM(p2-p1)/d3) pente force 2
 * combiner et calibrer
 * accrocher les points sur la surface
 */
public class Oeu extends TestObjetSub{
    PCont<Gravity> point3DPCont = new PCont<Gravity>();
    Move move = new Move(point3DPCont);
    HashMap<String, Double> map;

   public static void main(String [] args)
   {
       Oeu oeu = new Oeu();
       new Thread(oeu).start();
   }
    public void ginit()

    {
        map = new HashMap();
        scene().add(point3DPCont);
        for (int i = 0; i < 1000; i++) {

            Gravity gravity = new Gravity(1.0, Point3D.O0);
            gravity.become(Point3D.random(1.0));
            point3DPCont.add(gravity);
                try {
                    move.initMoveSurface(new String [] {
                            "x*x+y*y+z*z-R*R",
                            "x*x+y*y+z*z-R*R",
                            "x*x+y*y+z*z-R*R"}, map);
                } catch (AlgebraicFormulaSyntaxException e) {
                    e.printStackTrace();
                }
        }
    }
   public void finit() {
       for (int i = 0; i < 1000; i++)
           move.computeMoveSurface(point3DPCont.get(i), "R", 0.1, 0.001);
   }
}
