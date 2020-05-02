package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
public class TestVoronoi extends TestObjet {
Double [][] distancesSum;
Double maxDist;

   public void ginit() {
        maxDist = 0.0;
        distancesSum = new Double [getResx()][getResy()];

        
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
// Laplace derivation 2
 for(int i= 0;i<getResx(); i++)
             for(int j= 0;j<getResy(); j++) {
}
   }


   public void afterRenderFrame() { 
       BufferedImage img = z.image();
       
       
   }
}
