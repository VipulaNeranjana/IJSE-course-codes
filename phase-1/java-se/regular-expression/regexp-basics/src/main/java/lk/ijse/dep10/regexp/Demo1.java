package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input;
            do {
                System.out.print("Enter your nic: ");
                input = scanner.nextLine();
            }while (input.isBlank());
            System.out.println(isValidNic(input));
        }
    }

    private static boolean isValidNic(String nic){
        return nic.toUpperCase().matches("\\d{9}V");
//        if(nic.length() != 10 || !nic.substring(9).equals("V")) return false;
//
//        char[] chars = nic.substring(0,9).toCharArray();
//        for (char aChar : chars) {
//            if(!Character.isDigit(aChar)) return false;
//        }
//
//        return true;

    }
}
