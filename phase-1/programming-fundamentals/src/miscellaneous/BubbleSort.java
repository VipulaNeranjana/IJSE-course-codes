package miscellaneous;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] values = new int[]{3,2,3,5,7,1,0};

       // System.out.println(Arrays.toString(BubbleSort(values)));
//        System.out.println(Arrays.toString(BubbleSortByDoWhile(values)));
        System.out.println(Arrays.toString(bubbleSortByWhile(values)));
    }

    public static int[] BubbleSort(int[] intArray){
        for (int k = 0; k < intArray.length -1; k++) {
            for (int i = 0; i < intArray.length-1 -k  ; i++){
                int intermediate = 0;
                if ( intArray[i] > intArray[i+1]){
                    intermediate = intArray[i];
                    intArray[i] = intArray[i+1];
                    intArray[i+1] = intermediate;
                }
            }
        }
        return  intArray;
    }



    public static int[] BubbleSortByDoWhile(int[] intArray){
        int itteration = 0;
        do {
            int index = 0;
            do{
                if (intArray[index] > intArray[index+1]){
                    int intermediate = intArray[index];
                    intArray[index] = intArray[index+1];
                    intArray[index+1] = intermediate;
                }
            }while (++index < intArray.length -1 - itteration);
        } while (++itteration < intArray.length -1);

        return intArray;
    }

    public static int[] bubbleSortByWhile(int[] intArray){
        int j = 0;
        while (j++ < intArray.length) {
            int i = 0;
            int arrayLength = intArray.length;
            while(i < arrayLength-j){
                if(intArray[i] < intArray[i+1]) {
                    i++;
                    continue;
                };
                int intermediateNumber = intArray[i];
                intArray[i] = intArray[i+1];
                intArray[i+1] = intermediateNumber;
                i++;
            }
        }
        return intArray;
    }
}
