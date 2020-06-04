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
    System.out.println(" arguments class=className"+"\nSETTERproperty (resx, resy, filename1,etc" );
    
    Object t=null;   

        // P properties -< args.foreach.split
Class cl; int resx; int resy; int maxFrames;
    for (String arg: args) {
        System.out.println(arg);
         String [] kv = arg.split("=");
        if(kv.length==2) {
            System.out.println("argument : key=value;"+kv.length);
            
         
         String key = kv[0];
         String value = kv[1];

         p.setProperty(key, value);


         switch(key) {
    case "class":
         try {
              cl = Class.forName(value);  
         
              t=  cl.newInstance () ;
              if(!(t instanceof TestObjet))
                  return;
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
                 try {
         FileInputStream fis = new FileInputStream(
              new File(value));
         p.load(fis);
             } catch(IOException ex)
                     {
                     ex.printStackTrace();
                     }
         break;
    }
   }
}
   // if(cl instanceof TestObjet) {
if(t!=null)
        runTest((TestObjet)t, p) ;
//    }

    }
     
} 
