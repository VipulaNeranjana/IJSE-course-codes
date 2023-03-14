package lk.ijse.dep10.app;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number : ");
            int result = getResult(scanner);
            System.out.println("Result : "+ result);
        }

    }

    private static int getResult(Scanner scanner) {
        try{
            int x = scanner.nextInt();
            int result = 100/x;
            return result;                                               /*finally block is execute before the returning a value*/
        }catch (ArithmeticException e){
            System.out.println("something went wrong");
            return -1;
        }finally {
            System.out.println("finally");
        }
    }
}
