import java.util.Scanner;

public class IfStatement {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a number grater than 25:");
        int number = scanner.nextInt();
        if (number > 25) {
            System.out.println("Grater than 25");
            System.out.println("Valid number :" + number);
        } else if (number > 15) {
            System.out.println("Grater than 15");
        } else if (number > 10) {
            System.out.println("Grater than 10");
        }
        else System.out.println("Invalid number");


    }
}
