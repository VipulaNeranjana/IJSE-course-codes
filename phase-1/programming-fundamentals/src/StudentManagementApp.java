import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("            Student Management System             ");
        System.out.println("--------------------------------------------------");

        var scanner = new Scanner(System.in);

        System.out.print("Enter your name   :");
        String name = scanner.nextLine();

        System.out.print("Enter contact no  :");
        String contactNo = scanner.nextLine();

        System.out.print("Enter the batch   :");
        int batch = scanner.nextInt();

        System.out.println("--------------------------------------------------");
        System.out.printf("welcome %s (%s) to batch %s \n", name, contactNo, batch);  //formatted  way to print string
        System.out.println("welcome " + name + " " + contactNo + " to batch" + batch);
    }
}
