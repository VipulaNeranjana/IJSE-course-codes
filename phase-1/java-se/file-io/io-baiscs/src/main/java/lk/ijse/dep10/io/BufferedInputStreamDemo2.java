package lk.ijse.dep10.io;

import java.io.*;

public class BufferedInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            vanilla();
            buffered();
        }

    }

    public static void vanilla() throws IOException {
        File file = new File("bufferedFileCheck2");
        FileReader fileInputStream = new FileReader(file);
        long t1 = System.nanoTime();

        StringBuilder sentence = new StringBuilder();
        while (true) {
            char[] buffer = new char[5];
            int read = fileInputStream.read(buffer);

            if(read == -1) break;

            sentence.append(buffer);
        }

        long t2 = System.nanoTime();
        fileInputStream.close();
//        System.out.println(sentence.toString().toString());
        System.out.println(String.format("V:Attempt -- %d",t2-t1));
    }
    public static void buffered() throws IOException {
        File file = new File("bufferedFileCheck2");
        FileReader fileInputStream = new FileReader(file);
        BufferedReader bufferedInputStream = new BufferedReader(fileInputStream);

        String line = "";
        String sentence = "";
        long t1 = System.nanoTime();

        while ((line = bufferedInputStream.readLine()) != null) {
            sentence += line;
        }
        long t2 = System.nanoTime();
        bufferedInputStream.close();

//        System.out.println(sentence);
        System.out.println(String.format("B:Attempt -- %d",t2-t1));
    }
}
