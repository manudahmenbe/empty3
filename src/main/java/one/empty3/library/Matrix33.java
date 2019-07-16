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

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         17 nov. 2011
 */
public class Matrix33 extends Representable{

    public static final Matrix33 XYZ;
    public static final Matrix33 YZX;
    public static final Matrix33 ZXY;
    public static final Matrix33 I;
    /**
     *
     */
    private static final long serialVersionUID = 7007460681652570657L;

    static {
        XYZ = new Matrix33(new Double[]{1d, 0d, 0d, 0d, 1d, 0d, 0d, 0d, 1d});
        YZX = new Matrix33(new Double[]{0d, 1d, 0d, 0d, 0d, 1d, 1d, 0d, 0d});
        ZXY = new Matrix33(new Double[]{0d, 0d, 1d, 1d, 0d, 0d, 0d, 1d, 0d});
        I = new Matrix33(new Double[]{1d, 0d, 0d, 0d, 1d, 0d, 0d, 0d, 1d});

    }

    private Double[] d;

    public Matrix33(Matrix33 copy) {
        d = copy.d.clone();
        getDeclaredArray1dDouble().put("d/3x3 matrix", d);
    }

    public Matrix33() {
        d = new Double[9];
        getDeclaredArray1dDouble().put("d/3x3 matrix", d);

    }

    public Matrix33(Double[] d) {
        if (d.length != 9) {
            System.out.println("Erreur dans Matrix33 . 9 éléments requis");
            System.exit(-1);
        }
        this.d = d;
        getDeclaredArray1dDouble().put("d/3x3 matrix", d);
    }

    public Matrix33(Point3D[] p) {
        this();
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                d[j * 3 + i] = p[i].get(j);

            }
        }
        getDeclaredArray1dDouble().put("d/3x3 matrix", d);
    }

    public static Matrix33 rot(double a, double b) {
        return new Matrix33(
                new Double[]{
                        Math.cos(a), Math.sin(b), 0d,
                        -Math.sin(a), Math.cos(b), 0d,
                        0d, 0d, 1d

                }
        );
    }

    public static Matrix33 rotationX(double a) {
        return new Matrix33(
                new Double[]{1d, 0d, 0d,
                        Math.cos(a), -Math.sin(a), 0d,
                        Math.sin(a), Math.cos(a), 0d}).tild();
    }

    public static Matrix33 rotationY(double a) {
        return new Matrix33(
                new Double[]{Math.cos(a), 0d, Math.sin(a),
                        0d, 1d, 0
                        - Math.sin(a), 0d, Math.cos(a)}).tild();
    }

    public static Matrix33 rotationZ(double a) {
        return new Matrix33(
                new Double[]{Math.cos(a), -Math.sin(a), 0d,
                        Math.sin(a), Math.cos(a), 0d,
                        0d, 0d, 1d}).tild();
    }

    public double get(int i, int j) {
        return d[i * 3 + j];
    }

    public Double[][] getDoubleArray() {
        Double[][] d2 = new Double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                d2[i][j] = get(i, j);
            }
        }
        return d2;
    }

    public Matrix33 inverse() {
        return this;
    }

    public Matrix33 mult(Matrix33 mult) {
        Matrix33 r = new Matrix33();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double d0 = 0;
                for (int k = 0; k < 3; k++) {
                    d0 += get(i, k) * get(k, j);
                }
                r.set(i, j, d0);
            }
        }
        return r;
    }

    public Point3D mult(Point3D p) {
        return rotation(p);
    }

    public Matrix33 mult(double f) {
        Matrix33 mres = new Matrix33(this);

        for (int i = 0; i < d.length; i++) {
            mres.d[i] *= f;
        }
        return mres;
    }

    public Matrix33 plus(Matrix33 m) {
        Matrix33 mres = new Matrix33(this);

        for (int i = 0; i < d.length; i++) {
            mres.d[i] += m.d[i];
        }
        return mres;
    }

    public Matrix33 moins(Matrix33 m) {
        Matrix33 mres = new Matrix33(this);

        for (int i = 0; i < d.length; i++) {
            mres.d[i] -= d[i];
        }
        return mres;
    }

    public Point3D rotation(Point3D p) {
        Point3D pa = new Point3D();
        for (int i = 0; i < 3; i++) {
            double d0 = 0;
            for (int j = 0; j < 3; j++) {
                d0 += this.get(i, j) * p.get(j);
            }
            pa.set(i, d0);
        }
        return pa;
    }

    public void set(int i, int j, double d0) {
        d[i * 3 + j] = d0;
    }

    public void set(int i, Point3D p) {
        for (int j = 0; j < 3; j++) {
            set(i, j, p.get(j));
        }
    }

    public Matrix33 tild() {
        Matrix33 m = new Matrix33();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m.set(i, j, get(j, i));
            }
        }
        return m;
    }

    @Override
    public String toString() {
        String str = "m (\n";

        for (int i = 0; i < d.length; i++) {
            str += (i % 3 == 0 ? "\n\t" : " ") + d[i];
        }

        str += "\n)\n";
        return str;
    }

    public Matrix33 uniteH() {
        return this;
    }

    public Matrix33 uniteV() {
        return this;
    }

    public Matrix33 power(int n) {
        Matrix33 a = null; // RESULT
        if (n == 0) {
            a = Matrix33.I;
        } else if (n == 1)
            a = this;
        else if (n > 1) {
            a = this;
            for (int i = 2; i <= n; i++)
                a = a.mult(this);
        } else if (n == -1) {
            a = inverse();
        } else if (n < -1) {
            a = inverse();
            for (int i = -1; i >= n; i--)
                a = a.mult(this);
        }
        return new Matrix33(a);
    }

    public Matrix33 pourcents(Matrix33 m, double pc) {
        return mult(1 - pc).plus(m.mult(pc));
    }

    public Double[] getDoubles() {
        return d;
    }
}
