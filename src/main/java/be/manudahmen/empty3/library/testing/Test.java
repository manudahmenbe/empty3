package be.manudahmen.empty3.library.testing;

import be.manudahmen.empty3.library.object.Camera;
import be.manudahmen.empty3.library.object.ITexture;
import be.manudahmen.empty3.library.object.Scene;
import be.manudahmen.empty3.library.object.ZBuffer;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Manuel DAHMEN
 */
public interface Test extends Runnable {

    /***
     * After the loop extend to add extra info on movie
     */
    void afterRender();

    /**
     * Prefer use scene().cameraActive()
     *
     * @return
     */
    Camera camera();

    /**
     * Prefer use scene().cameraActive()
     *
     * @return
     */
    void camera(Camera c);

    /***
     * Not in use
     *
     * @return
     */
    ArrayList<TestInstance.Parameter> getInitParams();


    /***
     * boolean for begin loop and making a movie or a image sequence
     *
     * @return isLoop?
     */
    boolean loop();

    /***
     * boolean for begin loop and making a movie or a image sequence
     *
     * @return isLoop?
     */
    void loop(boolean isLooping);

    /***
     * Internal use
     *
     * @return
     */
    boolean nextFrame();

    /***
     * Internal use
     */
    void publishResult();


    /***
     * Main run test method. Don't call it directly. Called when test starts
     */
    void run();

    /**
     * Scene to render. Instance Read only
     *
     * @return
     */
    Scene scene();

    /**
     * Main frame animation method
     *
     * @throws Exception
     */
    void testScene() throws Exception;

    /**
     * Main frame animation method. Load a file. Deprecated?
     *
     * @throws Exception
     */
    void testScene(File f) throws Exception;

    /***
     * Use for drawing fast after scene is drawn
     *
     * @return instance of running ZBuffer (ZBufferImpl)
     */
    ZBuffer getZ();


    void onTextureEnds(ITexture texture, int texture_event);

    void onMaxFrame(int maxFramesEvent);

}
