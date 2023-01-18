public class BreakStatement1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration start:"+i);

            if (i==2) break;

            System.out.println("Iteration end:"+i);

        }
        System.out.println("After the loop");
    }
}
