package lk.ijse.dep10.io;

import java.io.*;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            vanilla();
            buffered();
        }

    }

    public static void vanilla() throws IOException {
        File file = new File("bufferedFileCheck2");
        FileInputStream fileInputStream = new FileInputStream(file);
        long t1 = System.nanoTime();
        byte[] bytes = fileInputStream.readAllBytes();
        long t2 = System.nanoTime();
        fileInputStream.close();
        System.out.println(t2-t1 + "  vanilla");
    }
    public static void buffered() throws IOException {
        File file = new File("bufferedFileCheck2");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        long t1 = System.nanoTime();
        byte[] bytes = bufferedInputStream.readAllBytes();
        long t2 = System.nanoTime();
        bufferedInputStream.close();
        System.out.println(t2-t1);
    }
}
