/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.animation;

import be.manudahmen.emptycanvas.library.empty3.library.ECDim;
import be.manudahmen.emptycanvas.library.empty3.library.object.Scene;
import org.monte.media.Movie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class SimpleAnimationSuiteDiapo extends Animation {

    public SimpleAnimationSuiteDiapo(Scene s, ECDim dim) {
        super(s, dim);
    }

    public class MediaSuperType {

        public static final int MEDIA_TYPE_IMAGE = 0;
        public static final int MEDIA_TYPE_MOVIE = 1;
        public static final int MEDIA_TYPE_ANIMATION = 2;
        public static final int MEDIA_TYPE_COLOR = 4;

        private URL loadMediaFromUrl;
        private File loadMediaFromFIle;
        private BufferedImage image;
        private Movie movie;
    }

}
