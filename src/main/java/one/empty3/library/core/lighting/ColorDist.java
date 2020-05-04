package one.empty3.library.core.lighting;
import java.awt.Color;
public class ColorDist implements Comparable {
        public Color color;
        public double dist;
        
        public int compareTo(Object o) {
            if (o instanceof ColorDist) {
                ColorDist cd = (ColorDist) o;
                return dist<cd.dist?-1:(dist==cd.dist?0:1);
           } else 
                return 0;//throw??
        }
    }
