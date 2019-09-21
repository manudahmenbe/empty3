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
 * Created by Win on 26-01-16.
 */
public class Rotation {
    protected Matrix33 rot;
    protected Point3D centreRot;
    protected boolean unmodified = true;
    public Rotation() {
        if (isUnmodified())
        {
            rot  = new Matrix33(Matrix33.I);
            centreRot = new Point3D(Point3D.O0);
        }
    }
    public Rotation(Matrix33 rot, Point3D centreRot) {
        this.rot = rot;
        this.centreRot = centreRot;
    }

    public boolean isUnmodified() {
        return unmodified;
    }

    public void setUnmodified(boolean unmodified) {
        this.unmodified = unmodified;
    }

    public Point3D rotation(Point3D p ) {
        if(rot==null)
            rot = new Matrix33(Matrix33.I);
        if(centreRot==null)
            centreRot = p;
        if(p!=null) {
            return p.plus(centreRot).plus(rot.mult(p.scale()));
        }
        else return p;
    }

    public Point3D rotationAxe(Point3D p, int axe, double angle) {

        return Matrix33.rotationX(angle).mult(p);
    }

    public Point3D getCentreRot() {
        return centreRot;
    }

    public void setCentreRot(Point3D centreRot) {
        this.centreRot = centreRot;
    }

    public Matrix33 getRot() {
        return rot;
    }

    public void setRot(Matrix33 rot) {
        this.rot = rot;
    }
}
