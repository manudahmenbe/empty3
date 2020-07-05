package one.empty3.library;
public class RFactory {
    public static void loadConfig() {
        
    }
    // get interfaces
    
    public static ZBuffer getZBuffer() {
        return ZBufferImpl8;
    }
    public static Vec getPoint3D() {
        return Point3D;
    }
}
