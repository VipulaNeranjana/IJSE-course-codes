import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Loop6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayNum;
        int i= 0;
        String arrayNumInt = "";
        while(true){

            System.out.print("Insert a number (q for exit): ");
            String number = scanner.nextLine();

            if(number.equals("q")) break;
            arrayNumInt = arrayNumInt + number + " ";
        }
        arrayNum = arrayNumInt.split(" ");
        int t=0;
        int[] arraynum2 = new int[arrayNum.length];
        while (t++ < arrayNum.length){
            arraynum2[t-1]= Integer.parseInt(arrayNum[t-1]);
        }
        System.out.println(Arrays.toString(arraynum2));
    }
}
