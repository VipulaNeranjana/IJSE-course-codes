import java.util.Scanner;

public class SwitchStatementExercise {
    public static void main(String[] args) {
        System.out.print("Enter the month:");
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine().toUpperCase();
        int[] days = new int[12];

        switch (month) {
            case "JAN":
            case "JANUARY":
            case "1":
            case "MAR":
            case "MARCH":
            case "3":
            case "MAY":
            case "5":
            case "JUL":
            case "JULY":
            case "7":
            case "SAP":
            case "SEPTEMBER":
            case "9":
            case "NOV":
            case "NOVEMBER":
            case "11":
                System.out.println("31 days");
                break;
            case "APR":
            case "APRIL":
            case "4":
            case "JUN":
            case "JUNE":
            case "6":
            case "AUG":
            case "AUGUST":
            case "8":
            case "OCT":
            case "OCTOBER":
            case "10":
            case "DEC":
            case "DECEMBER":
            case "12":
                System.out.println("30 days");
            case "FEB":
            case "FEBRUARY":
            case "2":
                System.out.println("28 days");
                break;
            default:
                System.out.println("invalid month");


        }
    }
}
