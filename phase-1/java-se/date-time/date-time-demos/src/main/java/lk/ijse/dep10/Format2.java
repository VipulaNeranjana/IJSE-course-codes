package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Format2 {
    public static void main(String[] args) {
        LocalDate localDate = java.time.LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDatetime = LocalDateTime.now();

        System.out.println(localDate.toString());
        System.out.println(localTime.toString());
        System.out.println(localDatetime.toString());

        System.out.println("----------------------------------------------");

        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(formattedDate);
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("hh:ss:mm a"));
        System.out.println(formattedTime);
        String formattedDateTime = localDatetime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
        System.out.println(formattedDateTime);
    }
}
