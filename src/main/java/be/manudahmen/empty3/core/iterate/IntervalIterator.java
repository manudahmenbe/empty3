package be.manudahmen.empty3.core.iterate;

/**
 * Created by Win on 10-01-19.
 */
public class IntervalIterator {
    public int dim;
    public double[] xmin;
    public double[] xmax;
    public int[] incr;
    public int currentDim;
    public double[] currentCordinates;

    public IntervalIterator() {
    }

    /***
     * Réfléchir surface et caméra en plus
     * pas 1 -1 et lsystem
     * @param step
     */
    public void iterate11(int[] step) {

    }

    public boolean next() throws InvalidObjectConfiguration {
        currentCordinates[currentDim] += incr[currentDim];
        if (currentCordinates[currentDim] > xmax[currentDim]) {
            currentCordinates[currentDim] = xmin[currentDim];
            currentDim++;
        }
        if (currentDim >= currentCordinates.length) {
            currentDim = 0;
            return false;
        } else {
            return true;

        }
    }
}
