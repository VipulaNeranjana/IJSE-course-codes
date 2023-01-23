package algorithm_practice;

import java.lang.reflect.Type;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 2, 8, 5, 0, -3, 5};
//        System.out.println(Arrays.toString(selectionSortByForByMax(numbers)));
//        System.out.println(Arrays.toString(selectionSortByForByMin(numbers)));
//        System.out.println(Arrays.toString(selectionSortByRecursionByMax(numbers)));
//        System.out.println(Arrays.toString(selectionSortByWhileByMax(numbers)));
//        System.out.println(Arrays.toString(selectionSortByWhileByMin(numbers)));
//        System.out.println(Arrays.toString(selectionSortByDoWhileByMax(numbers)));
//        System.out.println(Arrays.toString(selectionSortByDoWhileByMin(numbers)));
        System.out.println(Arrays.toString(selectionSortByRecursionByMin(numbers)));
    }

    public static int[] selectionSortByForByMin(int[] intArray) {
        for (int index = 0; index < intArray.length; index++) {
            int minIndex = index;
            for (int index1 = index; index1 < intArray.length; index1++) {
                if (intArray[minIndex] < intArray[index1]) continue;
                minIndex = index1;

            }
            int intermediate = intArray[index];
            intArray[index] = intArray[minIndex];
            intArray[minIndex] = intermediate;
        }
        return intArray;
    }

    public static int[] selectionSortByForByMax(int[] intArray) {
        for (int index1 = 0; index1 < intArray.length; index1++) {
            int max = intArray[0];
            int maxIndex = 0;
            for (int index = 0; index < intArray.length - index1; index++) {
                if (max > intArray[index]) continue;
                max = intArray[index];
                maxIndex = index;

            }
            int intermediate = intArray[intArray.length - 1 - index1];
            intArray[intArray.length - 1 - index1] = intArray[maxIndex];
            intArray[maxIndex] = intermediate;
        }
        return intArray;
    }

    public static int[] selectionSortByWhileByMax(int[] intArray) {
        int index = 0;
        while (index < intArray.length - 1) {
            int maxIndex = 0;
            int index1 = 0;
            while (index1 < intArray.length - index) {
                if (intArray[maxIndex] > intArray[index1]) {
                    index1++;
                    continue;
                }
                maxIndex = index1;
                index1++;
            }
            int intermediate = intArray[intArray.length - 1 - index];
            intArray[intArray.length - 1 - index] = intArray[maxIndex];
            intArray[maxIndex] = intermediate;
            index++;
        }
        return intArray;
    }

    public static int[] selectionSortByWhileByMin(int[] intArray) {
        int index = 0;
        while (index < intArray.length) {
            int minIndex = index;
            int index1 = index;
            while (index1 < intArray.length) {
                if (intArray[minIndex] < intArray[index1]) {
                    index1++;
                    continue;
                }
                minIndex = index1;
                index1++;
            }
            int intermediate = intArray[index];
            intArray[index] = intArray[minIndex];
            intArray[minIndex] = intermediate;
            index++;
        }
        return intArray;
    }

    public static int[] selectionSortByDoWhileByMax(int[] intArray) {
        int index = 0;
        do {
            int maxIndex = 0;
            int index1 = 0;
            do {
                if (intArray[maxIndex] > intArray[index1]) continue;

                maxIndex = index1;
            } while (++index1 < intArray.length - index);
            int intermediate = intArray[intArray.length - 1 - index];
            intArray[intArray.length - 1 - index] = intArray[maxIndex];
            intArray[maxIndex] = intermediate;
        } while (++index < intArray.length);
        return intArray;
    }

    public static int[] selectionSortByDoWhileByMin(int[] intArray) {
        int index = 0;
        do {
            int minIndex = index;
            int index1 = index;
            do {
                if (intArray[minIndex] < intArray[index1]) continue;
                minIndex = index1;
            } while (++index1 < intArray.length);
            int intermediate = intArray[index];
            intArray[index] = intArray[minIndex];
            intArray[minIndex] = intermediate;
        } while (++index < intArray.length);
        return intArray;
    }

    public static int[] selectionSortByRecursionByMax(int[] intArray, int... length) {
        if (length.length == 0) {
            int start = 0;
            int maxIndex = 0;
            int rotations = 0;
            return selectionSortByRecursionByMax(intArray, start, maxIndex, rotations);
        }
        if (length[2] == intArray.length - 1) return intArray;

        if (intArray.length - length[2] == length[0]) {
            int intermediate = intArray[length[1]];
            intArray[length[1]] = intArray[intArray.length - 1 - length[2]];
            intArray[intArray.length - 1 - length[2]] = intermediate;
            int start = 0;
            int rotation = length[2] + 1;
            int maxIndex = 0;
            return selectionSortByRecursionByMax(intArray, start, maxIndex, rotation);
        }
        if (intArray.length - length[2] > length[0]) {
            if (intArray[length[1]] > intArray[length[0]]) {
                int start = length[0] + 1;
                int maxIndex = length[1];
                int rotation = length[2];
                return selectionSortByRecursionByMax(intArray, start, maxIndex, rotation);
            }
            int maxIndex = length[0];
            int start = length[0] + 1;
            int rotation = length[2];
            return selectionSortByRecursionByMax(intArray, start, maxIndex, rotation);

        }
        return intArray;
    }

    public static int[] selectionSortByRecursionByMin(int[] intArray, int... params){
        if(params.length == 0){
            int start = 0;
            int minIndex =0;
            int rotation =0;
            return selectionSortByRecursionByMin(intArray,start,minIndex,rotation);
        }
        if(params[2] == intArray.length-1) return intArray;
        if(params[0] == intArray.length){
            int intermediate = intArray[params[2]];
            intArray[params[2]] = intArray[params[1]];
            intArray[params[1]] = intermediate;
            int start = params[2]+1;
            int minIndex = params[2]+1;
            int rotation = params[2]+1;
            return selectionSortByRecursionByMin(intArray,start,minIndex,rotation);
        }
        if(params[0]<intArray.length){
            if(intArray[params[1]] < intArray[params[0]]){
                int start = params[0]+1;
                int minIndex = params[1];
                int rotation = params[2];
                return selectionSortByRecursionByMin(intArray,start,minIndex,rotation);
            }

            int minIndex = params[0];
            int start = params[0]+1;
            int rotation = params[2];
            return  selectionSortByRecursionByMin(intArray,start,minIndex,rotation);

        }
        return intArray;

    }
}
