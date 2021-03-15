package one.empty3;

import java.util.*;
import java.io.*;

public class Run {
    public static void main(String [] args) {
        List<String> args2 = new ArrayList<>();
        Properties properties = new Properties();
        properties.load(new FileInputStream("runtestobjetsub.txt"));
        Scanner scanIn = new Scanner(System.in);                  
        properties.forEach((key, value ) -> {
            String [] line = new String []{(String)key, (String)value};
            String s;
            Scanner scanIn = new Scanner(System.in);        
            s = scanIn.nextLine(); 
            
            if(s.length()>0) {
               args2.add(line[0]+"="+s);
               properties.put(key, s);
            }
        });
        properties.save(new FileOutputStream("runtestobjetsub.txt"));
        args = new String [args2.size()];
        for(int i=0; i<args2.size(); i++)
            args[] = args2.get(i);
        TestRun.main(args);
    }
}
