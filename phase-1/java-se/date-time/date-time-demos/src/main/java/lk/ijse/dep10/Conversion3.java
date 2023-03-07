package lk.ijse.dep10;

import java.time.*;
import java.util.Date;

public class Conversion3 {
    public static void main(String[] args) {
        Date utilDate = new Date();

        /*java.util.data -> java.time.LocalData*/
        LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        /*java.util.data -> java.time.LocalTime*/
        LocalTime localTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        /*java.util.data -> java.time.LocalDateTime*/
        LocalDateTime localTimeDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        /*java.time.LocalDAte -> java.util.Date*/
        Date d1 = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        /*java.time.LocalTime -> java.util.Date*/
        Date d2 = Date.from(localTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        /*java.time.LocalDateTime -> java.util.Date*/
        Date d3 = Date.from(localTimeDate.atZone(ZoneId.systemDefault()).toInstant());


    }
}
