import java.util.Scanner;

public class TypeSystem9 {
    public static strictfp void main(String[] args) {
        float f1 = 10;
        float f2 = 10.1f;   /*strictfp = strict floating point calculations*/
        double f3 = 10.1;

        float f4 = 12.2134324234254f;
        double f5 = 12.2435345435454;

        System.out.println(f4);
        System.out.println(f5);

        double f6 = 0.3 - 0.2;
        System.out.println(f6);

    }
}
