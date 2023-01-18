import java.util.Scanner;

public class DoDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = true;
        int number1;
        do{
            System.out.println("Enter positive integer: ");
            String number;
            number = scanner.nextLine();

            try{
                number1 = Integer.parseInt(number);
            }catch (Exception e){
                number1 = -60;
                continue;
            }

            if(0 < number1){
                System.out.println("Answer is correct!");
                isCorrect =false;
            }
        }while (isCorrect);
    }
}
