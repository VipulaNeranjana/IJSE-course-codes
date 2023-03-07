package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class UtilDate6 {
    public static void main(String[] args) {
        int year = 0;
        int month = 0;
        int date = 0;

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar birthDate = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Date d1;
        Date d2;
        while (true) {
            System.out.print("enter the birthday : ");
            String input = scanner.nextLine();
            try {
                d1 = simpleDateFormat.parse(input);
                birthDate.setTime(d1);
                break;
            } catch (ParseException e) {
                System.out.println("invalid date!!!!!!");
            }
        }

        Calendar difference = Calendar.getInstance();

        difference.add(Calendar.YEAR ,- birthDate.get(Calendar.YEAR));
        difference.add(Calendar.MONTH ,- birthDate.get(Calendar.MONTH));
        difference.add(Calendar.DATE ,- birthDate.get(Calendar.DATE));

        System.out.println("years " + difference.get(Calendar.YEAR));
        System.out.println("Months " + difference.get(Calendar.MONTH));
        System.out.println("Days " + difference.get(Calendar.DATE));
    }
}
