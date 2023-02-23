package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("/home/vipula/Desktop/pencil.png");
        if(!file.exists()) {
            System.out.println("invalid file path");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(file);

//            byte[] bytes = new byte[fis.available()];
//            System.out.println(bytes.length);
//            fis.read(bytes);

            byte[] bytes = fis.readAllBytes();
            fis.close();

            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));

        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
