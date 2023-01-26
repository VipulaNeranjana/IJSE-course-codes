package algorithm_practice;

import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        int[] g = new int[]{2,4,7,2,0,5,8};
        System.out.println(Arrays.toString(bubbleSort(g)));

    }
    public static int[] bubbleSort(int[] intArray){
        for (int i = 0; i <intArray.length ; i++) {
            for (int j = intArray.length-1; j > i ; j--) {
                if(intArray[j]>intArray[j-1]) continue;
                int intermediate = intArray[j];
                intArray[j] = intArray[j-1];
                intArray[j-1]= intermediate;
            }
        }
        return intArray;
    }
//    public static int[] bubbleSort(int[] intArray,int... params){
//        if(params.length == 0){
//            int start = intArray.length-1;
//            int rotations = 0;
//            return bubbleSort(intArray,start,rotations);
//        }
//        else if(params[1]==intArray.length-1)return intArray;
//        else if(params[0]==0+params[1]){
//            int start = intArray.length-1;
//        }
//    }
}
