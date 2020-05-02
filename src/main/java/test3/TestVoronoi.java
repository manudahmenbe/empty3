package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
public class TestVoronoi extends TestObjetSub {
   private Double [][] distancesSum;
   private ArrayList<Point3D> pointsList;
   private Double maxDist;

   public void ginit() {
        pointsList = new ArrayList();
        maxDist = 0.0;
        distancesSum = new Double [getResx()][getResy()];
      for(int i = 0; i<10; i++)
          pointsList.add(new Point3D(Math.random()*getResx(),
                                  Math.random()*getResy(),
                                  0.0));
        
   }

   public void finit() {
        maxDist = 0.0;
        for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {

                  distancesSum [i][j] = 0.0;
                  Point3D p = new Point3D((double)i, (double)j, 0.0);
                  for(int k=0; k<pointsList.size(); k++)
                       distancesSum[i][j] += Point3D.distance(p, pointsList.get(k));
                  if(distancesSum[i][j]>maxDist)
                       maxDist = distancesSum[i][j];
             }
        for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {
                  distancesSum[i][j] /= maxDist;
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
                int c = ((int)(double) distancesSum[i][j])*256+ 255<<24;
                  image.setRGB(i, j, c);
       }
   }
}
