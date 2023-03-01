package lk.ijse.dep10.io;

import java.io.*;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            viaVanilla(i);
            viaBuffers(i);
        }

    }

    private static void viaBuffers(int attempt) throws IOException {
        File file = new File("bufferedFileCheck1");

        FileWriter fileOutputStream = new FileWriter(file);
        BufferedWriter bufferedOutputStream = new BufferedWriter(fileOutputStream);
        long t1 = System.nanoTime();

        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");
        bufferedOutputStream.write("I want to write this in a file");

        bufferedOutputStream.close();
        long t2 = System.nanoTime();
        System.out.printf("B:Attempt %d,%d \n",attempt,t2-t1);
//        System.out.println("done");
    }

    private static void viaVanilla(int attempt) throws IOException {
        File file = new File("bufferedFileCheck2");

        FileWriter fileOutputStream = new FileWriter(file);

        long t1 = System.nanoTime();
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");
        fileOutputStream.write("I want to write this in a file");

        fileOutputStream.close();
        long t2 = System.nanoTime();
        System.out.printf("V:Attempt-%d,%d \n",attempt,t2-t1);
//        System.out.println("done");
    }
}
