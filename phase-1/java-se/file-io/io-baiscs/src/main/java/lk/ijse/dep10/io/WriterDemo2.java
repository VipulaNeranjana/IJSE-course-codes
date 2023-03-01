package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriterDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("something2.dep10");
        String somthing = "Im vipula";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (int i = 0 ; i<somthing.length(); i++){
            char c = somthing.charAt(i);
            byte byteC = (byte) c;
            fileOutputStream.write(byteC);
        }
        fileOutputStream.close();
        System.out.println("done");
    }
}
