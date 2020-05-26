package one.empty3.library.core.lighting;
import one.empty3.library.*;
import java.awt.Color;

public class Light {
      private double La;
      private double Ld;
      private double Ls;
      private Point3D source;
      private double [] levels;
      public Point3D c2p(int c) {
          return /*new Point3D((double)c.getRed(),
                (double)c.getGreen(),(double).getBlue(),
              );//  (double)c.getAlpha());
*/
          int [] cs = getColorArray(c);
          return new Point3D((double)cs[2],

              (double)cs[1],(double)cs[0]);
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
            }
      }
      public int getColorInt(int [] colors) {
           return colors[2]<<24+colors[1]<<16+
              colors[0]>>8+colors[3];
      }
      public Color getColor(int c) {
           return new Color(c);
      }
      public Color getColor(int [] c) {
          return getColorInt(c);
      public abstract Light();

      public int compColor(int c, Point3D p, Point3D n, Camera c)) {
           Point3D c = c2p(c);
Point3D eye = c.eye();
           return c;

      }
}
