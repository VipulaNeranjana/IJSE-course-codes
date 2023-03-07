package lk.ijse.dep10;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Conversion1 {
    public static void main(String[] args) throws ParseException {
        String strDate = "2021-01-01";
        String strTime = "10:15:12";
        String strDateTime = "2021-01-01 10:15:12";

        /*String -> java.util.Data  (Via SimpleDateFormat)*/

        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        Date d2 = new SimpleDateFormat("kk:mm:ss").parse(strTime);
        Date d3 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").parse(strDateTime);

        /*string -> java.time.LocalData, java.time.LocalTime, java.time.LocalDateTime*/
        LocalDate localDate = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime localTime = LocalTime.parse(strTime, DateTimeFormatter.ofPattern("kk:mm:ss"));
        LocalDateTime LocalDateTime = java.time.LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss"));

        /*String -> java.sql.Date , java.sql.Time, java.sql.TimeStamp*/
        java.sql.Date sqlDate = java.sql.Date.valueOf(strDate);
        Time sqlTime = Time.valueOf(strTime);
        Timestamp sqlTimestamp = Timestamp.valueOf(strDateTime);


    }
}
