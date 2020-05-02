package test3;
import one.empty3.library.core.testing.*;
import one.empty3.library.*;
public class TestVoronoi extends TestObjet {
Double [][] distancesSum;
Double maxDist;

   public TestVoronoi () {
        maxDist = 0.0;
        distancesSum = new Double [getResx()][getResy()];
        
   }
}
