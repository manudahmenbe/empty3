package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
import one.empty3.library.core.lighting.Colors;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
public class TestVoronoi extends TestObjetSub {
public int pointsSize = 10;
   private CourbeParametriquePolynomialeBezier[] curves = new CourbeParametriqueBezier[pointsSize];
   private Double [][][] distancesSum;
   private ArrayList<Point3D> pointsList;
   private Double maxDist;
   
   private int[][] pointNo;
   protected void addRand(CourbeParametriquePolynomialeBezier c) {
       c.getCoefficients().addElem(new Point3D(Math.random()*getResx(),
                                  Math.random()*getResy(),
                                  0.0));

}
   
   private Color [] colors = new Color[pointsSize+1];
   public void ginit() {
        pointsList = new ArrayList();
        maxDist = 0.0;
      //  distancesSum = new Double [getResx()][getResy()][pointsSize];
      pointNo = new int[getResx()][getResy()];
      for(int i = 0; i<pointsSize+1; i++) {
          pointsList.add(new Point3D(Math.random()*getResx(),
                                  Math.random()*getResy(),
                                  0.0));
     curves[i] = new CourbeParametriquePolynomialeBezier();
     for(int p=0;p<6;p++)
           addRand(curves[i]);
           colors[i] = Colors.random();
         }
      colors[0] = Color.BLACK;
   }

   public void finit() {
      double dist = 0.0;
        maxDist = 0.0;
        for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {

                  //distancesSum [i][j][] = 0.0;
                  Point3D p = new Point3D((double)i, (double)j, 0.0);

                int pointNoIjk = 0;
                   double distMin = Math.max(getResx(),getResy());
                   
                  for(int k=0; k<pointsList.size(); k++) {
                       
                      /*distancesSum[i][j][k] */dist= Point3D.distance(p, curves.getElem(k).calculerPoint3D(((double)frame())/25.0/100.0));
                       if(dist/*distancesSum[i][j][k]*/>maxDist)
                           maxDist = dist;// distancesSum[i][j][k];
                     
                  
                
                      if(distMin>dist/*distancesSum[i][j][k]*/) {
                         distMin = dist/*distancesSum[i][j][k]*/;
                         pointNoIjk = k;
                     }
                  }
                  pointNo[i][j] = pointNoIjk;
                     
                     
                  
                  
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
                  image.setRGB(i, j, colors[pointNo[i][j]].getRGB());
       }
   }
}
