public class Operators2 {
    public static void main(String[] args) {
        int balance = 10 % 3;
        /* logical operators will not check the other conditions if the whole condition is false after first condition/s */
        System.out.println(balance);
        int a = 10;
        int b = 5;
        if (a++ < 5 && b++ > 2) {

        }
        System.out.println(a); // a = 11
        System.out.println(b); // b = 5

        /* bit-vice operators check the all of conditions if first condition/s are true or false */
        int c = 10;
        int d = 5;
        if (c++ < 5 & d++ > 2) {

        }
        System.out.println(c); // c = 11
        System.out.println(d); // d = 6

        /* ternary operators */
        String value = a > 5 ? "ijse" + (10 + 15) : "something" + (5 * 2);
        System.out.println(value);

        int a2 = true ? 15 + 1 : 10; // the both sides of the : should always be a expression
    }
}
