import java.util.Scanner;

public class standeredStream {
    public static void main(String[] args) {
       // System.err.println("error");
        System.out.println("ijse");

        System.out.print("type something:");
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();

        System.out.println(input);



        scanner.useDelimiter("-");  // to change the split icon
        var first = scanner.next();
        var second = scanner.next();
        var third = scanner.next();

        System.out.println(second);

    }
}
