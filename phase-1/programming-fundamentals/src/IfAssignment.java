import java.util.Scanner;

public class IfAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name:");
        String name = scanner.nextLine();
        System.out.print("Enter the age:");
        int age = scanner.nextInt();

        if (age < 18 ) System.out.println("invalid");
        else if (age > 40) System.out.println("invalid");
        else System.out.println(name);
    }
}
