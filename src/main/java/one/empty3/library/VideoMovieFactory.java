public class VideoMovieFactory {
     public VideoDecoder createInstance(File f, TextureMov m)
{
return new DecodeAndEncodeFramesXuggle(f,m);
}


}

