package one.empty3;

import java.util.*;
import java.io.*;

public class Run {
    public static void main(String [] args) {
        try {
        List<String> args2 = new ArrayList<>();
        Properties properties = new Properties();
        properties.load(new FileInputStream("runtestobjetsub.txt"));
        Scanner scanIn = new Scanner(System.in);                  
        properties.forEach((key, value ) -> {
            String [] line = new String []{(String)key, (String)value};
            String s;
System.out.println("var "+key+"\n\tdefault:\t"+value+"\n\tchange ? \t");
            s = scanIn.nextLine(); 
            
            if(s.length()>0 && !s.equals("\n")) {
               args2.add(line[0]+"="+s);
               properties.replace(key, s);
            } else if(delete){
               //args2.add(line[0]+"="+value);
               properties.remove(key);
            }
        });
        properties.store(new FileOutputStream("runtestobjetsub.txt"),
            null);
        args = new String [args2.size()];
        for(int i=0; i<args2.size(); i++)
            args[i] = args2.get(i);
        TestRun.main(args);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
