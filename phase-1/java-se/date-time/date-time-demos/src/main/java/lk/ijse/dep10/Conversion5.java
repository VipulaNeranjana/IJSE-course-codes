package lk.ijse.dep10;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Conversion5 {
    public static void main(String[] args) {
        Date utilDate = new Date();

        /*java.util.date -> java.time.LocalDate*/
        LocalDate localDate = new java.sql.Date(utilDate.getTime()).toLocalDate();

        /*java.util.date -> java.time.LocalTime*/
        LocalTime localTime = new Time(utilDate.getTime()).toLocalTime();

        /*java.util.date -> java.time.LocalDateTime*/
        LocalDateTime localDateTime = new Timestamp(utilDate.getTime()).toLocalDateTime();

        /*java.time.localDate -> java.util.date*/
        Date d1 = Date.from(java.sql.Date.valueOf(localDate).toInstant());

        /*java.time.localTime -> java.util.Time*/
        Date d2 = Date.from(Time.valueOf(localTime).toInstant());
        
        /*java.time.LocalTimeDate -> java.util.TimeStamp*/
        Date d3 = Date.from(Timestamp.valueOf(localDateTime).toInstant());
    }
}
