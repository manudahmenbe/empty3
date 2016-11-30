package be.manudahmen.emptycanvas.library.empty3.library.testing;

import be.manudahmen.emptycanvas.library.empty3.library.object.Scene;

public class TestSTL {

    public static class Liste {

        public int version = 11;

        public String fn = ".STL";
        public Scene scene = new Scene();

        public Liste() {
        }

        public String getFilename() {
            return scene.get(0).getClass().getName() + "-" + version + ".STL";
        }
    }

}
