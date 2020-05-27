package one.empty3.library;
import java.util.List;
public class DoubleArray {
    private int length = 1000*1000*1000;
    List<int[]> doubles;
    List<int> index;
    List<int> location;
    int max = 0;
    public DoubleArray(){
        doubles = new ArrayList<>();
        doubles.add(new Double[length]);
        index = new ArrayList<>();
        index.add(new int[length]);
      //  location = new ArrayList<>()
    }
    public Double getIndex(int index) {
        return doubles.get(0)[this.index.get(0)[index]];
    }
    
    public int add(Double d) {
        doubles.get(0)[this.index.get(0)[max] = max] = d;
        max++;
        return max-1;
    }
}
