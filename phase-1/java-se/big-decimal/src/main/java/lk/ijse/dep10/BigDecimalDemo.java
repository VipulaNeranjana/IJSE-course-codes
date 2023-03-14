package lk.ijse.dep10;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 0.3;
        double d2 = 0.2;
        double result = d1-d2;

        System.out.println(result);


        BigDecimal bd1 = BigDecimal.valueOf(0.3);
        BigDecimal bd2 = BigDecimal.valueOf(0.2);

        BigDecimal result1 = bd1.subtract(bd2);
        System.out.println(result1);

        BigDecimal bigDecimal = BigDecimal.valueOf(d1);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(d2);
        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        System.out.println(subtract.setScale(2));
    }
}
