package lk.ijse.dep10.regexp;

import java.util.Arrays;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {

        String someText = "here is my nic 111111111V";
        System.out.println(isValidNic(someText));
//        someText = someText.replaceFirst("\\d{9}[Vv]", "123");
        someText = someText.replaceAll("\\d{9}[Vv]","xxx xxx xxx");
        System.out.println(someText);
        someText = "I want split this ward into a array";
        String[] split = someText.split("\\b");
        System.out.println(Arrays.toString(split));

    }

    private static boolean isValidNic(String nic) {
        return nic.toUpperCase().matches("\\d{9}V");
//        if(nic.length() != 10 || !nic.substring(9).equals("V")) return false;
//
//        char[] chars = nic.substring(0,9).toCharArray();
//        for (char aChar : chars) {
//            if(!Character.isDigit(aChar)) return false;
//        }
//
//        return true;

    }
}
