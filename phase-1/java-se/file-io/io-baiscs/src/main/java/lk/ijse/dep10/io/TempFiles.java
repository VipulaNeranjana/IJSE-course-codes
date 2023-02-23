package lk.ijse.dep10.io;

import java.io.File;
import java.io.IOException;

public class TempFiles {
    public static void main(String[] args) throws IOException {
        File temp = File.createTempFile("ijse","dep10");
        System.out.println(temp);
    }
}
