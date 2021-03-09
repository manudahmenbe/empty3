package test4;

import one.empty3.library.*;
import one.empty3.library.core.tribase.*;
import one.empty3.library.core.nurbs.*;
import one.empty3.library.core.testing.*;
import java.awt.Color;
import one.empty3.library.core.move.Trajectoires;
import java.awt.Color;
public class TestChien extends TestObjetSub {

    public void ginit() {
        setMaxFrames(180);
        z.setDisplayType(ZBufferImpl.SURFACE_DISPLAY_COL_TRI);
     //   scene().cameraActive().eye().changeTo(new Point3D(16., 0., 0.));
       Tubulaire3 [] patte = new Tubulaire3[4];
      // ts[0] =
//Artifact : empty3-library-3d-gui ...
       Point3D tete = new Point3D(0.,0.,0. ); //tête 
       Point3D queue = new Point3D(1.,0.,1.); // queue
       Sphere tetes = new Sphere(tete, 0.4); //sphère 
tetes.texture(new TextureCol(Color.BLUE));
queue.texture(new TextureCol(Color.BLUE));

/*Parallelepiped corps = new Parallelepiped(tete,
   new Point3D(0.,0.,0.5), 
   new Point3D( 1.,0.,0.5),
   new Point3D(0.,0.,0.5 ),
            new TextureCol(Color.BLUE)
                   );*///parallel polyèdres largeur y 0.5
   for(int i=0;i<4; i++) {
       patte[i] = new Tubulaire3();
       patte[i].texture(new TextureCol(Color.BLUE));
   }

       ((CourbeParametriquePolynomialeBezier)(patte[0].getSoulCurve().getElem())). getCoefficients().add(new Point3D(0.,0.25,0.));
       ((CourbeParametriquePolynomialeBezier)(patte[0].getSoulCurve().getElem())).getCoefficients().add(new Point3D(0.,0.25,1.)); //patte avant
        ((CourbeParametriquePolynomialeBezier)(patte[0].getSoulCurve().getElem())).getCoefficients().add(new Point3D(0.,-0.25,1.));
        ((CourbeParametriquePolynomialeBezier)(patte[0].getSoulCurve().getElem())).getCoefficients().add(new Point3D(0.,-0.25,0.));
// patte avant #2
((CourbeParametriquePolynomialeBezier)(patte[2].getSoulCurve().getElem())).getCoefficients().add(new Point3D(1.,0.25,0.));
((CourbeParametriquePolynomialeBezier)(patte[2].getSoulCurve().getElem())).getCoefficients().add(new Point3D(1.,0.25,1.)); //patte arrière #1 

((CourbeParametriquePolynomialeBezier)(patte[2].getSoulCurve().getElem())).getCoefficients().add(new Point3D(1.,-0.25,1.));// patte avant #2
((CourbeParametriquePolynomialeBezier)(patte[2].getSoulCurve().getElem())).getCoefficients().add(new Point3D(1.,-0.25,0.));
        //1,0,0 //etx queue.
    
        //scene().add(corps);
        scene().add(tetes);
        for(int i=0;i<4; i+=2) {
            scene().add(patte[i]);

        } 
//        scene().cameraActive().getEye().setZ(-10.)

//        scene().lumieres().add(new LumierePonctuelle(new Point3D(0.,0.,2.), Color.BLUE/*.YELLOW*/)) ;
   }
    public void finit() {
        Point3D sphere = Trajectoires.sphere(Point3D.O0, Point3D.Z, 1.0 * frame() / getMaxFrames(),
                0.0, 16.0);
        scene().cameras().clear();
        Camera c = new Camera(sphere, Point3D.O0, Point3D.Y);
        //c.setMatrix();
        c.declareProperties();
        scene().cameraActive(c);
    }
}
