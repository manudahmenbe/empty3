package one.empty3.library;
import ru.sbtqa.monte.media.*;
import ru.sbtqa.monte.media.FormatKeys.*;
import java.io.File;
import java.awt.image.BufferedImage;
public class DecodeMonte extends VideoDecoder {
 
 public DecodeMonte(File file, TextureMov refTextureMov) {
        super(file, refTextureMov);
    }

 
 
 
 public void run() {

try {
 //ArrayList<BufferedImage> frames=new ArrayList<BufferedImage> ();
 
 MovieReader in = Registry.getInstance().getReader(file);
 Format format = new Format(VideoFormatKeys.DataClassKey, BufferedImage.class);
 int track = in.findTrack(0, new Format(MediaTypeKey,MediaType.VIDEO));
 Codec codec=Registry.getInstance().getCodec(in.getFormat(track), format);
 
 Buffer inbuf = new Buffer();
 Buffer codecbuf = new Buffer();
 do {
  if(size()>MAXSIZE)
   try {
    Thread.sleep(100);
    } catch(InterruptedException ex) {
   
   }
 in.read(track, inbuf);
 codec.process(inbuf, codecbuf);
 if (!codecbuf.isFlag(BufferFlag.DISCARD)) {
 imgBuf.add(new ECBufferedImage(Images.cloneImage((BufferedImage)codecbuf.data))) ;
 
 }
 
 } while (!inbuf.isFlag(BufferFlag.END_OF_MEDIA));
 } catch(IOException ex) {
  ex.printStackTrace();
 }
 finally {
 in.close();
 }
 
// return frames.toArray(new BufferedImage[frames.size()]);
 
}
  }
