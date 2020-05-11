import one.empty3.library.core.testing.*;
public class TestRun {
    public static void runTest(TestObjet to) {
        new Thread(to).start();
    } 

     public static void main(String [] args) {

System.out.println(args.length + " arguments :");
    for (String arg: args) {
         String kv = arg.split("=");
         String key = kv[0];
         String value = kv[1];

         switch(key) {
    case "class":
         Class cl = Class.forName(args[0]);  
         
              Object t=  cl.newInstance () ;
              
         } catch(Exception ex) {
              ex.printStackTrace();
         }
         break;
    case "resx":
    case "resy":
         break;
    }


    if(t instanceof TestObjet) 
                   runTest((TestObjet ) t) ;
}

    }
     } 
} 
