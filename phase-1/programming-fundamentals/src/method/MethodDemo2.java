package method;

import java.util.Scanner;

public class MethodDemo2 {
    public static void main(String[] args) {

        boolean validInput = false;
        String input = null;
        var scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int totalMarks = 0;
        String[] subjects = new String[]{"oop","dbms","aap"};
        for (String i:subjects) {
            totalMarks = totalMarks + requestMarks(i);
        }
        

        System.out.println("Total marks: " + (totalMarks));
        System.out.println("Total marks: " + (totalMarks)/3.0);
    }

    public static boolean isValidMarks(String input){
        char[] newchar = input.toCharArray();
        for (char c : newchar) {
            if(!Character.isDigit(c)) return false;
        }
        int marks = Integer.parseInt(input);
        return  marks >= 0 && marks <=100;
    }

    public static int requestMarks(String subject){
        Scanner scanner = new Scanner(System.in);
        String input = null;
        boolean validInput =false;
        do {
            System.out.printf("Enter marks for %s : ", subject);
            input = scanner.nextLine();           //to do: validate the input

            validInput = isValidMarks(input);

            if(!validInput) System.out.println("Invalid input");
        } while (!validInput);
        return  Integer.parseInt(input);

    }
}
