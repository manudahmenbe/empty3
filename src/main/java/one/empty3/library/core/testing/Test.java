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

package one.empty3.library.core.testing;

import one.empty3.library.Camera;
import one.empty3.library.ITexture;
import one.empty3.library.Scene;
import one.empty3.library.ZBuffer;

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
