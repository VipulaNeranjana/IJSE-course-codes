package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/vipula/Desktop/shiddat.mkv");
        if(!file.exists()){
            System.out.println("there is no such file");
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] bytes = fileInputStream.readAllBytes();  //in large files this method is giving an error

        while (true) {
            byte[] buffer = new byte[1024 * 1024 * 10]; //10MB
            int read = fileInputStream.read(buffer);
//            System.out.println(Arrays.toString(buffer));
            if(read == -1) break;
        }

        fileInputStream.close();
        System.out.println("Read!");
    }
}
