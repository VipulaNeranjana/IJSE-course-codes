package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        String someText = "Im vipula";
        File file = new File("something.dep");
        byte[] bytes = someText.getBytes();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        System.out.println("done writing");
    }


}
