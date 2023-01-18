import java.util.Arrays;

public class Loop10 {
    public static void main(String[] args) {
        var nums = new int[] {10,25,30,0,-25,-4,15,20};

        /* selection sort by max number */
//        int index1 = nums.length -1;
//        int index2;
//        int maxIndex=nums.length -1;
//        while(index1 >= 0){
//            index2 = index1;
//            while (index2 >=0 ) {
//                if(nums[maxIndex]<nums[index2]){
//                    maxIndex = index2;
//                    index2--;
//                }
//                else {
//                    index2--;
//                }
//            }
//            int intermediatNumber = nums[maxIndex];
//            nums[maxIndex] = nums[index1];
//            nums[index1] = intermediatNumber;
//            index1--;
//        }

        int index2;
        int maxIndex=nums.length -1;
        for(int index1= nums.length-1; index1>= 0; index1--){

            for (index2 = index1; index2 >=0; index2-- ) {
                if(nums[maxIndex]<nums[index2]){
                    maxIndex = index2;
                }

            }
            int intermediatNumber = nums[maxIndex];
            nums[maxIndex] = nums[index1];
            nums[index1] = intermediatNumber;
        }

        System.out.println(Arrays.toString(nums)); /* [-25,-4,0,10,15,20,25,30] */
    }
}
