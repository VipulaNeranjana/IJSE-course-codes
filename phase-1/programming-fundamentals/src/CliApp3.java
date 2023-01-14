import java.util.Scanner;

public class CliApp3 {
    public static void main(String[] args) {
        System.out.print("Enter your marks (split via , ):");
        var scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        int index = 0;
        int[] marks = new int[5];
        boolean bool =true;

        while (bool) {
            var input = scanner.next();
            int input1;
            input1 = Integer.parseInt(input);
            marks[index] = input1;
            System.out.println(index);
            index += 1;
            if (index == 4){
                String input2 = scanner.nextLine();
                marks[index] = Integer.parseInt(input2.substring(1,input2.length()));
                scanner.useDelimiter("\n");
                break;
            }
            if (index == 5) {
                break;
            }
        }

        System.out.println(marks[4]);

        System.out.println();
        }







}
