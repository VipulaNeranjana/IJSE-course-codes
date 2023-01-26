package algorithm_practice;

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        int[] g = new int[]{1,3,6,2,8,4};
        System.out.println(Arrays.toString(sort(g)));

    }
    public static int[] sort(int[] intArray){
        int index =intArray.length-1;
        do {
            int max = 0;
            int index1 = 0;
            do{
                if (intArray[index1] < intArray[index1+1]) max = index1+1;
            }while (++index1<index-1);
            int intermediate = intArray[max];
            intArray[max] = intArray[index];
            intArray[index]= intermediate;
        }while(--index > 0);
        return intArray;
    }
}
