package test3;

import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.objloader.E3Model;
import one.empty3.library.objloader.ModelLoaderOBJ;

import java.io.File;

public class TestObjs extends TestObjetSub {
    String directory = "resources/models/samples/";
    public TestObjs() {

    }

    public void ginit() {
        testObjs();
    }

    public void testObjs() {
        String[] list = new File(directory).list();
        for(int i=0; i<list.length; i++) {

            File file = new File(directory + list[i]);

            E3Model e3Model = ModelLoaderOBJ.LoadModelE3(file.getAbsolutePath(), file.getAbsolutePath());

            scene().add(e3Model);
        }

    }
    public static void main(String [] args) {
        TestObjs testObjs = new TestObjs();
        new Thread(testObjs).start();
    }
}
