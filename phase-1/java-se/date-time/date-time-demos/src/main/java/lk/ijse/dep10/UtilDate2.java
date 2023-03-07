package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate2 {
    public static void main(String[] args) {
        String date = "1996-06-29 15:20";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");
        try {
            Date parsedDate = simpleDateFormat.parse(date);
            System.out.println(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
