BufferedImage[] readMovie(File file) throws IOException {
 ArrayList<BufferedImage> frames=new ArrayList<BufferedImage> ();
 
 MovieReader in = Registry.getInstance().getReader(file);
 Format format = new Format(DataClassKey, BufferedImage.class);
 int track = in.findTrack(0, new Format(MediaTypeKey,MediaType.VIDEO));
 Codec codec=Registry.getInstance().getCodec(in.getFormat(track), format);
 try {
 Buffer inbuf = new Buffer();
 Buffer codecbuf = new Buffer();
 do {
 in.read(track, inbuf);
 codec.process(inbuf, codecbuf);
 if (!codecbuf.isFlag(BufferFlag.DISCARD)) {
 frames.add(Images.cloneImage((BufferedImage)codecbuf.data));
 }
 
 } while (!inbuf.isFlag(BufferFlag.END_OF_MEDIA));
 } finally {
 in.close();
 }
 
 return frames.toArray(new BufferedImage[frames.size()]);
 }
