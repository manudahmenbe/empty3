package be.manudahmen.emptycanvas.library.empty3.library.animation;

import be.manudahmen.emptycanvas.library.empty3.library.object.Representable;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         14 déc. 2011
 */
public class AnimationMouvements {

    private Animation animation;
    private Fonction fonction;
    private Representable representable;

    public AnimationMouvements(Representable representable, FonctionTemps fp) {
        this.representable = representable;
        fonction = fp;
    }

    protected void setFonctionModele(FonctionModele fm) {
        this.fonction = fm;
    }

    protected void setFonctionPosition(FonctionTemps fp) {
        this.fonction = fp;
    }

    public void updateObject(AnimationTime time) {

    }
}
