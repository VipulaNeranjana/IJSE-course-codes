import java.util.Scanner;

public class IFvsSWitch {
    public static void main(String[] args) {
        String str1 = "IJSE";
        String str2 = "IJSE";
        String str3 = new String("IJSE").intern(); // this will check weather if there is any string of "IJSE" and return its location otherwise it create the new object
        boolean result = str2 == str1;
        System.out.println(result);

        Scanner scanner = new Scanner(System.in);
        System.out.printf("is scanner instance of Scanner object: %s \n", (Object)scanner instanceof Scanner);
        System.out.print("Enter something:");
        var input = scanner.nextLine();
        System.out.println(input);

        result = str2 == input;
        System.out.println(result);

    }
}
