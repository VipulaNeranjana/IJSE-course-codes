import java.util.Arrays;

public class Loop7 {
    public static void main(String[] args) {
        var nums = new int[] {10,20,30,40,50,60,70,80,90,100};
        var nums2 = new int[nums.length];
        int i = 0;
        while (i< nums.length){
            nums2[i] = nums[nums.length-1 - i];
            i++;
        }
        nums = nums2;
        System.out.println(Arrays.toString(nums));
    }
}
