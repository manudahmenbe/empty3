import one.empty3.library.core.testing.*;
import java.util.*;
import java.io.*;
public class TestRun {
    //Map<String, String> properties = new HashMap<>();
    public static void runTest(TestObjet to, Properties p) {
        Pojo.setProperties(to, p);
        new Thread(to).start();
    } 

    public static void main(String [] args) {
    Properties p = new Properties ();
    System.out.println(args.length + " arguments :");
    
    // P properties -< args.foreach.split

    for (String arg: args) {
         String [] kv = arg.split("=");
         String key = kv[0];
         String value = kv[1];

         p.setProperty(key, value);

Class cl; int resx; int resy; int maxFrames;
         switch(key) {
    case "class":
         try {
              cl = Class.forName(args[0]);  
         
              Object t=  cl.newInstance () ;
              
         } catch(Exception ex) {
              ex.printStackTrace();
         }
         break;
    case "resx":
         resx = Integer.parseInt(value);
         break;
    case "resy":
         resy = Integer.parseInt(value);
         break;
    case "maxFrames":
         maxFrames = Integer.parseInt(value);
         break;
   case "p":
         String k2 = kv[1];
         String v2 = kv[2];
         
         
         break;
    case "file":
         FileInputStream fis = new FileInputStream(
              new File(value));
         p.load(fis);
         break;
    }
   }

   // if(cl instanceof TestObjet) {

        runTest((TestObjet ) cl, p) ;
//    }

    }
     
} 
