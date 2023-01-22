package algorithams;

import miscellaneous.FindDuplicates;

import java.util.Arrays;

public class LinerSort {
    public static void main(String[] args) {
        int[] numArray = new int[] {0,2,-3,42,5,63,0,8};
        System.out.println(Arrays.toString(linearSortByWhileLoop(numArray)));
    }

    public static int[] linerSortByForLoop(int[] intArray){
        for(int i=0; i< intArray.length-1 ; i++){
            int smallNumber = intArray[i];
            int index = i;
            for (int j = i; j < intArray.length ; j++) {
                if (intArray[j]>smallNumber) continue;
                if (intArray[j]<smallNumber) {
                    smallNumber = intArray[j];
                    index = j;
                }
            }
            intArray[index] = intArray[i];
            intArray[i] = smallNumber;
        }
        return intArray;
    }

    public static int[] linearSortByDoWhileLoop(int[] intArray){
        int i = 0;
        do{
            int smallNumber = intArray[i];
            int index = i;
            int j = i+1;
            do{
                if(smallNumber<intArray[j]) continue;
                if(smallNumber> intArray[j]){
                    smallNumber = intArray[j];
                    index = j;
                }
            }while(++j<intArray.length);
            int intermediate = intArray[i];
            intArray[i] = smallNumber;
            intArray[index] = intermediate;
        }while (++i<intArray.length-1);

        return intArray;
    }

    public static int[] linearSortByWhileLoop(int[] intArray){
        int i = 0;
        while (i<intArray.length -1){
            int j = i+1;
            int minIndex = i;
            while (j < intArray.length){
                if(intArray[minIndex] <= intArray[j]) {
                    j++;
                    continue;
                }
                if(intArray[minIndex] > intArray[j]) {
                    minIndex = j;
                    j++;
                }
            }
            int intermediate = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = intermediate;
            i++;
        }
        return intArray;
    }
}
