package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateDemo {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);


        /*to create new date*/
        LocalDate today2 = LocalDate.of(2020, 3, 7);
        System.out.println(today2);

        LocalTime localTime2 = LocalTime.of(15, 10, 20);
        System.out.println(localTime2);

        LocalDateTime localDateTime2 = LocalDateTime.of(2020, Month.APRIL, 19, 12, 20, 20);
        System.out.println(localDateTime2);

    }
}
