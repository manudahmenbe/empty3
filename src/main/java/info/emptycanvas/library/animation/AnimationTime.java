/**
 * *
 * Global license : * CC Attribution
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package info.emptycanvas.library.animation;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class AnimationTime {
    int fpsDest = 25;
    protected long temps;
    
    public AnimationTime(double tempsSecondes) {
        this.temps = (long) (tempsSecondes * 1000.0);
    }

    public AnimationTime(long temps) {
        this.temps = temps;
    }

    public void avanceUneFrame() {
        temps += 1000 / fpsDest;
    }

    public int getFpsDest() {
        return fpsDest;
    }

    public long getTemps() {
        return temps;
    }

    public long getTime() {
        return temps;
    }

    public double getTimeInSeconds() {
        return temps / 1000.0;
    }

    public void setFpsDest(int fpsDest) {
        this.fpsDest = fpsDest;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }

}
