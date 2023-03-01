package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo3 {
    public static void main(String[] args) throws IOException {
        String someText = "im vipula";
        File file = new File("something3.dep");

        FileWriter fw = new FileWriter(file);
        fw.write(someText);
        fw.close();

        System.out.println("done");
    }
}
