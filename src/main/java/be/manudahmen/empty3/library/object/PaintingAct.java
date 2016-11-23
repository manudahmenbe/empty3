package be.manudahmen.empty3.library.object;

/**
 * Created by manue on 08-10-15.
 */
public abstract class PaintingAct {
    private ZBuffer ZBuffer;
    private Scene scene;
    private Representable objet;

    protected ZBuffer z() {

        return ZBuffer;
    }

    protected Scene s() {
        return scene;
    }

    protected Representable objet() {
        return objet;
    }

    public abstract void paint();

    protected Representable getObjet() {
        return objet;
    }

    public void setObjet(Representable objet) {
        this.objet = objet;
    }

    protected Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    protected ZBuffer getZBuffer() {
        return ZBuffer;
    }

    public void setZBuffer(ZBuffer zBuffer) {
        this.ZBuffer = zBuffer;
    }

}
