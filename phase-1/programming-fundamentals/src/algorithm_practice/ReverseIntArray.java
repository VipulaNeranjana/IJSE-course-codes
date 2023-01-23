package algorithm_practice;

import java.util.Arrays;

public class ReverseIntArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,3,4,2,8,3,5,0};

//        System.out.println(Arrays.toString(reverseArrayByForLoop(numbers)));
//        System.out.println(Arrays.toString(reverseArrayByWhileLoop(numbers)));
//        System.out.println(Arrays.toString(reverseArrayByDoWhileLoop(numbers)));
//        System.out.println(Arrays.toString(reverseArrayByForEachLoop(numbers)));
        System.out.println(Arrays.toString(reverseArrayByRecursion(numbers,0)));
    }
    public static int[] reverseArrayByForLoop(int[] intArray){
        for (int index = 0; index < intArray.length/2; index++) {
            int intermediate = intArray[index];
            intArray[index] = intArray[intArray.length-1-index];
            intArray[intArray.length-1-index] = intermediate;
        }
        return intArray;
    }

    public static int[] reverseArrayByWhileLoop(int[] intArray){
        int index = 0;
        while (index < intArray.length/2){
            int intermediate = intArray[index];
            intArray[index] = intArray[intArray.length-1-index];
            intArray[intArray.length-1-index] = intermediate;
            index++;
        }
        return intArray;
    }
    public static int[] reverseArrayByDoWhileLoop(int[] intArray){
        int index = 0;
        do{
            int intermediate = intArray[index];
            intArray[index] = intArray[intArray.length-1-index];
            intArray[intArray.length-1-index] = intermediate;

        }while (++index < intArray.length/2);
        return intArray;
    }
    public static int[] reverseArrayByForEachLoop(int[] intArray){
        int index = 0;
        for (int number : intArray) {
            int intermediate = intArray[intArray.length-1-index];
            intArray[intArray.length-1-index] = intArray[index];
            intArray[index] = intermediate;
            index++;
            if (index == ((intArray.length/2))) break;

        }
        return intArray;
    }
    public  static int[] reverseArrayByRecursion(int[] intArray,int startingPoint){
        if (startingPoint== intArray.length/2) return intArray;
        int intermediate = intArray[startingPoint];
        intArray[startingPoint] = intArray[intArray.length-1-startingPoint];
        intArray[intArray.length-1-startingPoint] =intermediate;
        return  reverseArrayByRecursion(intArray,++startingPoint);
    }
}
