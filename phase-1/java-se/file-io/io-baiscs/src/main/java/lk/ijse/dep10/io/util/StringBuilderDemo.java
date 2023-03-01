package lk.ijse.dep10.io.util;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();  //not thread safe
        stringBuilder.append("kasun")
                .append("wants")
                .append("something")
                .insert(5," ")
                .insert(11," ")
                .append(".")
                .setCharAt(0,'K');

        StringBuffer stringBuffer = new StringBuffer();  //thread safe
        stringBuffer.append("kasun")
                .append("wants")
                .append("something")
                .insert(5," ")
                .insert(11," ")
                .append(".")
                .setCharAt(0,'K');

        System.out.println(stringBuffer.toString());
        System.out.println(stringBuilder.toString());
    }
}
