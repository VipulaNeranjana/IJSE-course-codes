package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo2 {
    public static void main(String[] args) {
        String date = "01-12-2020";
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("year : " + localDate.getYear());
        System.out.println("month : " + localDate.getMonth());
        System.out.println("day : " + localDate.getDayOfMonth());
        System.out.println(localDate);
        System.out.println("----------------------------------------------------------------------------------------");

        String strTime = "15:13:10";
        LocalTime time = LocalTime.parse(strTime,DateTimeFormatter.ofPattern("kk:mm:ss"));
        System.out.println("hours : " + time.getHour());
        System.out.println("minutes : " + time.getMinute());
        System.out.println("seconds : " + time.getSecond());
        System.out.println(time);
        System.out.println("----------------------------------------------------------------------------------------");


        String strDateTime = "2020-03-05 05:10 PM";
        LocalDateTime datetime = LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a"));
        System.out.println(datetime);
    }
}
