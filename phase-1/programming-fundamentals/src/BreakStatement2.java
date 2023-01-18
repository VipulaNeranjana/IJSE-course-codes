import java.util.Scanner;

public class BreakStatement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the day: ");
        String day = scanner.nextLine().toLowerCase();

        switch (day){
            default: {
                System.out.println("You entered a wrong answer!");
                break;
            }
            case "monday": {
                System.out.println("monday");
                break;
            }
            case "tuesday": {
                System.out.println("tuesday");
                break;
            }
            case "thursday": {
                System.out.println("thursday");
                break;
            }
            case "wednesday": {
                System.out.println("wednesday");
                break;
            }
            case "friday": {
                System.out.println("friday");
                break;
            }
            case "saturday": {
                System.out.println("saturday");
            }
                break;
            case "sunday":
                System.out.println("sunday");
                break;
        }

    }
}
