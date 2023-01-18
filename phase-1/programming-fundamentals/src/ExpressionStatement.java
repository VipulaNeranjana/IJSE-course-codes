import java.util.Scanner;

public class ExpressionStatement {
    public static void main(String[] args) {
        // assignment statement
        int x = 10;
        x = 10 + 20;

        //postfix increment
        x++;

        //postfix decrement
        x--;

        //prefix increment
        ++x;
        //prefix decrement
        --x;
        //method invocation
        System.out.println("IJSE");

        // class instance creation expression
        new Scanner(System.in);
    }
}
