package algorithm_practice;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] h = reverse("vipula");
        System.out.println(Arrays.toString(toChar(h)));
    }
    public static int[] reverse(String input){
        char[] charArray = input.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length/2; i++) {
            char intermediate = charArray[i];
            charArray[i] = charArray[charArray.length-1-i];
            charArray[charArray.length-1-i] = intermediate;
        }
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = (int)charArray[i];
        }
        return intArray;
    }

    public static char[] toChar(int[] intArray){
        char[] charArray = new  char[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            charArray[i] = (char) intArray[i];
        }
        return charArray;
    }
}
