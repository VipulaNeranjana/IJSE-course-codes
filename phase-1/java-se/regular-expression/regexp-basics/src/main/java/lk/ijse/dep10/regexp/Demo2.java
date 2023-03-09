package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input;
            do {
                System.out.print("Enter your contact: ");
                input = scanner.nextLine();
            }while (input.isBlank());
            System.out.println(isValidContact(input));
        }
    }

    private static boolean isValidContact(String contact){
        return contact.matches("([+](94)|0)\\d{2}-\\d{7}");
//        if (!(contact.length() == 11 || contact.length()==13)) return false;
//
//        char[] contactChar = contact.toCharArray();
//        if(contact.length() == 11){
//            if(contactChar[0] != '0' || contactChar[3] != '-') return false;
//            return true;
//        }
//        else {
//            if(contactChar[0] != '+' || contactChar[1] != '9' || contactChar[2] != '4' || contactChar[5] != '-') return false;
//            return true;
//        }

    }
}
