package algorithm_practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {

        int[] h = new int[]{1,2,9,4,0,1,2};

        System.out.println(Arrays.toString(findMinMax(h)));

    }
    public static int[] findMinMax(int[] nums){
        int index = 0;
        int min = 0;
        int max = 0;
        do{
            if (nums[min]> nums[index]){
                min = index;
            }
            if (nums[max]< nums[index]){
                max = index;
            }
        }while(++index<nums.length);
        return new int[]{nums[max], nums[min]};
    }
}


