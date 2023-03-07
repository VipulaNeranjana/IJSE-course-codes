package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

        Calendar calendar = Calendar.getInstance();
//        calendar.set(1996,6,29,1,0,0);
        calendar.clear();
        calendar.set(1996,6,29);

        Date d2 = calendar.getTime();
        System.out.println(d2);

        int month = calendar.get(Calendar.MONTH);
        System.out.println("month" + month);

        int year = calendar.get(Calendar.YEAR);
        System.out.println("year" + year);

        int hour = calendar.get(Calendar.HOUR);
        System.out.println("hour" + hour);

        int minutes = calendar.get(Calendar.MINUTE);
        System.out.println("minute" + minutes);

        int second = calendar.get(Calendar.SECOND);
        System.out.println("second" + second);

        int millisecond = calendar.get(Calendar.MILLISECOND);
        System.out.println("millisecond" + millisecond);
    }
}
