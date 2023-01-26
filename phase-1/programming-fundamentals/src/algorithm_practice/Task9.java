package algorithm_practice;

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        int[] a = new int[]{1,4,2,8,4,0,2,6};
        System.out.println(Arrays.toString(insertionSort(a)));
    }
    public static int[] insertionSort(int[] intArray){
        for (int i = 1; i < intArray.length; i++) {
            int index = findBestIndex(intArray,intArray[i]);
            intArray = dropToPlace(intArray,index,i);
        }
        return intArray;
    }

    public static int findBestIndex(int[] intArray, int input){
        int index1 = 0;
        int index2 = intArray.length;

        while (true){
            if (index1 == index2) return index1;
            if (intArray[(index1+index2)/2] > input) {
                index2 = (index1+index2)/2;
            }
            if (intArray[(index1+index2)/2] < input){
                index1 = (index1+index2)/2;
            }
        }
    }
    public static int[] dropToPlace(int[] intArray, int index, int rotationIndex){
        int intermediate = intArray[rotationIndex];
        for (int i = rotationIndex; i > 0 ; i--) {
            intArray[i] = intArray[i--];
        }
        intArray[index] = intermediate;
        return intArray;
    }
}
