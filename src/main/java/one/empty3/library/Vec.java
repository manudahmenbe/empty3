package one.empty3.library;

import java.awt.Color;
import java.util.*;

public class Vec {
    
/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */



     
     public int length() ;
         
     
     

  
     public static void start() ;
         
     public static void end() ;
         
  
    /*__
     * *
     * axe X vector
     */
    public static final Vec X = new Point3D(1d, 0d, 0d);
    /*__
     * *
     * axe Y vector
     */
    public static final Vec Y = new Point3D(0d, 1d, 0d);
    /*__
     * *
     * axe Z vector
     */
    public static final Vec Z = new Point3D(0d, 0d, 1d);
    /*__
     * *
     * O0 origin
     */
    public static final Vec O0 = new Point3D(0d, 0d, 0d);
    /*__
     * *
     * Point "Infinite" limite pour Z-Buffer
     */
    public static final Vec INFINI = new Point3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    /*__
     * *
     * Pour le tracé de surface normale au point
     */
    protected Point3D normale;
    
    public static Vec n(int a, int b, int c) ;
    public static Vec n() ;
    public static Vec n(int dim) ;
    public static Vec n(double... d);
    public static Vec n(Double... d);
    
    
    /*__
     * *
     * Distance cartésienne entre 2 points
     *
     * @param p1 Point1
     * @param p2 Point2
     * @return
     */
    public static Double distance(Point3D p1, Point3D p2);
        


    public static Point3D random(Double d);
        
    public static Point3D random(Double d, int n) ;
        
    public static Point3D random2(Double d);

      
    @Override
    public Object clone();

    public Double get(int i);
       
    public Point3D scale() 

    public List<Double> getDoubleArray() ;


    public Point3D getNormale();
       
    

    public void setNormale(Point3D normale);
       
    

    public Double getY() ;
        
    

    public void setY(Double x0) ;
        

    
    public Double getZ() ;
        
    

    public void setZ(Double x0) ;
       

    
    public Double getX() ;
        
    

    public void setX(Double x0) ;
        

    


    public Point3D plus(Point3D p);
         
    
    public Point3D moins(Point3D p);

    /*__
     * *
     * Multiplication
     *
     * @param xFactor facteur
     * @return
     */

    public Point3D mult(Point3D p);
     public Point3D mult(double d) ;
    /*
     public vec mult(vec point3D) ;
       }*/
    /*__
     * *
     * norme d'un vecteur (distance du point à l'origine)
     *
     * @return
     */
    public Double norme() ;

    /*__
     * *
     * "direction" (norme1)
     *
     * @return Vecteur normalisé à 1
     */
    public Point3D norme1() ;

    /*__
     * *
     * Ajoute @param i à chaque coordonnée
     *
     * @param i
     * @return
     */
    public Point3D plus(Double d) ;

   

    /*__
     * *
     * Produit scalaire
     *
     * @param p2
     * @return
     */
    public Double prodScalaire(Point3D p2) ;

    /*__/*__
     * *
     * Produit scalaire
     *
     * @param p2
     * @return
     */
    public Double dot(Point3D p2) ;
     /* *
     * produit vectoriel
     *
     * @param p1
     * @return
     */
    public Point3D prodVect(Point3D p1) ;

    public void set(int i, Double d);

    public String toLongString();

    @Override
    public String toString() ;
    

    
    public Point2D get2D() ;
    public Point3D ord(int x, int y, int z) ;

    public void normalize() ;

    public Point2D to2DwoZ();

    public Double NormeCarree()
    @Override
    public boolean equals(Object p) ;
     }

    public Point3D changeTo(Point3D dst) ;
        

    public void declareProperties() ;

    
    public StructureMatrix<Double> getCoordArr() ;
        

    public void setCoordArr(StructureMatrix<Double> coordArr) ;
        
    
    
    /***
     * @param p double or array or matrix
     * copy<- * copy-> * add-> * <- mult .,* min max->
     * exp div set <- sub div  get sum fx? 
     * new start end 
    */
    public static int[] op(String po, int... p1);
        
                

}
