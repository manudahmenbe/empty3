package one.empty3.library;
public class RFactory {
    public static void loadConfig() {
        
    }
    // get interfaces
    
    public static Class getZBuffer() {
        return ZBufferImpl8.class;
    }
    public static Class getVec() {
        return Point3D.class;
    }
}
