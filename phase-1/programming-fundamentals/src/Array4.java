public class Array4 {
    public static void main(String[] args) {
        int x = 10;
        int[] num1 = new int[]{10, 20, 30, 40};
        int[][] array2d = new int[2][];
        int[][] array2d2 = new int[3][];

        array2d[0] = new int[]{70, 80, 90};
        array2d[1] = num1;

        array2d2[0] = array2d2[2] = new int[]{40, 50, 60};
        array2d2[1] = array2d[1];

        System.out.println(num1.length);

        int[][][] array3d = new int[3][][];  /*3D array*/

        ; /*this is a empty statement*/

    }
}
