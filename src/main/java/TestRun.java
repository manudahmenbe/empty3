import one.empty3.library.core.testing.*;
public class TestRun {
    public static void runTest(TestObjet to) {
        new Thread(to).start();
    } 

     public static void main(String [] args) {

System.out.println(args.length + " arguments :");
    for (String arg: args) {
         String [] kv = arg.split("=");
         String key = kv[0];
         String value = kv[1];



Class cl; int resx; int resy; int maxFrames;
         switch(key) {
    case "class":
         cl = Class.forName(args[0]);  
         
              Object t=  cl.newInstance () ;
              
         } catch(Exception ex) {
              ex.printStackTrace();
         }
         break;
    case "resx":
         resx = Integer.parseInteger(value);
         break;
    case "resy":
         resy = Integer.parseInteger(value);
         break;
    case "maxFrames":
         maxFrames = Integer.parseInteger(value);
         break;
    case "p":
         String k2 = kv[1];
         String v2 = kv[2];
         // 
         break;
    }


    if(t instanceof TestObjet) {

        runTest((TestObjet ) t) ;
    }

    }
     
} 
