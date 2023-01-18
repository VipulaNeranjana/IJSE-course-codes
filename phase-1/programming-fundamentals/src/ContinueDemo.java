import java.util.Scanner;

public class ContinueDemo {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("enter your contact no:");
        String number = scanner.nextLine();

        if (number.length() != 11 || number.charAt(3) !='-'){
            System.out.println("invalid no");
        }
        else{
            char[] charNo = number.toCharArray();
            boolean isValid = true;
            for (int i = 0; i < 11; i++) {
                if (i == 3) continue;
                if (!Character.isDigit(charNo[i])) {
                    System.out.println("invalid no");
                    isValid=false;
                    break;
                };

            }
            if (isValid) System.out.println("valid");

        }
    }
}
