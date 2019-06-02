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

/*

 Vous êtes libre de :

 */
package one.empty3.library.core.tribase;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map.Entry;

@Deprecated
public abstract class BaseGenerator {

    protected BufferedImage buffer;
    protected Component comp;
    protected BufferedImage image;
    private int x;
    private int y;

    public BaseGenerator(int dx, int dy, Component c) {
        x = dx;
        y = dy;
        comp = c;
    }

    public void computeFrame() {
        // TODO Auto-generated method stub

    }

    public Image getBUFFER() {
        return buffer;
    }

    public Graphics getGraphicsDisque() {
        return image.getGraphics();
    }

    public Graphics getGraphicsEcran() {
        return comp.getGraphics();
    }

    public void initFrame() {
        // TODO Auto-generated method stub

    }

    public void paint() {
        comp.getGraphics().drawImage(buffer, 0, 0, x, y, null);
        image.getGraphics().drawImage(buffer, 0, 0, x, y, null);
    }

    public void renew() {
        image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
    }

    public void save() {
    }

    public void setConfig(Config params) {
        for (Entry<String, Object> entry : params.entrySet()) {
            if (entry.getKey().startsWith("global") | entry.getKey().startsWith(this.getClass().getSimpleName())) {
                setField(entry.getKey().substring(
                        entry.getKey().indexOf(".") + 1,
                        entry.getKey().indexOf("=")),
                        entry.getKey().substring(
                                entry.getKey().indexOf("="))
                );
            }
        }

    }

    private void setField(String key, String stringvalue) {

    }

    public void setParams(Params params) {
        // TODO Auto-generated method stub

    }

    public void showFrame() {
        // TODO Auto-generated method stub

    }
}
