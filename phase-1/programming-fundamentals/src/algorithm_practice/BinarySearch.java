package algorithm_practice;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = new int[]{-8, -1, 2, 5, 5, 9};

        binarySearchByForLoop(9, numbers);
        binarySearchByWhile(-8, numbers);
        binarySearchByDoWhile(9,numbers);
        binarySearchBtRecursion(-8,numbers);
    }

    public static void binarySearchByForLoop(int input, int[] intArray) {
        int index1 = intArray.length;
        int index = 0;
        for (; true; ) {
            if (input == intArray[(index + index1) / 2]) {
                System.out.println((index + index1) / 2);
                break;
            } else if (input < intArray[(index + index1) / 2]) {
                index1 = (index + index1) / 2;
            } else if (input > intArray[(index + index1) / 2]) {
                index = (index + index1) / 2;
            }
        }
    }

    public static void binarySearchByWhile(int input, int[] intArray) {
        int index = 0;
        int index1 = intArray.length;

        while (true) {
            if (intArray[(index + index1) / 2] == input) {
                System.out.println((index + index1) / 2);
                break;
            } else if (intArray[(index + index1) / 2] < input) {
                index = (index + index1) / 2;
            } else if (intArray[(index + index1) / 2] > input) {
                index1 = (index + index1) / 2;
            }
        }
    }

    public static void binarySearchByDoWhile(int input, int[] intArray) {
        int index = 0;
        int index1 = intArray.length;
        do {
            if (intArray[(index + index1) / 2] == input) {
                System.out.println((index + index1) / 2);
                break;
            } else if (intArray[(index + index1) / 2] > input) {
                index1 = (index + index1) / 2;
            } else if (intArray[(index + index1) / 2] < input) {
                index = (index + index1) / 2;
            }
        } while (true);
    }
    public static void binarySearchBtRecursion(int input, int[] inputArray, int... params){
        if(params.length==0){
            int index = 0;
            int index1 = inputArray.length;
            binarySearchBtRecursion(input,inputArray,index,index1);
            return;
        }
        if(inputArray[((params[0]+params[1])/2)] == input){
            System.out.println(((params[0]+params[1])/2));
            return;
        }
        if(inputArray[((params[0]+params[1])/2)]<input){
            int index = ((params[0]+params[1])/2);
            binarySearchBtRecursion(input,inputArray,index,params[1]);
        }
        if(inputArray[((params[0]+params[1])/2)]>input){
            int index1 =((params[0]+params[1])/2);
            binarySearchBtRecursion(input,inputArray,params[0],index1);
        }
    }
}
