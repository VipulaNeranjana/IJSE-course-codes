package lk.ijse.dep10.oop;

public class Shadowing {
    static int x = 10;
    public static void main(String[] args) {
        String x = "eyow";  //cant access this x
        new Object() {
            {
                int x = 20;
                System.out.println(x);
                System.out.println(Shadowing.x); //if we have a way to access the outer scope we can get the value of outer scope parameter

            }
        };
    }
}
