import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;

public class Pojo {
    public static boolean parseBoolean(String s) {
        Boolean b =  ((s != null) && s.equalsIgnoreCase("true"));
        if(s!=null && !s.equalsIgnoreCase("false"))
            throw new NumberFormatException("Boolean illegal string");
        return false;
    }
    public static Object getO(String so) {

        Double d;
        Integer i = 0;
        Boolean b = false;
        try {
            d = Double.parseDouble(so);
            return d;
        } catch (Exception ex) {
            try {
                i = Integer.parseInt(so);
                return i;
            } catch (Exception ex1) {
                try {
                    b = parseBoolean(so);
                    return b;
                } catch (NumberFormatException ex2) {
                    return so;
                }
            }
        }
    }

    public static boolean setProperties(Object o, Properties p) {
        try {
            Iterator it = p.keySet().iterator();

            while (it.hasNext()) {
                String pr = it.next().toString();
                String propName = pr;
                String value = p.getProperty(pr);
                setProperty(o, propName, getO(value));
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /***
     * not implemented
     */
    public static Properties getProperties(Object o, Properties p) {

        return null;
    }

    public static Class getPropertyType(Object o, String propertyName) throws NoSuchMethodException {
        Method propertyGetter = null;
        propertyGetter = o.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.length() > 1 ? propertyName.substring(1) : ""));
        return propertyGetter.getReturnType();
    }

    public static void setProperty(Object o, String propertyName, Object value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;

        propertySetter = o.getClass().getMethod("set" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.substring(1)), value.getClass());
        propertySetter.invoke(o, value);
        System.out.println("RType : " + o.getClass().getName() + " Property: " + propertyName + " New Value set " + getProperty(o, propertyName));
    }

    public static Object getProperty(Object o, String propertyName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;
        propertySetter = o.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + propertyName.substring(1));
        return propertySetter.invoke(o);
    }

}
