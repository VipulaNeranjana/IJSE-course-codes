public class Array2 {
    public static void main(String[] args) {
        int[] nums;
        int[] nums2;
        int[] nums3 = {4, 5, 6};
        int[] nums4 = new int[]{5, 6, 7};

        nums = new int[]{10, 20, 30};
        System.out.println(nums);

        nums2 = new int[3];
        System.out.println(nums2[0]);
        System.out.println(nums2[1]);  //default value is initialized to the array (0)
        System.out.println(nums2[2]);
    }
}
