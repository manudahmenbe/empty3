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
public class AnimationGenerator extends Thread {

    private final Animation animation;

    public AnimationGenerator(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }

}
