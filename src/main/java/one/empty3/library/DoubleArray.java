package one.empty3.library;
import java.util.List;
public class DoubleArray {
    List<Double[]> doubles;
    List<Integer> index;
    List<Integer> free;
    public DoubleArray(){
        doubles = new ArrayList<>();
        doubles.add(new Double[1000*1000*1000]);
    
    }
}
