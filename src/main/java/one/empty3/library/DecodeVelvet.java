IVelvetVideoLib lib = VelvetVideoLib().getInstance();
	try (IDemuxer demuxer = lib.demuxer(new File("/some/path/example.mp4"))) {
	    IDecoderVideoStream videoStream = demuxer.videoStream(0);
	    IFrame videoFrame;
	    while ((videoFrame = videoStream.nextFrame()) != null) {
	   	    BufferedImage image = videoFrame.image();
	   	    // Use image as needed...
	    }
	}      
