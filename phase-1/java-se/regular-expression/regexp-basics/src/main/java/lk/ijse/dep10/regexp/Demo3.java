package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input;
            do {
                System.out.print("Enter your dob (yyyy-mm-dd): ");
                input = scanner.nextLine();
            }while (input.isBlank());
            System.out.println(isValidDob(input));
        }
    }

    private static boolean isValidDob(String dob){
        return dob.matches("(19\\d{2}|2\\d{3})-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])");
//        char[] dobChar = dob.toCharArray();
//        if(dob.length() != 10 || dobChar[4] != '-' || dobChar[7] != '-') return false;
//
//        if(Integer.parseInt(dob.substring(0,4)) < 1900 || Integer.parseInt(dob.substring(5,7)) > 12 || Integer.parseInt(dob.substring(5,7)) < 1 || Integer.parseInt(dob.substring(8,10)) < 1  || Integer.parseInt(dob.substring(8,10)) > 31) return false;
//
//        return true;

    }
}
