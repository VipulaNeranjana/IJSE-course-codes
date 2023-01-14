import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("enter your grade:");
        String grade = scanner.nextLine();

        if (grade.toUpperCase().equals("A")) System.out.println("A pass!");
        else if (grade.toUpperCase().equals("B")) System.out.println("B pass!");
        else if (grade.toUpperCase().equals("C")) System.out.println("C pass!");
        else if (grade.toUpperCase().equals("F")) System.out.println("Fail!");
        else System.out.println("invalid grade");


        switch (grade) {
            case "A":
            case "a":
                System.out.println("A pass!!");
                break;
            case "B":
            case "b":
                System.out.println("B pass!!");
                break;
            case "C":
            case "c":
                System.out.println("C pass!!");
                break;
            case "F":
            case "f":
                System.out.println("Fail POS!!");
                break;
            default:
                System.out.println("invalid grade!!");
        }


    }
}
