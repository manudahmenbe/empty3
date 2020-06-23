package one.empty3.library;
import java.util.*;
/**
* mettre dans des espaces et les supprimer
* quand ils sont vides.
*/
public class DoubleArray {
    private int length = 1000*1000;
    List<Double[]> doubles;
    List<Integer[]> index;
    int spaces;
    boolean [] freeSpace;
    int max = 0;
    public DoubleArray(int spaces, int spaceLength){
        freeSpace = new boolean[spaces];
        this.spaces = spaces;
        doubles = new ArrayList<>();
        doubles.add(new Double[spaceLength]);
        index = new ArrayList<>();
        index.add(new Integer[spaceLength]);
      //  location = new ArrayList<>()
    }
    public void clear() {
         for(int i=0; i<index.size(); i++) {
             int j = 0;
             boolean isEmpty = true;
             while(j<index.get(i).length) {
                 if(index.get(i)[j]!=0) {
                     isEmpty = false;
                     break;
                 }
             }
             if(isEmpty) { 
                 freeSpace[i] = true;
             }
         }
    }
    public Double getDouble(int index) {
        return doubles.get(0)[this.index.get(0)[index]];
    }
    public Double getDouble(int index, int n) {
        return doubles.get(0)[this.index.get(0)[index]+n];
    }
    
    public int add(Double d) {
        int start = max;
        doubles.get(0)[this.index.get(0)[max] = max] = d;
        max++;
        return start;
    }
    public int addDoubles(Double... ds) {
        int start = max;
        for (int i = 0; i<ds.length ; i++) {
            doubles.get(0)[this.index.get(0)[max] = max] = ds[i];
            max++;
        }
        return start;
        
    }
    public int addDoubles(int n) {
        int start = max;
        for (int i = 0; i<n ; i++) {
            doubles.get(0)[this.index.get(0)[max] = max] = 0.0;
            max++;
        }
        return start;
    }
}
