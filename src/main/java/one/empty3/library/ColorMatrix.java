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
package one.empty3.library;

public class ColorMatrix<E> extends Representable {

    /**
     *
     */
    private static final long serialVersionUID = 8229059930778672554L;
    private String id;
    private Point3D[] nodes;
    private My2DarrayColor colors;
    private E[] elements;
    private Point3D[] interpolate;
    private int dimx;
    private int dimy;

    public ColorMatrix(int dimx, int dimy) {
        super();
        this.dimx = dimx;
        this.dimy = dimy;
    }

    public My2DarrayColor getColors() {
        return colors;
    }

    public void setColors(My2DarrayColor colors) {
        this.colors = colors;
    }

    public int getDimx() {
        return dimx;
    }

    public void setDimx(int dimx) {
        this.dimx = dimx;
    }

    public int getDimy() {
        return dimy;
    }

    public void setDimy(int dimy) {
        this.dimy = dimy;
    }

    public E[] getElements() {
        return elements;
    }

    public void setElements(E[] elements) {
        this.elements = elements;
    }

    public Point3D[] getInterpolate() {
        return interpolate;
    }

    public void setInterpolate(Point3D[] interpolate) {
        this.interpolate = interpolate;
    }

    public Point3D[] getNodes() {
        return nodes;
    }

    public void setNodes(Point3D[] nodes) {
        this.nodes = nodes;
    }

}
