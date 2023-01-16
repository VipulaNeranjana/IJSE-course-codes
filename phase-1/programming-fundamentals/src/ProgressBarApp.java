import java.util.Scanner;

public class ProgressBarApp {
    public static void main(String[] args) throws InterruptedException {
        boolean canContinue = true;
        String[] speeds = new String[]{"01 :  slow", "02 : medium", "03 : speed"};
        Scanner scanner = new Scanner(System.in);
        int fullBarLength = 60;
        int number = 0;


        for (; canContinue ; ) {

            System.out.print("Enter a Number : ");
            number = scanner.nextInt();

            if (number < 0 || number > 100 ) {
                System.out.println("Incorrect number");
                continue;
            }
            break;
        }

        System.out.print(
                "Number is correct, i got u ho-moon \n\n" +
                        "01 : slow \n" +
                        "02 : medium \n" +
                        "03 : speed \n" +
                        "Enter the speed of the process number : ");
        int speed = 0;

        for (; canContinue; ) {
            var inputSpeed = scanner.nextInt();
            if (inputSpeed > 3) {
                System.out.println("Pls enter the correct no (between 1-3)");
                continue;
            }
            speed = 6 / inputSpeed;
            break;

        }
        for (int x = 0; x <= number; x++) {
            String percentageBar = "                    ";

            double progressBaerMultiplyingNumber = ((double) x / number) * 20;
            for (int y = 0; y <= (int) progressBaerMultiplyingNumber; y++) {
                percentageBar = "\u001b[40m \u001b[0m" + percentageBar + "\b";
            }


            String percentage = ((x * 100) / number) + "";
            if (percentage.length() == 1) percentage = percentage + "  ";
            if (percentage.length() == 2) percentage = percentage + " ";

            System.out.printf("progress : %s  [%s] %s / %s", percentage, percentageBar, x, number);
            Thread.sleep(100 * speed);

            for (int y = 0; y < fullBarLength; y++) {
                System.out.print("\b");
            }
        }
        System.out.println("task complete!");




    }
}
