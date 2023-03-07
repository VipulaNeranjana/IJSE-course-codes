package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateExercise {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date input1;
        Date input2;
        while (true) {
            System.out.print("Enter first Date : ");
            String input = scanner.nextLine();

            try {
                input1 = simpleDateFormat.parse(input);
                break;
            } catch (ParseException e) {
                System.out.println("invalid format!!!!! enter again");
                continue;
            }
        }

        while (true) {
            System.out.print("Enter Second Date : ");
            String input = scanner.nextLine();

            try {
                input2 = simpleDateFormat.parse(input);
                if(input2.before(input1)){
                    System.out.println("early date!! enter again");
                    continue;
                }
                break;
            } catch (ParseException e) {
                System.out.println("invalid format!!!!! enter again");
                continue;
            }
        }

        System.out.println((input2.getTime()-input1.getTime())/(1000*60*60*24));

        /*this java.util get method returns the long value of time in milliseconds from unix age starting date (1970/01/01 12.00 A.M)*/
    }
}
