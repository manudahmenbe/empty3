package one.empty3.library.core.lighting;
import java.util.*;
import java.awt.Color;
public class ColorDist {
        public Color color;
        public double dist;
        /*
        public int compareTo(Object o) {
            if (o instanceof ColorDist) {
                ColorDist cd = (ColorDist) o;
                return dist<cd.dist?-1:(dist==cd.dist?0:1);
           } else 
                return 0;//throw??
        }
        */
        public static void sort(ColorDist[] cd) {
            Arrays.sort(cd, new SortbyDist());
        }
    }
class SortbyDist implements Comparator<ColorDist> 
{ 

    // Used for sorting in ascending order of 

    // roll number 

    public int compare(ColorDist a, ColorDist b) 

    { 

      return Double.compare(a.dist, b.dist);


    } 
} 
