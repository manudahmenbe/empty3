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

public class ZBufferFactory {

    private static ZBuffer insta = null;
    private static int la = -1, ha = -1;

    public static ZBuffer instance(int x, int y) {
        if (la == x && ha == y && insta != null) {
            return insta;
        }
        la = x;
        ha = y;
        insta = new ZBufferImpl(x, y);
        return insta;
    }

    public static ZBuffer instance(int x, int y, boolean D3) {
        if (la == x && ha == y && insta != null)//&& (D3 && insta instanceof ZBuffer3D || !D3))
        {
            return insta;
        }
        la = x;
        ha = y;
        if (D3) {
            // insta = new ZBuffer3DImpl(coordArr, y);
        } else {
            insta = new ZBufferImpl(x, y);
        }

        return insta;
    }

    public static ZBuffer instance(int x, int y, Scene s) {

        ZBuffer z = new ZBufferImpl(x, y);
        z.scene(s);
        return z;
    }
}
