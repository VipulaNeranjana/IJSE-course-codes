package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/vipula/Desktop/dep10.ijse");
        if(file.exists()){
            System.out.println("file already exist");
            return;
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        String something = "hello this is a new file";
        byte[] bytes = something.getBytes();

        fileOutputStream.write(bytes);


        fileOutputStream.close();
    }
}
