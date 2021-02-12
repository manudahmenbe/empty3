package test4;

import one.empty3.library.*;
import one.empty3.library.core.tribase.*;
import one.empty3.library.core.testing.*;

public class TestChien extends TestObjet{

    public void ginit() {
       Tubulaire3 [] patte = new Tubulaire3[4];
      // ts[0] =
//Artifact : empty3-library-3d-gui ...
//Crée des formes de base!
       Point3D tete = new Point3D(0.,0.,0. ); //tête 
       Point3D queue = new Point3D(1.,0.,1.); // queue
       Sphere tetes = new Sphere(tete, 0.4); //sphère 
       Parallelipiped corps = new Parallelepiped(tete,
   new Point3D(0,0,0.5), 
   new Point3D( 1,0,0,0.5),
   new Point3D(0,0,0.5 ));//parallel polyèdres largeur y 0.5
   for(int i=0;i<4; i++) {
       patte[i] = new Tubulaire3();
       }

       patte[0].add(P.n(0,0.25,0));
       patte[0].add(P.n(0,0.25,1)); //patte avant 
patte[1].add(P.n(0,-0.25,0));
patte[1].add(P.n(0,-0.25,1));// patte avant #2
patte[2].add(P.n(1,0.25,0));
patte[2].add(P.n(1,0.25,1)); //patte arrière #1 
patte[3].add(P.n(1,-0.25,0));
patte[3].add(P.n(1,-0.25,1));// patte avant #2
//1,0,0 //etx queue.
    
scene().add(corps);
scene().add(tetes);
    for(int i=0;i<4; i++) {
scenes().add(patte[i]);
}
    }

    Point3D ps = new Point3D[] {
        P.n(0.,0.,0.),
        P.n(1.,0.,1.),

      };
    }
}
