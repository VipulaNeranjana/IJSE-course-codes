package algorithm_practice;

public class FindMaxUnsorted {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,6,3,9,5,-5,1,0,8};
        findHighestValueByForLoop(numbers);
        findHighestValueByWhileLoop(numbers);
        findHighestValueByDoWhileLoop(numbers);
        findHighestValueByForEachLoop(numbers);
        findHighestValueByRecursion(numbers,0,0);
    }

    public static void findHighestValueByForLoop(int[] intArray){
        int maxNum = intArray[1];
        for (int index = 0; index < intArray.length-1; index++) {
            if(intArray[index] < maxNum) continue;
            maxNum = intArray[index];
        }
        System.out.println(maxNum);
    }
    public static void findHighestValueByWhileLoop(int[] intArray){
        int index = 0;
        int maxLength = 0;
        while(index < intArray.length-1){
            if(intArray[index] < maxLength) {
                index++;
                continue;
            }
            maxLength = intArray[index];
            index++;
        }
        System.out.println(maxLength);
    }

    public static void findHighestValueByDoWhileLoop(int[] intArray){
        int index = 0;
        int maxNumber=intArray[0];
        do{
            if(intArray[index]<maxNumber) {
                continue;
            }
            maxNumber = intArray[index];
        }while (++index<intArray.length-1);
        System.out.println(maxNumber);
    }

    public static void findHighestValueByForEachLoop(int[] intArray){
        int maxNum = intArray[0];
        for (int number : intArray) {
            if(maxNum > number ) continue;
            maxNum = number;
        }
        System.out.println(maxNum);
    }

    public static void findHighestValueByRecursion(int[] intArray,int assumedMaxNumber, int startingPoint){
        if (startingPoint==0){
            assumedMaxNumber = intArray[0];
            findHighestValueByRecursion(intArray,assumedMaxNumber,++startingPoint);
            return;
        }
        if (startingPoint == intArray.length) {
            System.out.println(assumedMaxNumber);
            return;
        }
        if(assumedMaxNumber > intArray[startingPoint]){
            findHighestValueByRecursion(intArray,assumedMaxNumber,++startingPoint);
            return;
        }
        assumedMaxNumber = intArray[startingPoint];
        findHighestValueByRecursion(intArray,assumedMaxNumber,++startingPoint);
        return;
    }
}
