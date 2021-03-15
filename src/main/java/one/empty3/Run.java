package one.empty3.Run;

import java.util.Properties;
public class Run {
    public static void main(String [] args) {
        List<String> args2 = new ArrayList<>();
        Properties properties = new Properties(new File("runtestobjetsub.txt"));
        for((key, value ) -> {
            String line = new String [] [] {properties(), properties.getValue()};
            System.scanf("Input : "+line[0]+"\ndefault value : " +line[1]+"\n", s);
            args2.add(line[0]+"="+s);
        });
TestRun.main(args2.toArray());
    }
}
