package one.empty3.library.core.lighting;
import one.empty3.library.*;
import java.awt.Color;

public class Light {
      private double La;
      private double Ld;
      private double Ls;
      private Point3D source;
      private double f = 0;
      private double [] levels;

      public Light(double Ka, double Ld, double Ks, Point3D source, double f, double[] levels) {

      }

      public static float[] fromColor(
            Color c) {
            return new float[] {c.getRed(),
                c.getGreen(),c.getBlue(),
                c.getAlpha()};
      }
      public Point3D c2p(float [] c) {
          /*new Point3D((double)c.getRed(),
                (double)c.getGreen(),(double).getBlue(),
              );//  (double)c.getAlpha());
*/
      
          return new Point3D((double)cs[3],

              (double)cs[2],(double)cs[1] , (double)cs[0]);
      }
      public double level(double angle) {
           if(levels==null)
               return angle;
      }
      public int [] getColorArray(int c) {
          return new int[] {
              c&0xff000000>>24&0xff,
              c&0x00ff0000>>16&0xff,
              c&0x0000ff00>>8&0xff,
              c&0x000000ff>>0&0xff
            };
      }
      public int getColorInt(int [] colors) {
           return colors[2]<<24+colors[1]<<16+
              colors[0]>>8+colors[3];
      }
      public Color getColor(int c) {
           return new Color(c);
      }
      public Color getColor(int [] c) {
          return new Color(c[3],c[2],c[1],c[0]);
      }
      //public abstract Light();

      public float[] compColor(float[] c, Camera cam, Material m, Point3D p, Point3D n) {
           Point3D cp = c2p(c);
           Point3D eye = cam.getEye();
           Point3D Ia = cp.mult(La*m.getKa());
            
           Point3D s = (source.moins(p).norme1());
           Point3D v = (eye.moins(p).norme1());
           Point3D Id =  cp.mult(Ld*m.getKd()*(s.dot(n)));
           Point3D r = s.mult(-1.).plus(n.mult(2.*s.dot(n)));
           
           Point3D Is = cp.mult( Ls*m.getKs()*Math.pow((r.dot(v)), f));
           Point3D It = Ia.plus(Id).plus(Is);
           return new float[]{(float)(double)(It.get(3)), (float)(double)(It.get(2)),
                            (float)(double)(It.get(1)),(float)(double)(It.get(0))};

      }
}
