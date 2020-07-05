package one.empty3.library;
public class RFactory {
    public static void loadConfig() {
        Properties load;
    }
    // get interfaces
    
    public static ZBuffer getZBuffer() {
        return ZBufferImpl8.class;
        }
    public static Point3D getPoint3D() {
        return Point3D.class;
    }
}
