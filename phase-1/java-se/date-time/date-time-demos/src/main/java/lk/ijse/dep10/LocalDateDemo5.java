package lk.ijse.dep10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo5 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2023, 1, 3);
        LocalDate localDate1 = LocalDate.of(2020, 1, 3);

        Duration difference = Duration.between(localDate1.atStartOfDay(), localDate.atStartOfDay());
        System.out.println(difference.toDays());
        System.out.println(difference.toHours());
        System.out.println(difference.toSeconds());
        System.out.println(difference.toMillis());
        System.out.println(difference.toNanos());
        System.out.println("----------------------------------------------------");


        Period difference2 = Period.between(localDate1, localDate);
        System.out.println("years : " + difference2.getYears());
        System.out.println("Months : " + difference2.getMonths());
        System.out.println("Days : " + difference2.getDays());
    }
}
