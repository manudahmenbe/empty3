package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
import one.empty3.library.core.lighting.*;
import java.awt.*;
import one.empty3.library.core.nurbs.*;
import java.awt.image.*;
import java.util.*;

/***
 *
 * proximity. bezier _curve_ ie.
 *
 */
public class TestVoronoi extends TestObjetSub {
public int pointsSize = 20;
   private CourbeParametriquePolynomialeBezier[] curves = new CourbeParametriquePolynomialeBezier[pointsSize];
  // private Double [][][] distancesSum;
   //private ArrayList<Point3D> pointsList;
   private Double maxDist;
   private int nPointsDist = pointsSize;
   ///private double[][][] pointDist;
  // private int[][][] pointNo;
   private int[][] colorsArr;
  // private ColorDist [][][] cds;
    

   protected void addRand(CourbeParametriquePolynomialeBezier c) {
       c.getCoefficients().add(new Point3D(Math.random()*getResx(),
                                  Math.random()*getResy(),
                                  0.0));

}
   
   private Color [] colors = new Color[pointsSize];
   public void ginit() {
 // mettre les distances dans l ordre
      // regarder a 1 ou 2 pixels près 
      // non
      
      
      //pointDist = new double[getResx()][getResy()][pointsSize];
        
      //  distancesSum = new Double [getResx()][getResy()][pointsSize];
   //  pointNo = new int[getResx()][getResy()][pointsSize];
  //  cds = new ColorDist[getResx()][getResy()][pointsSize];
    for(int i = 0; i<pointsSize; i++) {
          //pointsList.add(new Point3D(Math.random()*getResx(),
          //                        Math.random()*getResy(),
          //                        0.0));
          curves[i] = new CourbeParametriquePolynomialeBezier();
         curves[i].getCoefficients().data1d.clear();
          for(int p=0;p<4;p++) {
              addRand(curves[i]);
          }
         colors[i] = Colors.random();
         
         curves[i].declareProperties();
         
      }
      colorsArr = new int[getResx()][getResy()];
     
   }
   public void finit() {
      ColorDist [] cds = new ColorDist[pointsSize];
      double dist = 0.0;
        
        for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {

                  //distancesSum [i][j][] = 0.0;
                  Point3D p = new Point3D((double)i, (double)j, 0.0);

                int pointNoIjk = 0;
                   double [] distMin = new double [nPointsDist];
                 // distMin[k] = Double.MAX_VALUE; //Math.max(getResx(),getResy());
                     maxDist = 0.0;
                for(int k=0; k<pointsSize; k++) {
                     cds[k] = new ColorDist();
                     cds[k].dist=Point3D.distance(p, curves[k].calculerPoint3D(frame()/20.5));
                     if(dist>maxDist)
                          maxDist = dist;
                     cds[k].dist = dist;
                     cds[k].color = colors[k];
                }
                
                ColorDist.sort(cds);
                Color z =  Colors.mean(cds, 1.0, nPointsDist);
                z = new Color(z.getRed(), z.getGreen(), z.getBlue());
                colorsArr[i][j] = z.getRGB();
        }
        for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {
                  //distancesSum[i][j][] /= maxDist;
             }
// Laplace derivation 2
 for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {
                 // laplacien[i][j]
             }
   }


   public void afterRenderFrame() { 
       BufferedImage image = img();
       for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {
                //int c = ((int)(double) distancesSum[i][j][])*256+ 255<<24;
                  image.setRGB(i, j, colorsArr[i][j]);
       }
   }
}
