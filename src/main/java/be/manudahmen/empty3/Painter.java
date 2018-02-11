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

package be.manudahmen.empty3;

/**
 * Created by manuel Dahmen manuel.dahmen@gmail.com on 08-10-15.
 */

/***
 * Destinée à concevoir des actions de dessin spécifiques à certaines formes d'un type général Representable.
 * <p/>
 * Par exemple : au lieu de tracer un maillage de surface (action par défaut) dessiner des points aléatoirement
 * sur la surface.
 */
public class Painter {
    private final ZBuffer z;
    private Scene scene;
    private PaintingAct pa;
    private Representable r;
    private Class c;

    public Painter(ZBuffer z, Scene scene) {
        this.z = z;

        this.scene = scene;
    }

    public Painter(ZBuffer z, Scene scene, Representable r) {
        this.z = z;
        this.r = r;
        this.c = r.getClass();
        this.scene = scene;
    }

    public Painter(ZBuffer z, Scene scene, Class<Representable> c) {
        this.z = z;
        this.c = c;
        this.scene = scene;
    }

    public void addAction(PaintingAct pa) {
        this.pa = pa;
        pa.setObjet(r);
        pa.setZBuffer(z);
        pa.setScene(scene);
    }

    public PaintingAct getPaintingAct() {
        return pa;
    }
}
