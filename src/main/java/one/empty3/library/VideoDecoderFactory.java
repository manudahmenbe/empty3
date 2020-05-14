package one.empty3.library;
import java.io.File;
public class VideoDecoderFactory {
     public static VideoDecoder createInstance(File f, TextureMov m)
      {
          return new DecodeAndEncodeXuggle(f,m);
       }


}

