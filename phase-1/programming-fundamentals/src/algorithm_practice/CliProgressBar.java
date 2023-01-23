package algorithm_practice;

import java.util.Scanner;

public class CliProgressBar {
    public static void main(String[] args) throws InterruptedException {

        int firstNo = firstNoValidation();
        int speed = barSpeedValidation();
        printBar(firstNo,speed);
//        String ne = String.format("%"+30+"s","");
//        int l = 50;
//        String secondPart1 = String.format("\u001B[40m%"+(l*20/100)+"s\u001B[0m","");
//        String me = String.format("\u001B[40m%"+l+"s\u001B[0m","");
//        System.out.print(2*18/100);

    }
    public static int firstNoValidation(){
        while (true) {
            System.out.print("Enter a no between 1 and 100 : ");
            int input = getValue();
            if(input < 0 || input > 100) {
                System.out.println("Invalid no!!!!!");
                continue;
            }
            return input;
        }
    }

    public static int barSpeedValidation(){
        while (true) {
            System.out.print("Enter Speed Parameter : \n" +
                    "1 : slow speed \n" +
                    "2 : medium speed \n" +
                    "3 : high speed \n" +
                    "Enter want speed : ");
            int input = getValue();
            if(input == 1 || input == 2 || input == 3) return input;
            System.out.println("Invalid Speed Input!!");
        }
    }
    public static int getValue(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public static void printBar(int value, int speed) throws InterruptedException {
        for (int progress = 0; progress < 101; progress++) {
            int progress2 =(progress*20)/100;
            int progress3 = (20 - progress2);

            String firstPart = String.format("%3s",progress);

            String secondPart1 = "";
            if (progress2 != 0) secondPart1 = String.format("\u001B[40m%"+progress2+"s\u001B[0m","");

            String secondPart2 = "";
            if ((20 - progress2) != 0) secondPart2 = String.format("%"+ progress3+"s","");

            String thirdPart = String.format("%3s",(progress2*value)/20);

            System.out.print(firstPart+"% "+secondPart1+secondPart2+thirdPart);

            Thread.sleep((6*50)/speed);
            for (int i = 0; i < 28; i++) {
                System.out.print("\b");
            }
        }
        System.out.println("task complete!");
    }
}
