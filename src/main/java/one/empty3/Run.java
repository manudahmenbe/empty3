package one.empty3.Run;

import java.util.Properties;
import java.io.*;

public class Run {
    public static void main(String [] args) {
        List<String> args2 = new ArrayList<>();
        Properties properties = new Properties(new File("runtestobjetsub.txt"));
        properties.forEach((key, value ) -> {
            String line = new String [] [] {properties(), properties.getValue()};
            System.scanf("Input : "+line[0]+"\ndefault value : " +line[1]+"\n", s);
            if(s.length()>0) {
               args2.add(line[0]+"="+s);
               properties.put(key, s);
            }
        });
        properties.save();
TestRun.main(args2.toArray());
    }
}
