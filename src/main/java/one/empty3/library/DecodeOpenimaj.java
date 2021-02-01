package one.empty3.library;
import org.openimaj.video.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;

public abstract class VideoDecoder extends Thread {
    protected boolean eof = false;
    protected TextureMov text;
    protected File file;
    protected boolean stop = false;
    protected static final long MAXSIZE = 4;
    protected ArrayList<ECBufferedImage> imgBuf = new ArrayList() ;


/***
* init, start, run, and block on maxsize reached
* @param file video to draw on surface
* @param refTextureMov texture to apply
*/
    public VideoDecoder(File file, TextureMov refTextureMov) {
        this.file = file;
        this.text = refTextureMov;
       // start();

   }
 public int size() {
  return imgBuf.size();
  }
 public boolean isClosed() {
  return eof;
  }
 public ECBufferedImage current() {
 
 ECBufferedImage c = imgBuf.get(0);
  imgBuf.remove(0);
  return c;
 
 }

public boolean process ()
{
Video<MBFImage> video;
video = new XuggleVideo(new File("/path/to/keyboardcat.flv"));
VideoDisplay<MBFImage> display = VideoDisplay.createVideoDisplay(video)
//VideoDisplay<MBFImage> display = VideoDisplay.createVideoDisplay(video);
display.addVideoListener(
  new VideoDisplayListener<MBFImage>() {
    public void beforeUpdate(MBFImage frame) {
        frame.processInplace(new CannyEdgeDetector());
    }

    public void afterUpdate(VideoDisplay<MBFImage> display) {
    }
  });
}
}
