

public class Loop9 {
    public static void main(String[] args) {
        var nums = new int[] {10,25,30,0,-25,-4,15,20};
        int min =0;
        int minIndex =0;
        int max = 0;
        int maxIndex = 0;

//        int index1 = 0;
//        int index2 = 0;
//        int index3 = 0;
//        while(index1 < nums.length-1){
//            if(nums[index1] < nums[index2]){
//                minIndex = index1;
//                min = nums[index1];
//                index2 = index1;
//                index1++;
//            }
//            if(nums[index1] > nums[index3]){
//                maxIndex = index1;
//                max = nums[index1];
//                index3 = index1;
//                index1++;
//            }
//            else index1++;
//        }

        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] < nums[index1]){
                minIndex = i;
                min = nums[i];
                index1 = i;
            }
            if(nums[i] > nums[index2]){
                maxIndex = i;
                max = nums[i];
                index2 = i;
            }
        }


        System.out.printf("Min value: %s , Min index : %s \n",min,minIndex);
        System.out.printf("Max value: %s , Max index : %s",max,maxIndex);
    }
}
