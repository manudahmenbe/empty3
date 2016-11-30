/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.object;

public class Cube extends Representable implements TRIGenerable {

    /**
     *
     */
    private static final long serialVersionUID = 3437509687221141764L;
    public static String DATA = null;
    private String id;
    private double mlc = 1.0;
    private Point3D position = new Point3D(0.0, 0.0, 0.0);
    private TRIObject ts = new TRIObject();
    private double[][][] coordCube = new double[][][]{
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

}
