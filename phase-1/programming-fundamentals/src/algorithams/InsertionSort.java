package algorithams;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] values = new int[] {-7,3,5,20,2};

        System.out.println(Arrays.toString(linearInsertionSort(values)));
    }

    public static int[] linearInsertionSort(int[] intArray){
        for (int i = 0; i < intArray.length-1; i++) {
            if(intArray[i+1] > intArray[i]) continue;

            for (int j = 0; j < i; j++) {
                if (intArray[j] < intArray[i+1]) continue;
                int maxint = intArray[i+1];
                for (int k = i+1; k > j; k--) {
                    intArray[k] = intArray[k-1];
                }
                intArray[j] = maxint;
            }
        }

        return intArray;
    }
}
