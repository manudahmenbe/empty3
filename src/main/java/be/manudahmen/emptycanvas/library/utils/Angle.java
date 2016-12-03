package be.manudahmen.emptycanvas.library.utils;

public class Angle {
    public static final int NONE = -1;
    public static final int DEG = 1;
    public static final int RAD = 2;
    private double angleRadians = 0;
    private int type = 0;

    public Angle() {
        try {
            valueType(NONE);
        } catch (AngleTypeException e) {
            e.printStackTrace();
        }
    }

    public static Angle degree(double value) throws AngleTypeException {
        Angle ret = new Angle();
        ret.valueRad(value / 2 / Math.PI * 360);
        ret.valueType(DEG);
        return ret;
    }

    public static Angle radian(double value) throws AngleTypeException {
        Angle ret = new Angle();
        ret.valueRad(value);
        ret.valueType(RAD);
        return ret;
    }

    private void valueType(int v) throws AngleTypeException {
        int[] values = (new int[]{NONE, DEG, RAD});
        for (int i = 0; i < values.length; i++) {
            if (values[i] == v) {
                type = v;
                return;
            }
        }
        throw new AngleTypeException("Pas un bon type");
    }

    public Angle convert(int pType) throws AngleTypeException {
        if (pType == type)
            return this;
        if (pType == RAD) {
            valueRad(angleRadians);
            valueType(RAD);
            return this;
        }
        if (pType == DEG) {
            valueRad(angleRadians / 2 / Math.PI * 360);
            valueType(DEG);
            return this;
        }
        return null;
    }

    private void valueRad(double v) {
        this.angleRadians = v;
    }
}
