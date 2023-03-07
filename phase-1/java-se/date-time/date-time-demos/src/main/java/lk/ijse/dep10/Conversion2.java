package lk.ijse.dep10;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Conversion2 {
    public static void main(String[] args) {
        /*java.util.Date  -> java.sql.Date*/
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        /*java.util.Date  -> java.sql./time*/
        Time sqlTime = new Time(utilDate.getTime());

        /*java.util.Date  -> java.sql.TimeStamp*/
        Timestamp sqlTimestamp = new Timestamp(utilDate.getTime());

        /*java.sql.Date -> java.util.Date*/
        Date utilDate1 = new Date(sqlDate.getTime());

        /*java.sql.Time -> java.util.Date*/
        Date utilDate2 = new Date(sqlTime.getTime());

        /*java.sql.TimeStamp -> java.util.Date*/
        Date sqlDate3 = new Date(sqlTimestamp.getTime());
    }
}
