package one.empty3.library;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class DecodeVelvet extends VideoDecoder {
   
/***
* init, start, run, and block on maxsize reached
* @param file video to draw on surface
* @param refTextureMov texture to apply
*/
    public VideoDecoder(File file, TextureMov refTextureMov) {
        super(file, refTextureMov);

   }
   public void init() {
	IVelvetVideoLib lib = VelvetVideoLib().getInstance();
	try (IDemuxer demuxer = lib.demuxer(new File(file))) {
	    IDecoderVideoStream videoStream = demuxer.videoStream(0);
	    IFrame videoFrame;
	    while ((videoFrame = videoStream.nextFrame()) != null) {
	   	    BufferedImage image = videoFrame.image();
	   	    // Use image as needed...
	    }
	}      
    }
}
