import java.util.Arrays;

public class Loop11 {
    public static void main(String[] args) {
        var nums = new int[]{10,25,30,0,-25,-4,15,20};

        var maxIndex = nums.length -1;   //ctrl + F8 to debug point (break point)
        var max = nums[maxIndex];

        var i=0;
        while(i<5){
            System.out.println(i);
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
