package algorithm_practice;

import java.io.OptionalDataException;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] numArray = new int[]{1, 2, 3, 4, 7, 3, 5, 1, 8, 9, 0, 1};
        //System.out.println(Arrays.toString(linearSearchByFroEach(numArray,1)));
        System.out.println(Arrays.toString(linearSearchByRecursion(numArray, numArray.length - 1, 1, "")));
        //System.out.println(Arrays.toString(numArray));
    }

    public static int[] linearSearchByFor(int[] intArrayInput, int inputNumber) {
        int[] intArray = intArrayInput;
        int[] indexes = new int[1];
        int[] indexes2 = new int[1];
        for (int index = 0; index < intArray.length; index++) {
            if (inputNumber != intArray[index]) continue;
            if (inputNumber == intArray[index]) {
                for (int i = 0; i <= indexes.length - 1; i++) {
                    if (indexes.length - 1 == i) {
                        indexes[i] = index;
                        continue;
                    }
                    indexes[i] = indexes2[i];
                }
                indexes2 = indexes;
                indexes = new int[indexes2.length + 1];

            }
        }
        return indexes2;
    }

    public static int[] linearSearchByWhile(int[] intArrayInput, int inputNumber) {
        int[] intArray = intArrayInput;
        int[] indexes = new int[1];
        int[] indexes1 = new int[1];
        int index = 0;
        while (index < intArray.length) {
            if (intArray[index] != inputNumber) {
                index++;
                continue;
            }
            int indexInIndexArray = 0;
            while (indexInIndexArray < indexes.length) {
                if (indexInIndexArray == indexes.length - 1) {
                    indexes[indexInIndexArray] = index;
                    indexInIndexArray++;
                    continue;
                }
                indexes[indexInIndexArray] = indexes1[indexInIndexArray];
                indexInIndexArray++;
            }
            indexes1 = indexes;
            indexes = new int[indexes1.length + 1];
            index++;

        }
        return indexes1;
    }

    public static int[] linearSearchByDoWhile(int[] intArray, int inputNumber) {
        int[] intArray1 = intArray;
        int[] indexes = new int[1];
        int[] indexes1 = new int[1];
        int i = 0;
        do {
            if (inputNumber != intArray1[i]) continue;
            int indexOfIndexArray = 0;
            do {
                if (indexes.length - 1 == indexOfIndexArray) {
                    indexes[indexOfIndexArray] = i;
                    continue;
                }
                indexes[indexOfIndexArray] = indexes1[indexOfIndexArray];

            } while (++indexOfIndexArray < indexes.length);

            indexes1 = indexes;
            indexes = new int[indexes.length + 1];

        } while (++i < intArray1.length);

        return indexes1;
    }

    public static int[] linearSearchByFroEach(int[] intArray, int inputNumber) {
        int[] intArray1 = intArray;
        int[] indexes = new int[1];
        int[] indexes1 = new int[1];

        int index = 0;
        for (int number : intArray1) {
            if (inputNumber != intArray1[index]) {
                index++;
                continue;
            }

            int indexOfIndexOfArray = 0;
            for (int indexOfIntArray : indexes) {
                if (indexOfIndexOfArray == indexes.length - 1) {
                    indexes[indexOfIndexOfArray] = index;
                    indexOfIndexOfArray++;
                    continue;
                }
                indexes[indexOfIndexOfArray] = indexes1[indexOfIndexOfArray];
                indexOfIndexOfArray++;

            }
            indexes1 = indexes;
            indexes = new int[indexes1.length + 1];
            index++;

        }
        return indexes1;
    }

    public static String[] linearSearchByRecursion(int[] intArray, int length, int inputNumber, String output) {
        if (intArray[length] == inputNumber && length == 0) {
            output = output + length;
            return output.split(",");
        }
        if (intArray[length] == inputNumber && length != 0) {
            output = output  + length+ ",";
            length--;
            return linearSearchByRecursion(intArray,length , inputNumber, output);
        }
        if (intArray[length] != inputNumber && (length) != 0) {
            length--;
            return linearSearchByRecursion(intArray, length, inputNumber, output);
        }

        return output.split(",");
    }

}
