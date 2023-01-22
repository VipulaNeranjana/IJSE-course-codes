package algorithams;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {


        int[] values = new int[]{10, 3, -3, 2, 5, 7, 8, 10, 11};
        binarySearch(values, 11);

    }

    public static void binarySearch(int[] intArray, int value) {
        boolean canReturn = false;
        int index1 = 0;
        int[] indexes = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            indexes[i] = i;
        }

        for (int k = 0; k < intArray.length - 1; k++) {
            for (int i = 0; i < intArray.length - 1 - k; i++) {
                int intermediate = 0;
                if (intArray[i] > intArray[i + 1]) {
                    intermediate = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = intermediate;

                    intermediate = indexes[i];
                    indexes[i] = indexes[i + 1];
                    indexes[i + 1] = intermediate;
                }
            }
        }
        int[] sortedIntArray = intArray;

        int index2 = sortedIntArray.length - 1;


        if (value < sortedIntArray[0] || value > sortedIntArray[sortedIntArray.length - 1]) {
            System.out.println("value is not in the array");
            canReturn = true;
        }

        while (!canReturn) {

            if (sortedIntArray[(index1 + index2) / 2] == value) {
                System.out.println("value : " + sortedIntArray[(index1 + index2) / 2] + " index : " + indexes[(index1 + index2) / 2]);
                canReturn = true;
                break;
            }
            if (sortedIntArray[(index1 + index2) / 2] > value) {
                index2 = (index1 + index2 + 1) / 2;
            }
            if (sortedIntArray[(index1 + index2) / 2] < value) {
                index1 = (index1 + index2 + 1) / 2;
            }

        }
    }
}
