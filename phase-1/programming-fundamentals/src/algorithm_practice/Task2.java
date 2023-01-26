package algorithm_practice;

public class Task2 {
    public static void main(String[] args) {

        int[] h = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(findNo(h,3));

    }

    public static String findNo(int[] intArray,int no,int... params){
        if(params.length==0){
            int start =0;
            int found = -1;
            return findNo(intArray,no,start,found);
        }
        else if(params[0]==intArray.length-1){
            if(params[1]== -1) return "not found";
            return "found at " + params[1];
        }

        else if(params[0] <intArray.length-1){
            int found = params[2];
            if(no == intArray[params[0]]){
                found = params[0];
                return findNo(intArray,no,intArray.length-1,found);
            }
            int start =params[0]+1;
            return findNo(intArray,no,start,found);
        }

        return findNo(intArray,no);
    }
}
