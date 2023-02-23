package lk.ijse.dep10.io;

import java.io.File;

public class RenameAndMove {
    public static void main(String[] args) {
        /*rename*/
        File file = new File("/home/vipula/Desktop/hi.txt");
        File newFile = new File(file.getParentFile(), "mmm.txt");
        file.renameTo(newFile);

        /*Move*/
        File srcFile = new File("/home/vipula/Desktop/mm.pdf");

        File desktopFolder = new File(srcFile.getParent());
        File test = new File(desktopFolder,"test/lala/hoo");
        test.mkdirs();

        File target = new File("/home/vipula/Desktop/test/lala/hoo",srcFile.getName());
        boolean result = srcFile.renameTo(target);


    }
}
