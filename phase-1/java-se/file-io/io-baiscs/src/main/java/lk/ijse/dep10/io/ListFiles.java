package lk.ijse.dep10.io;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File desktop = new File("/home/vipula/Desktop");
        System.out.println(desktop.isDirectory());
        System.out.println(desktop.isFile());

        String[] list = desktop.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] listDir = desktop.listFiles();
        for (File s : listDir) {
            System.out.println(s);
        }
    }
}
