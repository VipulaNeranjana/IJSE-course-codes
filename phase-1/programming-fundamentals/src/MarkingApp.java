import java.util.Scanner;

public strictfp class MarkingApp {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("           Marking System                     ");
        System.out.println("----------------------------------------------");

        var scanner = new Scanner(System.in);

        System.out.print("Enter name              :");
        String name = scanner.nextLine();

        System.out.print("Enter the marks for pf  :");
        double pfMarks = scanner.nextDouble();

        System.out.print("Enter the marks for dbms:");
        double dbmsMarks = scanner.nextDouble();

        System.out.print("Enter the marks for oop :");
        double oopMarks = scanner.nextDouble();

        System.out.print("Enter the marks for networking:");
        double netMarks = scanner.nextDouble();

        double totalMarks = pfMarks + dbmsMarks + oopMarks + netMarks;
        double average = totalMarks / 4;

        System.out.println("------------------------------------");
        System.out.printf("%s's total marks : %s \n", name, totalMarks);
        System.out.printf("%s's average     : %s", name, average);

    }
}
