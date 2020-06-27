package one.empty3.library;
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
import one.empty3.library.core.nurbs.ParametricCurve;
import one.empty3.library.core.nurbs.ParametricSurface;
import java.awt.Color;
import java.util.*;


public class vec extends Representable {
     public static DoubleArray da;
     private int arrayNo;
     private int start;
     private int n;
     private boolean disposable;
     public int length() {
         return n;
     }

     private vec() {
         
         super();
         
         if(da==null)
              da = new DoubleArray(10, 10000);
         
     }

     public vec(int n) {
          start = da.addDoubles(n);
          this.n = n;
     }
     public vec(double x, double y, double z) {
          this(3);
          da.setDoubles(start, x, y, z);
     }

     public vec(double x, double y, double z,
         double t) {
          this(4);
          da.setDoubles(start, x, y, z, t);
     }
     public vec(vec v1, double... c) {
         this(v1.length()+c.length);
         int i; int j=0;
         for( i=start; i<start+n; i++)
             da.setDoubles(i, v1.get(j++));
         for(double d : c) {
             da.setDoubles(j++, d);
             i++;
         }
             
     }
     public vec(vec... v) {
         this();
         int i;
         int m = v.length;
         for(i=0; i<m; i++) 
             n+= v[i].length();
         start = da.addDoubles(n);
         i=0;
         int j = 0;
         int k = 0;
         for(i=start; i<start+n; i++) {
             da.setDoubles(i, v[j].get(k));
             k++;
             if(k>=v[j].length()) {
                 k=0;
                 j++;
             } else
                 k++;
         }
     }


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

   
    /*__
     * *
     * axe X vector
     */
    public static final vec X = new vec(1d, 0d, 0d);
    /*__
     * *
     * axe Y vector
     */
    public static final vec Y = new vec(0d, 1d, 0d);
    /*__
     * *
     * axe Z vector
     */
    public static final vec Z = new vec(0d, 0d, 1d);
    /*__
     * *
     * O0 origin
     */
    public static final vec O0 = new vec(0d, 0d, 0d);
    /*__
     * *
     * Point "Infinite" limite pour Z-Buffer
     */
    public static final vec INFINI = new vec(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    /*__
     * *
     * Pour le tracé de surface normale au point
     */
    protected vec normale;
    /*__
     * *
     * id
     */

    /*__
     * *
     * Constructeur Point Origine
     */
    /*__
     * *
     *
     * @param x0 coordArr-coordonnée
     * @param y0 y-coordonnée
     * @param z0 z-coordonnée
     */
    public vec(Double x0, Double y0, Double z0) {
        super();
        set( 0, z0);
        set(1, y0);
        set(2, z0);
 }
    /*__
     * *
     *
     * @param x0 coordArr-coordonnée
     * @param y0 y-coordonnée
     * @param z0 z-coordonnée
     */
    public vec(Double x0, Double y0, Double z0, ITexture t) {
        this(x0, y0, z0);
        texture(t);
    }

    /*__
     * *
     * Initialise à partir d'un vecteur
     *
     * @param x0 coordonnées (>3)
     */
    public vec(Double... x0) {
        int i=0;
        for(Double d : x0) {
           set(i, d);
           i++;
        }
    }

    public vec(Double[] x0, ITexture t) {
        int i=0;
        for(Double d : x0) {
         set(i, d);
         i++;
        }
        texture(t);
    }
    /*__
     *
     *
     * @param p0 point à copier
     */
    public vec(vec p0) {
        this(p0.length());
        for(int i=0; i<p0.length(); i++)
            set(i, p0.get(i));
        texture(p0.texture);
    }

    public vec(StructureMatrix<Double> coordArr) {
        this(coordArr.data1d.size());
        for(int i= 0; i<n; i++)
            set(i, coordArr.data1d.get(i));
    }

    public static vec n(Double a, Double b, Double c) {
        return new vec(a, b, c);
    }

    /*__
     * *
     * Distance cartésienne entre 2 points
     *
     * @param p1 Point1
     * @param p2 Point2
     * @return
     */
    public static Double distance(vec p1, vec p2) {
        double d = 0.0;
        for(int i=0; i<p1.length(); i++)
            d+=(p1.get(i)-p2.get(i))*(p1.get(i)*p2.get(i));
        return Math.sqrt(d);
   }



    public static vec random(Double d) {
        return new vec(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5).mult(d * 2);
    }
public static vec random(Double d, int n) {
        
        return new vec(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5).mult(d * 2);
    }
    public static vec r(Double d) {
        return random(d);
    }

    public static vec random2(Double d) {

        return new vec(((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d));
    }

    @Override
    public Object clone() {
        return new vec(this);
    }

    public Double get(int i) {
       // if(i>=0 && i<3 && coordArr.data1d.size()==3)
            return da.getDouble(start+ i);
       /* else
            try {
                throw new Throwable("vec coordArr out of bounds or array dim error\nValues="+coordArr.toString()+"\nSize="+coordArr.data1d.size());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        return Double.NaN;*/
    }
    public vec scale() {
        if(scale==null)
        {
            return this;
        }
         return new vec(get(0)*scale.get(1),get(1)*scale.get(1),get(2)*scale.get(2));
    }

    public List<Double> getDoubleArray() {
        List<Double> coordArr = new ArrayList<>();
        for(int i = 0; i<n; i++)
            coordArr.add(get(i));
        return coordArr;
    }


    public vec getNormale() {
        return normale;
    }

    public void setNormale(vec normale) {
        this.normale = normale;
    }

    public Double getY() {
        return get(1);
    }

    public void setY(Double x0) {
        set( 1, x0);

    }
    public Double getZ() {
        return get(2);
    }

    public void setZ(Double x0) {
        set(2, x0);

    }
    public Double getX() {
        return get(0);
    }

    public void setX(Double x0) {
        set(0, x0);

    }


    public vec plus(vec p){
        vec p1 = new vec(this);
        for(int i=0;i<n; i++)
            p1.set(i, get(i)+p.get(i));
        
        return p1;
    }
    
    public vec moins(vec p) {
        vec p1 = new vec(this);
        for(int i=0;i<n; i++)
            p1.set(i, get(i)-p.get(i));
        
        return p1;
    }

    /*__
     * *
     * Multiplication
     *
     * @param xFactor facteur
     * @return
     */

    public vec mult(Point3D p) {
        vec p1 = new vec(this);
        for(int i=0;i<n; i++)
            p1.set(i, get(i)*p.get(i));
        
        return p1;
 }
public vec mult(double d) {
        vec p1 = new vec(this);
        for(int i=0;i<n; i++)
            p1.set(i, get(i)*d);
        
        return p1;
}
    /*
     public vec mult(vec point3D) {
        return Matrix33.YZX.mult(Matrix33.ZXY.mult(Matrix33.XYZ.mult(point3D)));
       }*/
    /*__
     * *
     * norme d'un vecteur (distance du point à l'origine)
     *
     * @return
     */
    public Double norme() {
        double n = 0.0;
        for(int i=0; i<n; i++)
            n+= get(i)*get(i);
        return Math.sqrt(n);
    }

    /*__
     * *
     * "direction" (norme1)
     *
     * @return Vecteur normalisé à 1
     */
    public vec norme1() {
        return mult(1 / norme());
    }

    /*__
     * *
     * Ajoute @param i à chaque coordonnée
     *
     * @param i
     * @return
     */
    public vec plus(Double d) {
        vec p = new vec(this);
        for(int i=0; i<n; i++)
            p.set(i, get(i)+d);
        return p;
    }

   

    /*__
     * *
     * Produit scalaire
     *
     * @param p2
     * @return
     */
    public Double prodScalaire(vec p2) {
        double s = 0.0;
        if(p2!=null) {
            for(int i=0; i<n; i++)
            s +=get(i) * p2.get(i);
        }
        else
            throw new NullPointerException("Exception prodScalre p2==null");
        return s;
    }

    /*__/*__
     * *
     * Produit scalaire
     *
     * @param p2
     * @return
     */
    public Double dot(vec p2) {
        return this.prodScalaire(p2);
    }

     /* *
     * produit vectoriel
     *
     * @param p1
     * @return
     */
    public vec prodVect(vec p1) {
        return new vec(p1.getY() * getZ() + -p1.getZ() * getY(), p1.getZ()
                * getX() - p1.getX() * getZ(), p1.getX() * getY() - p1.getY()
                * getX());
    }

    public void set(int i, Double d) {
        da.setDoubles(start+ i, d);

    }

    public String toLongString() {
        String s = "p ( \n\t(";
        for(int i = start; i<start+n; i++) {
             s+= get(i);
             if(i<start+n)
                  s += ", ";
        }
        s += " )\n\t("
                + texture.toString()
                + ")\n)\n";
        return s;
    }

    @Override
    public String toString() {
        return toLongString();
    }

    @Override
    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
         return false;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {

      

    }

    public Point2D get2D() {
        return new Point2D(get(0), get(1));
    }

    public void normalize() {
        Double n = norme();
        for (int i = 0; i < n; i++)
            set(i, get(i) / n);
    }

    public Point2D to2DwoZ() {
        return get2D();
    }

    public Double NormeCarree() {
        return norme()*norme();
    }



    public vec changeTo(vec dst) {
        for (int i = 0; i < 3; i++)
            this.set(i, dst.get(i));

        texture(dst.texture());
        return this;
    }

    public static vec n(double i, double i1, double i2) {
        return new vec(i, i1, i2);
    }



  



    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("coordArr/coordonnées", null);
    }
/*
    public Double get(int i) {
        return i<coordArr.data1d.size()?coordArr.getElem(i):Double.NaN;
    }*/
    public StructureMatrix<Double> getCoordArr() {
        StructureMatrix<Double> coordArr = new StructureMatrix<>(1, Double.class);
         for(int i= 0; i<n; i++)
            coordArr.data1d.add(get(i));
         return null;
    }

    public void setCoordArr(StructureMatrix<Double> coordArr) {
        for(int i= 0; i<n; i++)
            set(i, coordArr.data1d.get(i));
    }
/*
    
    
    
    public vec statOp(vec p, char po, int length){
        switch(po) {
                case '+':
                for(int i=0; i<n; i++)
                     set(i,get(i)+p.get(i));
                break;
                case '-':
                    for(int i=0; i<n; i++)
                        set(i, coordArr.getElem(i)-p.get(i));
                break;
                    case '*':
                        
        for(int i=0; i<n; i++)
              set( i,  get(i)*p.get(i));
                break;
                    case '/':
                
        for(int i=0; i<n; i++)
              set(i, get(i)/p.get(i));
                break;
                case '.':
                double sum = 0.0;
                for(int i=0; i<n; i++)
              
                  sum += get(i)*p.get(i);
                   set(0, sum);
                break;
                }
           
        
        return this;
    }*/


}
