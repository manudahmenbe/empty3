/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
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

public class Cube extends Representable implements TRIGenerable, IMovable {

    /**
     *
     */
    private static final long serialVersionUID = 3437509687221141764L;
    public static String DATA = null;
    private String id;
    private double mlc = 1.0;
    private Point3D position = new Point3D(0.0, 0.0, 0.0);
    private TRIObject ts = new TRIObject();
    private static double[][][] coordCube = new double[][][]{
            {
                    {1.0, -1.0, -1.0},
                    {1.0, 1.0, -1.0},
                    {1.0, 1.0, 1.0},},
            {
                    {1.0, -1.0, -1.0},
                    {1.0, -1.0, 1.0},
                    {1.0, 1.0, 1.0},},
            {
                    {-1.0, -1.0, -1.0},
                    {-1.0, 1.0, -1.0},
                    {-1.0, 1.0, 1.0},},
            {{-1.0, -1.0, -1.0},
                    {-1.0, -1.0, 1.0},
                    {-1.0, 1.0, 1.0},}, {{-1.0, 1.0, -1.0},
            {1.0, 1.0, -1.0},
            {1.0, 1.0, 1.0}
    }, {{-1.0, 1.0, -1.0},
            {-1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0},}, {{-1.0, -1.0, -1.0},
            {1.0, -1.0, -1.0},
            {1.0, -1.0, 1.0}}, {
            {-1.0, -1.0, -1.0},
            {-1.0, -1.0, 1.0},
            {1.0, -1.0, 1.0}
    }, {{-1.0, -1.0, -1.0},
            {-1.0, 1.0, -1.0},
            {1.0, 1.0, -1.0}
    }, {{-1.0, -1.0, -1.0},
            {1.0, -1.0, -1.0},
            {1.0, 1.0, -1.0}
    }, {{-1.0, -1.0, 1.0},
            {-1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0}
    },
            {{-1.0, -1.0, 1.0},
                    {1.0, -1.0, 1.0},
                    {1.0, 1.0, 1.0}
            }
    };

    public Cube() {
    }

    public Cube(ITexture t) {
        texture(t);
    }

    public Cube(double mlc, Point3D position) {
        this.mlc = mlc;
        this.bc.position = position;
    }

    public Cube(double mlc, Point3D position, ITexture t) {
        this.mlc = mlc;
        this.bc.position = position;
        texture(t);
    }

    public TRIObject generate() {
        ts.clear();

        for (int i = 0; i < 12; i++) {
            TRI t = new TRI(
                    new Point3D(coordCube[i][0], texture()).mult(mlc).plus(bc.position),
                    new Point3D(coordCube[i][1], texture()).mult(mlc).plus(bc.position),
                    new Point3D(coordCube[i][2], texture()).mult(mlc).plus(bc.position),
                    texture());

            ts.add(t);

        }
        return ts;
    }

    public String getId() {
        return id;
    }

    public double getMlc() {
        return mlc * bc.agrandissement;
    }

    public void setMlc(double mlc) {
        this.mlc = mlc;
    }

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

    public Representable place(MODObjet aThis) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Barycentre position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supporteTexture() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "cube(\n\t" + position.toString() + "\n\t" + mlc + "\n)\n";
    }

    @Override
    public void moveAdd(Point3D add) {
        position = position.plus(add);
        generate();
    }

    @Override
    public void moveTo(Point3D to) {
        position = to;
        generate();
    }

    public static double [][][] getData()
    {
        return coordCube;
    }
}
