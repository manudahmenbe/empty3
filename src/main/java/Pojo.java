import java.util.*;
public class Pojo {
   
public static Object getO(String so) {

            double d;
int i =0;
            try {
		    d = Double.parseInteger(so);
		    return d;
	    } catch(Exception ex) {
		    try {
		    i = Integer.parseInteger(so);
return i;
} catch(Exception ex) {
     return so;
}
{
return so;
}
public static boolean setProperties(Object o, Properties p) {
	    
        Iterator it = property.keySet().iterator();
		
        while (it.hasNext()) {
                String propName = it.next();
                String value = p.getProperty(propName);
                setProperty(o, propName, getO(value);
            }
         return false;
    }
  public static Properties getProperties(Object o, Properties p) {
      
         return null;
    }
    
    public Class getPropertyType(Object o, String propertyName) throws NoSuchMethodException {
        Method propertyGetter = null;
        propertyGetter = o.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.length() > 1 ? propertyName.substring(1) : ""));
        return propertyGetter.getReturnType();
    }

    public void setProperty(Object o, String propertyName, Object value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;

        propertySetter = o.getClass().getMethod("set" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.substring(1)), value.getClass());
        propertySetter.invoke(o, value);
        System.out.println("RType : " + o.getClass().getName() + " Property: " + propertyName + " New Value set " + getProperty(propertyName));
    }

    public Object getProperty(Object o, String propertyName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;
        propertySetter = o.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + propertyName.substring(1));
        return propertySetter.invoke(o);
    }

}
