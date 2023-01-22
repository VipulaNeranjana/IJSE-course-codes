package miscellaneous;

import java.util.Arrays;

public class FindDuplicates {
    public static void main(String[] args) {
        var nums = new int[]{-5, 2, 2, 22, 5, 74, 5, 2, -3, 10, 21, 25, 71, 80};
//        System.out.println(-5| 2| 2| 22| 5| 74| 5| 2| 3| 10| 21| 25| 71| 80);

        findDuplicates(nums);

    }

    public static void findDuplicates(int[] intArray) {


        int sum = getSum(intArray);

        int[] numberArray = new int[]{intArray[0]};
        int[] stringArray = new int[intArray.length];

        numberArray = getInts(intArray, sum, numberArray);
        System.out.println(Arrays.toString(numberArray));

    }

    private static int[] getInts(int[] intArray, int sum, int[] numberArray) {
            boolean isAddable = false;
        int count = 0;
        for (int number : intArray) {
            if ((sum & number) == number) {
                for (int numberInNumberArray : numberArray) {
                    if (numberInNumberArray == number) {
                        isAddable = false;
                        break;
                    }
                    if( numberInNumberArray == numberArray[numberArray.length-1])
                        isAddable = true;
                }
                if (isAddable) {
                    System.out.println(number);
                    var numberArray1 = new int[numberArray.length + 1];
                    for (int j = 0; j < numberArray1.length; j++) {
                        if (j != numberArray1.length - 1) numberArray1[j] = numberArray[j];
                        if (j == numberArray1.length - 1) numberArray1[j] = number;
                    }
                    numberArray = numberArray1;
                    isAddable = false;
                }
            }



    }
        return numberArray;
    }

    private static int getSum(int[] intArray) {
        int sum = 0;
        for (int number : intArray) {
            sum = sum | number;
        }
        return sum;
    }


//        int count =0;
//        String countString = "";
//        String number = "";
//        for (int number1: intArray) {
//            for (int i = 0; i < intArray.length; i++) {
//                if((intArray[i] & sum) == number1) {
//                    count++;
////                    System.out.print(number1 + " ");
////                    System.out.println(count);
//                    if(!number.contains(Integer.toString(number1))) {
//                        number = number + " " + Integer.toString(intArray[i]);
//                        count = 1;
//                    }
//                };
//                if (i == intArray.length-1 && count != 0) {
//                    countString = countString + " " + Integer.toString(count);
//                    count = 0;
//                };
//
//            }
//        }
//
//        System.out.println(countString);
//        System.out.println(number);
    //   }
}
