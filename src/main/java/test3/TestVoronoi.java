package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
public class TestVoronoi extends TestObjetSub {
   private Double [][][] distancesSum;
   private ArrayList<Point3D> pointsList;
   private Double maxDist;
   public int pointsSize = 10;
   private int[][] pointNo;
      
   
   private Color [] colors = new Color[pointsSize];
   public void ginit() {
        pointsList = new ArrayList();
        maxDist = 0.0;
        distancesSum = new Double [getResx()][getResy()][pointsSize];
      pointNo = new int[getResx()][getResy()];
      for(int i = 0; i<pointsSize; i++)
          pointsList.add(new Point3D(Math.random()*getResx(),
                                  Math.random()*getResy(),
                                  0.0));
     
      colors[i] = Colors.random();
   }

   public void finit() {
        maxDist = 0.0;
        for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {

                  //distancesSum [i][j][] = 0.0;
                  Point3D p = new Point3D((double)i, (double)j, 0.0);
                  for(int k=0; k<pointsList.size(); k++) {
                       
                  
                       distancesSum[i][j][k] = Point3D.distance(p, pointsList.get(k));
                       if(distancesSum[i][j][k]>maxDist)
                           maxDist = distancesSum[i][j];
                     
                  }
                int pointNoIjk = -1;
                   double distMin = Math.max(getResx(),getResy());
                  for(int k=0; k<pointsList.size(); k++) {
                      if(distMin>distancesSum[i][j][k])
                         distMin = distancesSum[i][j][k];
                     pointNoIjk = k;
                     
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
