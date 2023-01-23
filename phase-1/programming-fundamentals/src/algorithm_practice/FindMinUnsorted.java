package algorithm_practice;

public class FindMinUnsorted {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,6,3,9,5,-5,1,0,8};

        findMinByForLoop(numbers);
        findMinByWhileLoop(numbers);
        findMinByDoWhileLoop(numbers);
        findMinByForEachLoop(numbers);
        findMinByRecursion(numbers,numbers.length, 0);

    }
    public static void findMinByForLoop(int[] intArray){
        int minimum = intArray[0];
        for (int index = 0; index < intArray.length; index++) {
            if(minimum < intArray[index]) continue;
            minimum = intArray[index];
        }
        System.out.println(minimum);
    }

    public static void findMinByWhileLoop(int[] intArray){
        int minimum = intArray[0];
        int index = 0;
        while (index++<intArray.length-1){
            if(intArray[index] > minimum) continue;
            minimum = intArray[index];
        }
        System.out.println(minimum);
    }

    public static void findMinByDoWhileLoop(int[] intArray){
        int minimum = intArray[0];
        int index = 0;
        do{
            if(minimum < intArray[index]) {
                continue;
            }
            minimum = intArray[index];
        }while (++index<intArray.length);
        System.out.println(minimum);
    }

    public static void findMinByForEachLoop(int[] intArray){
        int minimum = intArray[0];
        for (int number : intArray) {
            if(minimum< number) continue;;
            minimum = number;
        }
        System.out.println(minimum);
    }

    public static void findMinByRecursion(int[] intArray,int length,int assumedMin){
        if(length == intArray.length){
            assumedMin = intArray[0];
            findMinByRecursion(intArray,--length,assumedMin);
            return;
        }
        if(length-1 == 0) {
            if (assumedMin< intArray[length]){
                System.out.println(assumedMin);
                return;
            }
            assumedMin = intArray[length-1];
            System.out.println(assumedMin);
            return;

        }
        if(intArray[length-1] < assumedMin){
            assumedMin = intArray[length-1];
            findMinByRecursion(intArray,--length,assumedMin);
            return;
        }
        findMinByRecursion(intArray,--length,assumedMin);
    }
}
