package algorithm_practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 4, 2, 8, 9, 4, -2, -6, 8, 0, 7};

//        System.out.println(Arrays.toString(bubbleSortByForLoopByMin(numbers)));
//        System.out.println(Arrays.toString(bubbleSortByForLoopByMax(numbers)));
//        System.out.println(Arrays.toString(bubbleSortByWhileLoopByMin(numbers)));
//        System.out.println(Arrays.toString(bubbleSortByWhileLoopByMax(numbers)));
//        System.out.println(Arrays.toString(bubbleSortByDoWhileLoopMax(numbers)));
//        System.out.println(Arrays.toString(bubbleSortByDoWhileLoopByMin(numbers)));
//        System.out.println(Arrays.toString(bubbleSortByRecursionByMin(numbers)));
        System.out.println(Arrays.toString(bubbleSortByRecursionByMax(numbers)));
    }

    public static int[] bubbleSortByForLoopByMin(int[] intArray) {
        for (int index = 0; index < intArray.length; index++) {
            for (int index1 = 0; index1 < intArray.length - 1 - index; index1++) {
                if (intArray[intArray.length - 1 - index1] > intArray[intArray.length - 2 - index1]) continue;
                int intermediate = intArray[intArray.length - 1 - index1];
                intArray[intArray.length - 1 - index1] = intArray[intArray.length - 2 - index1];
                intArray[intArray.length - 2 - index1] = intermediate;
            }
        }
        return intArray;
    }

    public static int[] bubbleSortByForLoopByMax(int[] intArray) {
        for (int index = 0; index < intArray.length; index++) {
            for (int index1 = 0; index1 < intArray.length - 1 - index; index1++) {
                if (intArray[index1] < intArray[index1 + 1]) continue;
                ;
                int intermediate = intArray[index1];
                intArray[index1] = intArray[index1 + 1];
                intArray[index1 + 1] = intermediate;
            }
        }
        return intArray;
    }

    public static int[] bubbleSortByWhileLoopByMin(int[] intArray) {
        int index = 0;
        while (index < intArray.length) {
            int index1 = intArray.length - 1;
            while (index1 > index) {
                if (intArray[index1] > intArray[index1 - 1]) {
                    index1--;
                    continue;
                }
                int intermediate = intArray[index1];
                intArray[index1] = intArray[index1 - 1];
                intArray[index1 - 1] = intermediate;
                index1--;
            }
            index++;
        }
        return intArray;
    }

    public static int[] bubbleSortByWhileLoopByMax(int[] intArrays) {
        int index = 0;
        while (index < intArrays.length - 1) {
            int index1 = 0;
            while (index1 < intArrays.length - 1 - index) {
                if (intArrays[index1] < intArrays[index1 + 1]) {
                    index1++;
                    continue;
                }
                int intermediate = intArrays[index1];
                intArrays[index1] = intArrays[index1 + 1];
                intArrays[index1 + 1] = intermediate;
                index1++;
            }
            index++;
        }
        return intArrays;
    }

    public static int[] bubbleSortByDoWhileLoopMax(int[] intArray) {
        int index = 0;
        do {
            int index1 = 0;
            do {
                if (intArray[index1] < intArray[index1 + 1]) {
                    continue;
                }
                int intermediate = intArray[index1];
                intArray[index1] = intArray[index1 + 1];
                intArray[index1 + 1] = intermediate;

            } while (++index1 < intArray.length - 1 - index);

        } while (++index < intArray.length - 1);
        return intArray;
    }

    public static int[] bubbleSortByDoWhileLoopByMin(int[] intArray) {
        int index = 0;
        do {
            int index1 = intArray.length - 1;
            do {
                if (intArray[index1] > intArray[index1 - 1]) continue;
                int intermediate = intArray[index1];
                intArray[index1] = intArray[index1 - 1];
                intArray[index1 - 1] = intermediate;

            } while (index < --index1);
        } while (++index < intArray.length - 1);
        return intArray;
    }

    public static int[] bubbleSortByRecursionByMin(int[] intArray, int... params) {
        if (params.length == 0) {
            int start = intArray.length - 1;
            int rotations = 0;
            return bubbleSortByRecursionByMin(intArray, start, rotations);
        } else if (params[1] == intArray.length - 1) return intArray;
        else if (params[0] == params[1]) {
            int start = intArray.length - 1;
            int rotation = params[1] + 1;
            return bubbleSortByRecursionByMin(intArray, start, rotation);
        } else if (params[0] < intArray.length) {
            if (intArray[params[0]] > intArray[params[0] - 1]) {
                int start = params[0] - 1;
                int rotation = params[1];
                return bubbleSortByRecursionByMin(intArray, start, rotation);
            }
            int intermediate = intArray[params[0]];
            intArray[params[0]] = intArray[params[0] - 1];
            intArray[params[0] - 1] = intermediate;
            int start = params[0] - 1;
            int rotation = params[1];
            return bubbleSortByRecursionByMin(intArray, start, rotation);
        }
        return intArray;
    }

    public static int[] bubbleSortByRecursionByMax(int[] intArray, int... params) {
        if (params.length == 0) {
            int start =0;
            int rotation = 0;
            return bubbleSortByRecursionByMax(intArray,start,rotation);
        }
        else if (params[1] == intArray.length-1) return intArray;
        else if (params[0] == intArray.length-1 - params[1]){
            int start = 0;
            int rotation = params[1]+1;
            return bubbleSortByRecursionByMax(intArray,start,rotation);
        }
        else if (params[0] < intArray.length - params[1]){
            if(intArray[params[0]] < intArray[params[0]+1]){
                int start = params[0]+1;
                int rotation = params[1];
                return bubbleSortByRecursionByMax(intArray,start,rotation);
            }
            int intermediate = intArray[params[0]];
            intArray[params[0]] = intArray[params[0]+1];
            intArray[params[0]+1] = intermediate;

            int start = params[0]+1;
            int rotation = params[1];
            return bubbleSortByRecursionByMax(intArray,start,rotation);
        }
        else return intArray;
    }
}
