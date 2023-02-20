package lk.ijse.dep10.app;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your nic");
        String input = scanner.nextLine().strip();

        if(input.length() != 10){
            System.out.println("invalid input");
            return;
        }
        String inputNineChars = input.substring(0, input.length() - 1);

        if(isInteger(inputNineChars) && (input.toUpperCase().endsWith("V"))){
            System.out.println("valid nic!");
        }else {
            System.out.println("invalid nic");
        }

    }

    public static boolean isInteger(String number){

        try {
            Integer.parseInt(number);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }

//        for (char c : number.toCharArray()) {
//            if(!Character.isDigit(c)) return false;
//        }
//        return true;
    }
}
