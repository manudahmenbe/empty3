package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
import java.awt.Colir;
import java.util.List;
public class TestVoronoi extends TestObjet {
Double [][] distancesSum;
   private List<Point3D> pointsList;
Double maxDist;

   public void ginit() {
        pointsList = new ArrayList();
        maxDist = 0.0;
        distancesSum = new Double [getResx()][getResy()];
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
       BufferedImage img = getImg();
       for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {
                  img.setRgb(i, j, new Color((float)distancesSum[i][j], 0f, 0f));
       }
   }
}
