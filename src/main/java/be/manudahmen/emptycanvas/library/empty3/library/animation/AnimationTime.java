/**
 * *
 * Global license : * CC Attribution
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.animation;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class AnimationTime {
    protected long temps;
    int fpsDest = 25;

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

    public void setFpsDest(int fpsDest) {
        this.fpsDest = fpsDest;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }

    public long getTime() {
        return temps;
    }

    public double getTimeInSeconds() {
        return temps / 1000.0;
    }

}
