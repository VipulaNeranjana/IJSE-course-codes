package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate3 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2020, 3, 5);
        Date d1 = calendar.getTime();

        calendar.clear();
        calendar.set(2020,3,8);
        Date d2 = calendar.getTime();

        calendar.clear();
        calendar.set(2019, 11, 8);
        Date d3 = calendar.getTime();

        calendar.clear();
        calendar.set(2020, 3, 5);
        Date d4 = calendar.getTime();

        System.out.println(d3.before(d1));
        System.out.println(d3.before(d2));
        System.out.println(d2.after(d3));
        System.out.println(d4 == d1);
        System.out.println(d4.equals(d1));

    }
}
