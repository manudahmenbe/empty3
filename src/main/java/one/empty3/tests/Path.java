package one.empty3.tests;

import one.empty3.library.MatrixPropertiesObject;
import one.empty3.library.Representable;

public class Path {
    private Representable representable;
    private String propertyPathString;
    private int pathElemType;
    private int indexI;
    private int indexJ;
    private Object o;
    public Path(Object o, String propertyPathString, int pathElemType, int indexI, int indexJ) {
        this.o = o;
        this.propertyPathString = propertyPathString;
        this.pathElemType = pathElemType;
        this.indexI = indexI;
        this.indexJ = indexJ;
    }

    public Object getRepresentable() {
        return o;
    }

    public void setRepresentable(Object o) {
        this.o = o;
    }

    public String getPropertyPathString() {
        return propertyPathString;
    }

    public void setPropertyPathString(String propertyPathString) {
        this.propertyPathString = propertyPathString;
    }

    public int getPathElemType() {
        return pathElemType;
    }

    public void setPathElemType(int pathElemType) {
        this.pathElemType = pathElemType;
    }

    public int getIndexI() {
        return indexI;
    }

    public void setIndexI(int indexI) {
        this.indexI = indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }

    public void setIndexJ(int indexJ) {
        this.indexJ = indexJ;
    }


}
