/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package one.empty3.library;

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
