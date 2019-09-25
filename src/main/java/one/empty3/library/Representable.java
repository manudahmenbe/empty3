/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

/*
 * 2013 Manuel Dahmen
 */
package one.empty3.library;

import one.empty3.library.core.lighting.Colors;
import one.empty3.library.core.raytracer.RtIntersectInfo;
import one.empty3.library.core.raytracer.RtMatiere;
import one.empty3.library.core.raytracer.RtRay;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Representable implements Serializable, Comparable, XmlRepresentable {
    public static Point3D SCALE1;
    public static final ITexture DEFAULT_TEXTURE = new TextureCol(Colors.random());
    protected static ArrayList<Painter> classPainters = new ArrayList<Painter>();
    public Rotation rotation;
    protected double NFAST = 100;
    protected RtMatiere materiau;
    protected ITexture CFAST = DEFAULT_TEXTURE;
    // protected Barycentre bc = new Barycentre();
    protected Representable parent;
    protected Scene scene;
    protected ITexture texture;
    private String id;
    private Painter painter = null;
    private int RENDERING_DEFAULT = 0;
    protected Render render = Render.getInstance(0, -1);
    protected Point3D scale;

    public Representable() {
        if (!(this instanceof Matrix33 || this instanceof Point3D || this instanceof StructureMatrix)) {
            rotation = new Rotation();
            scale = new Point3D(1d, 1d, 1d);

        }
        texture = new TextureCol(Colors.random());
    }

    public static void setPaintingActForClass(ZBuffer z, Scene s, PaintingAct pa) {
        Painter p = null;
        classPainters().add(new Painter(z, s, Representable.class));
        p.addAction(pa);
    }

    private static ArrayList<Painter> classPainters() {
        return classPainters;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public Point3D rotate(Point3D p0, Representable ref) {
        if (p0 == null) {
            return Point3D.O0;
        } else if (ref != null && ref.getRotation() != null)
            return ref.getRotation().rotation(p0);
        else
            return p0;
    }

    public void setRotation(Rotation r) {
        this.rotation = r;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public void informer(Representable parent) {
        this.parent = parent;
    }


    public void replace(String moo) {
        throw new UnsupportedOperationException("Operation non supportee");
    }

    public void scene(Scene scene) {
        this.scene = scene;

    }


    public boolean supporteTexture() {
        return false;
    }

    public ITexture texture() {
        return this.texture;
    }

    public void texture(ITexture tc) {
        this.texture = tc;
    }


    /***
     * DOn't call ZBuffer dessiine methods here: it would loop.
     *
     * @param z ZBuffer use plot or dessine(P) or tracerTriangle(TRI, Itexture)
     */
    public void drawStructureDrawFast(ZBuffer z) {
        throw new UnsupportedOperationException("No genral method for drawing objects");
    }

    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return false;
    }

    /**
     * When correctly initialized, PaintingAct action method is called while
     * the shape is rendered.
     *
     * @param z  the actual ZBuffer in which the action should occurs
     * @param s  the scene in which the actions can access to other objects properties.
     *           Optional parameter
     * @param pa The "painting act" (term referring to history of arts).
     */
    public void setPaintingAct(ZBuffer z, Scene s, PaintingAct pa) {
        this.painter = new Painter(z, s, this);
        pa.setObjet(this);
        pa.setScene(s);
        pa.setZBuffer(z);
        painter.addAction(pa);
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public void paint() {
        if (getPainter() != null) {
            getPainter().getPaintingAct().paint();
        }
    }

    public Intersects.Intersection intersects(RtRay ray, RtIntersectInfo cii) {
        // TODO Implements
        return null;
    }

    public Representable intersects(Representable r2) {
        throw new UnsupportedOperationException("Pas implémenté  en cours" +
                "");
    }

    public void become(Representable r) {
        if (this.getClass().equals(r.getClass())) {
            set(r);
        }
    }

    private void set(Representable r) {
    }

    /***
     *
     * @param o
     * @return ???
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Representable))
            return 0;
        else
            return 1;

    }

    public void draw(ZBufferImpl zBuffer) {
    }

    public class RotationInt extends Rotation {

        public RotationInt() {

        }

        public RotationInt(Matrix33 m, Point3D c) {
            rot = m;
            centreRot = c;
        }

    }


    private HashMap<String, StructureMatrix> declaredDataStructure = new HashMap<>();

    public HashMap<String, StructureMatrix> getDeclaredDataStructure() {
        return declaredDataStructure;
    }

    private HashMap<String, StructureMatrix> declaredLists = new HashMap<>();

    public HashMap<String, StructureMatrix> getDeclaredLists() {
        return declaredLists;
    }

    public ITexture getTexture() {
        return texture;
    }

    public void setTexture(ITexture texture) {
        this.texture = texture;
    }

    public Class getPropertyType(String propertyName) throws NoSuchMethodException {
        Method propertyGetter = null;
        propertyGetter = this.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.length() > 1 ? propertyName.substring(1) : ""));
        return propertyGetter.getReturnType();
    }

    public void setProperty(String propertyName, Object value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;

        propertySetter = this.getClass().getMethod("set" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.substring(1)), value.getClass());
        propertySetter.invoke(this, value);
        System.out.println("RType : " + this.getClass().getName() + " Property: " + propertyName + " New Value set " + getProperty(propertyName));
    }

    public Object getProperty(String propertyName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;
        propertySetter = this.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + propertyName.substring(1));
        return propertySetter.invoke(this);
    }

    public String toString() {
        return "Representable()";
    }


    public void declareProperties() {


    }


    public HashMap<String, StructureMatrix> declarations() {
        HashMap<String, StructureMatrix> declarations = new HashMap<>();
        getDeclaredDataStructure().forEach(new BiConsumer<String, StructureMatrix>() {
            @Override
            public void accept(String s, StructureMatrix structureMatrix) {
                declarations.put(s, structureMatrix);
            }
        });
        return declarations;
    }


    public ITexture getCFAST() {
        return CFAST;
    }

    public void setCFAST(ITexture CFAST) {
        this.CFAST = CFAST;
    }

    public Point3D getScale() {
        return scale;
    }

    public void setScale(Point3D scale) {
        this.scale = scale;
    }


    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, Double o) {
        stringBuilder.append("<Double class=\"" + o.getClass() + "\">" + o + "</Double>");
    }

    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, Boolean o) {
        stringBuilder.append("<Boolean class=\"" + o.getClass() + "\">" + o + "</Boolean>");
    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, Integer o) {
        stringBuilder.append("<Integer class=\"" + o.getClass() + "\">" + o + "</Integer>");
    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, String o) {
        stringBuilder.append("<String class=\"" + o.getClass() + "\"> <![CDATA[ " + o + " ]]> </String>");
    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, File o) {
        stringBuilder.append("<String filename=\"" + o.getName() + "\"class=\"" + o.getClass() + "\"> <![CDATA[ " + o.getName() + " ]]> </String>");
        try {
            FileInputStream fileInputStream = new FileInputStream(o);
            File copy = new File(filesPath + "/" + o.getName());
            copy.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(copy);
            int read = -1;
            byte[] bytes = new byte[4096];
            while (read != 0) {

                read = fileInputStream.read(bytes);
                fileOutputStream.write(bytes, 0, read);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, ArrayList o) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, Object o) {
        if (o instanceof StructureMatrix) {
            xmlRepresentation(filesPath, parent, stringBuilder, (StructureMatrix) o);
        } else if (o instanceof Representable) {
            xmlRepresentation(filesPath, parent, stringBuilder, ((Representable) o));
        } else {
            switch (o.getClass().getName()) {
                case "java.lang.Boolean":
                    xmlRepresentation(filesPath, parent, stringBuilder, ((Boolean) o));
                    break;
                case "java.lang.Double":
                    xmlRepresentation(filesPath, parent, stringBuilder, ((Double) o));
                    break;
                case "java.lang.Integer":
                    xmlRepresentation(filesPath, parent, stringBuilder, ((Integer) o));
                    break;
                case "java.lang.String":
                    xmlRepresentation(filesPath, parent, stringBuilder, ((String) o));
                    break;
                case "java.util.ArrayList":
                    xmlRepresentation(filesPath, parent, stringBuilder, ((ArrayList) o));
                    break;
                case "java.io.File":
                    xmlRepresentation(filesPath, parent, stringBuilder, ((File) o));
                    break;
            }

        }
    }


    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, Representable is) {
        stringBuilder.append("<Representable class=\"" + is.getClass().getName() + "\">\n");
        is.declareProperties();
        is.declarations().forEach((s, o) -> {
            xmlRepresentation(filesPath, is, stringBuilder, s, o);
        });
        stringBuilder.append("</Representable>\n");
    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder) {
    }

    @Override
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, String name, StructureMatrix is) {
        stringBuilder.append("<StructureMatrix name=\"" + name + "\" dim=\"" + is.getDim() + "\" class=\"" + is.getClass().getName() + "\" typeClass=\"" + is.getClassType() + "\">");
        is.declareProperties();

        switch (is.getDim()) {
            case 0:
                stringBuilder.append("<Data dim=\"0\">");
                stringBuilder.append("<Cell l=\"0\" c=\"0\">");
                xmlRepresentation(filesPath, parent, stringBuilder, is.data0d);
                stringBuilder.append("</Cell>");
                stringBuilder.append("</Data>");
                break;
            case 1:
                stringBuilder.append("<Data dim=\"1\">");
                int[] i1 = new int[]{0, 0};
                is.data1d.forEach(new Consumer() {
                    @Override
                    public void accept(Object o) {
                        stringBuilder.append("<Cell l=\"" + i1[0] + "\" c=\"" + i1[1] + "\">");
                        xmlRepresentation(filesPath, is, stringBuilder, o);
                        stringBuilder.append("</Cell>");
                        i1[1]++;

                    }

                });
                stringBuilder.append("</Data>");
                break;
            case 2:
                stringBuilder.append("<Data dim=\"2\">");
                int[] i2 = new int[]{0, 0};
                is.data2d.forEach(new Consumer<List>() {
                    @Override
                    public void accept(List ts) {
                        stringBuilder.append("<Line l=\"" + i2[0] + "\">");

                        ts.forEach(new Consumer() {
                            @Override
                            public void accept(Object o) {
                                stringBuilder.append("<Cell l=\"" + i2[0] + "\" c=\"" + i2[1] + "\">");
                                xmlRepresentation(filesPath, is, stringBuilder, o);
                                i2[1]++;
                                stringBuilder.append("</Cell>");
                            }
                        });

                        stringBuilder.append("</Line>");
                        i2[0]++;
                    }
                });
                stringBuilder.append("</Data");
                break;


        }
        stringBuilder.append("</StructureMatrix>");
    }
}


