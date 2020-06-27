package one.empty3.library;
public class vec extends Representable {
     public static DoubleArray da;
     private int arrayNo;
     private int start;
     private int n;
     private boolean disposable;
     public int length() {
         return n;
     }
     public vec(double x, double y, double z) {
          n = 3;
          start = da.addDoubles(n);
          da.setDoubles(start, x, y, z);
     }

     public vec(double x, double y, double z,
         double t) {
          n = 4;
          start = da.addDoubles(n);
         
          da.setDoubles(start, x, y, z, t);
     }
     public vec(vec v1, double... c) {
     }
     public vec(vec... v) {
     }
     public vec(double d, vec ... c) {
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
    public static final vec X = new Point3D(1d, 0d, 0d);
    /*__
     * *
     * axe Y vector
     */
    public static final vec Y = new Point3D(0d, 1d, 0d);
    /*__
     * *
     * axe Z vector
     */
    public static final vec Z = new Point3D(0d, 0d, 1d);
    /*__
     * *
     * O0 origin
     */
    public static final vec O0 = new Point3D(0d, 0d, 0d);
    /*__
     * *
     * Point "Infinite" limite pour Z-Buffer
     */
    public static final vec INFINI = new Point3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    /*__
     * *
     * Coordonnées (coordArr,y,z) du point
     */
    StructureMatrix<Double> coordArr = new StructureMatrix<>(1, Double.class);
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
        coordArr.setElem(x0, 0);
        coordArr.setElem(y0, 1);
        coordArr.setElem(z0, 2);
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
         coordArr.setElem(d,i);
         i++;
        }
    }

    public vec(Double[] x0, ITexture t) {
        int i=0;
        for(Double d : x0) {
         coordArr.setElem(d,i);
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
        super();
        for(int i=0; i<p0.getCoordArr().data1d.size(); i++)
            coordArr.setElem(p0.get(i), i);
        texture(p0.texture);
    }

    public vec(StructureMatrix<Double> coordArr) {
        this(coordArr.getElem(0), coordArr.getElem(1), coordArr.getElem(2));
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
    public static Double distance(Point3D p1, Point3D p2) {
        double d = 0.0;
        for(int i=0; i<p1.getCoordArr().getData1d().size(); i++)
            d+=(p1.get(i)-p2.get(i))*(p1.get(i)*p2.get(i));
        return Math.sqrt(d);
   }



    public static vec random(Double d) {
        return new Point3D(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5).mult(d * 2);
    }
public static vec random(Double d, int n) {
        
        return new Point3D(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5).mult(d * 2);
    }
    public static vec r(Double d) {
        return random(d);
    }

    public static vec random2(Double d) {

        return new vec(((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d), ((Math.random() - 0.5) * 2 * d));
    }

    @Override
    public Object clone() {
        return new Point3D(coordArr);
    }

    public Double get(int i) {
       // if(i>=0 && i<3 && coordArr.data1d.size()==3)
            return coordArr.getElem(i);
       /* else
            try {
                throw new Throwable("point3D coordArr out of bounds or array dim error\nValues="+coordArr.toString()+"\nSize="+coordArr.data1d.size());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        return Double.NaN;*/
    }
    public vec scale() {
        if(scale==null)
        {
            return Point3D.n(1.,1.,1.);
        }
         return new Point3D (get(0)*scale.get(1),get(1)*scale.get(1),get(2)*scale.get(2));
    }

    public List<Double> getDoubleArray() {
        return coordArr.getData1d();
    }


    public vec getNormale() {
        return normale;
    }

    public void setNormale(vec normale) {
        this.normale = normale;
    }

    public Double getY() {
        return coordArr.getElem(1);
    }

    public void setY(Double x0) {
        coordArr.setElem(x0, 1);

    }
    public Double getZ() {
        return coordArr.getElem(2);
    }

    public void setZ(Double x0) {
        coordArr.setElem(x0, 2);

    }
    public Double getX() {
        return coordArr.getElem(0);
    }

    public void setX(Double x0) {
        coordArr.setElem(x0, 0);

    }


    public Point3D plus(vec p){
        vec p1 = new vec(this);
        for(int i=0;i<coordArr.data1d.size(); i++)
            p1.set(i, get(i)+p.get(i));
        
        return p1;
    }
    
    public vec moins(vec p) {
        vec p1 = new vec(this);
        for(int i=0;i<coordArr.data1d.size(); i++)
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
        for(int i=0;i<coordArr.data1d.size(); i++)
            p1.set(i, get(i)*p.get(i));
        
        return p1;
 }
public vec mult(double d) {
        vec p1 = new Point3D(this);
        for(int i=0;i<coordArr.data1d.size(); i++)
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
        for(int i=0; i<coordArr.getData1d().size(); i++)
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
        for(int i=0; i<coordArr.getData1d().size(); i++)
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
            for(int i=0; i<coordArr.getData1d().size(); i++)
            s +=coordArr.getElem(0) * p2.getX() + coordArr.getElem(1) * p2.getY() + coordArr.getElem(2) * p2.getZ();
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
        return new Point3D(p1.getY() * getZ() + -p1.getZ() * getY(), p1.getZ()
                * getX() - p1.getX() * getZ(), p1.getX() * getY() - p1.getY()
                * getX());
    }

    public void set(int i, Double d) {
        coordArr.setElem(d, i);

    }

    public String toLongString() {
        //Color c = texture.toString();
        return "p ( \n\t(" + coordArr.getElem(0) + " , " + coordArr.getElem(1)+ " , " + coordArr.getElem(2)+ " )\n\t("
                + texture.toString()
                + ")\n)\n";
    }

    @Override
    public String toString() {
        return "\n\tp3( " + (Double) (coordArr.getElem(0)) + " , " + (Double) (coordArr.getElem(1)) + " , " + (Double) (coordArr.getElem(2)) + " ) ";
    }

    @Override
    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return super.ISdrawStructureDrawFastIMPLEMENTED(z); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {

        z.testDeep(this, new Color(CFAST.getColorAt(0.5, 0.5)));

    }

    public Point2D get2D() {
        return new Point2D(coordArr.getElem(0), coordArr.getElem(1));
    }

    public void normalize() {
        Double n = norme();
        for (int i = 0; i < coordArr.getData1d().size(); i++)
            set(i, get(i) / n);
    }

    public Point2D to2DwoZ() {
        return get2D();
    }

    public Double NormeCarree() {
        return coordArr.getElem(0)* coordArr.getElem(0)+ coordArr.getElem(1)* coordArr.getElem(1)+ coordArr.getElem(2)* coordArr.getElem(2);
    }



    public vec changeTo(vec dst) {
        for (int i = 0; i < 3; i++)
            this.coordArr.setElem(dst.coordArr.getElem(i),i);

        texture(dst.texture());
        return this;
    }

    public static vec n(double i, double i1, double i2) {
        return new vec(i, i1, i2);
    }

    public double getLength() {
        return norme();
    }


  



    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("coordArr/coordonnées", coordArr);
    }
/*
    public Double get(int i) {
        return i<coordArr.data1d.size()?coordArr.getElem(i):Double.NaN;
    }*/
    public StructureMatrix<Double> getCoordArr() {
        return coordArr;
    }

    public void setCoordArr(StructureMatrix<Double> coordArr) {
        this.coordArr = coordArr;
    }
/*
    public Point3D calculerPoint0dT(double t) {
        return this;
    }
    
    
    public Point3D statOp(Point3D p, char po, int length){
        switch(po) {
                case '+':
                for(int i=0; i<3; i++)
             coordArr.setElem(i,coordArr.getElem(i)+p.get(i));
                break;
                case '-':
                    for(int i=0; i<3; i++)
              coordArr.setElem( coordArr.getElem(i)-p.get(i));
                break;
                    case '*':
                        
        for(int i=0; i<3; i++)
              coordArr.setElem( i,  coordArr.getElem(i)*p.get(i));
                break;
                    case '/':
                
        for(int i=0; i<3; i++)
              coordArr.setElem(i,
            coordArr.getElem(i)/p.get(i));
                break;
                case '.':
                double sum = 0.0;
                for(int i=0; i<3; i++)
              
                  sum += coordArr.getElem(i)*p.get(i);
                coordArr.setElem(0, sum);
                break;
                }
           
        
        return this;
    }*/
}

}
