# empty3
[![Download empty3](https://a.fsdn.com/con/app/sf-download-button)](https://sourceforge.net/projects/empty3/files/latest/download)
empty3.one
Rendering engine. Shapes: surfaces, math-related
Drawings, curves, textures with pictures, movies
or colors.

#In progress or not:
- Lighting model. 
- Texture with geometric structure.
- Burbs? Nurbs.
- real modelling interface. Graphical or
  touch.
- Glsl clone compiler, interpreter and 
  rendering.

When you build with maven tool, assuming you have
correctly set jdk home and exe path, and maven
too, internet connection, space disk and memory
size enough... However your build will fail.

Because.
The explanation is that the pom.xml contains
a signing key in gpg plugin build section
of pom.xml descriptor. You can't sign against
me. It would not be fair 😃.

You can delete the sign clause and replace by yours
or nope.

If you miss a property check this
https://maven.apache.org/guides/introduction/introduction-to-profiles.html

Or make a new issue.
