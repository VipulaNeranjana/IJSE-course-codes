package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateDemo3 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 10, 05);
        LocalTime time = LocalTime.of(5, 7, 10);

        LocalDateTime dateTime2 = date.atTime(time);
        System.out.println(dateTime2);
        System.out.println("---------------------------------------------------------------");

        LocalDateTime dateTime3 = time.atDate(date);
        System.out.println(dateTime3);
        System.out.println("---------------------------------------------------------------");

        LocalDateTime dateTime1 = date.atStartOfDay();
        System.out.println(dateTime1);
        System.out.println("---------------------------------------------------------------");

        LocalDateTime datetime2 = LocalDateTime.of(2020, 5, 3, 4, 4, 4);
        LocalDate localDate = datetime2.toLocalDate();
        System.out.println(localDate);
        LocalTime localTime = datetime2.toLocalTime();
        System.out.println(localTime);
    }
}
