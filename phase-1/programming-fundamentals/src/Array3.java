public class Array3 {
    public static void main(String[] args) {
        int[][] array2d = new int[3][];
        int[] nums = new int[3];

        System.out.println(array2d[0]);
        System.out.println(array2d[1]);
        System.out.println(array2d[2]);

        array2d[1] = new int[]{1, 2, 3};
        array2d[0] = nums;

        System.out.println("-----------------print array2d[1][1]---------------");
        System.out.println(array2d[1][1]);

        array2d[0][1] = 30;
        System.out.println("------------------print nums value which is changed by array2d------------------");
        System.out.println(nums[1]);


    }
}
