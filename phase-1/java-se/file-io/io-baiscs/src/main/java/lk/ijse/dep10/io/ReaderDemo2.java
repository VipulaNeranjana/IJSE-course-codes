package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReaderDemo2 {

    public static void main(String[] args) throws IOException {
        File file = new File("something2.dep");
        FileInputStream fileInputStream = new FileInputStream(file);
        String someText = "";
        while (true) {
            int read = fileInputStream.read();

            if(read == -1) break;

            char c = (char) read;
            someText += c;
        }
        fileInputStream.close();
        System.out.println(someText);
    }
}
