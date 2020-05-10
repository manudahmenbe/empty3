package one.empty3.library;
public class VideoMovieFactory {
     public VideoDecoder createInstance(File f, TextureMov m)
      {
          return new DecodeAndCaptureFramesXuggle(f,m);
       }


}

