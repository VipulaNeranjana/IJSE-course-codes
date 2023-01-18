public class Loop4 {
    public static void main(String[] args) {
        int i = 1;
        while (i++ < 7){
            int x = 1;
            while (x++ < i ) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        int k = 7;
        while (k-- > 1){
            int g = 1;
            while (g++ < k ) {
                System.out.print("*");
            }
            System.out.print("\n");
        }



    }
}
