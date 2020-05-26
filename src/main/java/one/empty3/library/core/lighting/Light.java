package one.empty3.library.core.lighting;

import java.awt.Color;

public class Light {
      private double La;
      private double Ld;
      private double Ls;
      private Point3D source;
      private int [] levels;
      public int [] getColorArray(int c) {
          return new int[] {
              c&0xff000000>>24,
              c&0x00ff0000>>16,
              c&0x0000ff00>>8
              c&0x000000ff>>0
            }
      }
      public int getColorInt(int [] colors) {
           return colors[3]<<24+colors[2]<<16+
              colors[1]>>8+colors[0];
      }
      public Color getColor(int c) {
           return new Color(c);
      }
      public Color getColor(int [] c) {
          return getColorInt(c);
      public abstract Light();

      public int compColor(int c, Point3D p, Point3D n, Camera c)) {
           return c;

      }
}
