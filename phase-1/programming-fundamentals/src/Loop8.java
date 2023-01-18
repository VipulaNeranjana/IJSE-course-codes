import java.util.Arrays;

public class Loop8 {
    public static void main(String[] args) {
        var nums = new int[] {2,3,12,-235,1,-464,76,45,78};
        var nums2 = new int[nums.length];
        int smallest = 0;
        int index = 0;
        int intermidiatNum= 0;

        int i = 0;
        while(i < nums.length){
            smallest = nums[i];
            int f = i ;
            while (f < (nums.length)){
                if(smallest >= nums[f]) {
                    smallest = nums[f];
                    index = f;
                    f++;
                    continue;
                }
                f++;
            }
            intermidiatNum = nums[index];
            nums[index] = nums[i];
            nums[i] =intermidiatNum;

            i++;

        }

        System.out.println(Arrays.toString(nums));
    }
}
