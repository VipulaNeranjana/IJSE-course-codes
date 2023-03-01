package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("somthing.dep");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes();
        System.out.println(Arrays.toString(bytes));
        fileInputStream.close();
    }
}
