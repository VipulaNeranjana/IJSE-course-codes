package algorithm_practice;

public class Task3 {
    public static void main(String[] args) {

    }

    public static int[] reverse(int[] nums){
        return  recursion(nums,0);
    }
    public static int[] recursion(int[] intArray, int start){
        if(start == intArray.length-1) return intArray;
        else if (start< intArray.length/2) {
            int intermediate = intArray[start];
            intArray[start]= intArray[intArray.length-1-start];
            intArray[intArray.length-1-start] = intermediate;
            return recursion(intArray,++start);
        }
        return intArray;
    }
}
