package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate5 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();

        calendar.set(2020,3,3);

        calendar.add(Calendar.MONTH, -3);

        Date d1 = calendar.getTime();
        System.out.println(d1);
    }
}
