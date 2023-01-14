public class Array {
    int p = 10; // this is not a local variable, it is a field

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};
        String[] y = {"kasun", "nuwan", "ruwan"};
        String[] z = {};

        System.out.println("=========================");
        System.out.println(z);
        System.out.println(y);
        z = y;

        System.out.println(z);
        System.out.println(y);
        System.out.println("=========================");

        System.out.println(y);
        System.out.println(x[1]);


        x[1] = 25;
        System.out.println(x[1]);
        System.out.println("my name is khan");
    }
}
