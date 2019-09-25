/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
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
