public class LoopDemo {
    public static void main(String[] args) throws InterruptedException {
        String something = "Hello Dep-10, How are you!";     /* \b : back space , \t : tab , \n : new line , \r : return */
        String[] letters = something.split("");
        int length = something.length();
        int delayLoop = 8;

        for (int i = 0, x=0; (i < length*2 + delayLoop); i++, x++) {
            if (i<length){
                System.out.print(letters[i]);
                Thread.sleep(400);
            }
            if (length <= i && i <length+delayLoop/2){
                System.out.print("|");
                Thread.sleep(400);
                System.out.print("\b");
                Thread.sleep(400);
            }

            if (i > length + 4) {
                System.out.print("\b");
                Thread.sleep(300);
            }

        }



        for (int i = 0, x=0; (i < length*2 + delayLoop); i++, x++) {

            if (i<length){
                System.out.printf("[3%sm%s", x, letters[i]);
                Thread.sleep(400);
            }
            if (x == 10) {
                x = 0;
            }

            if (length <= i && i <length+delayLoop/2){
                System.out.print("|");
                Thread.sleep(400);
                System.out.print("\b");
                Thread.sleep(400);
            }

            if (i > length + 4) {
                System.out.print("\b");
                Thread.sleep(300);
            }
        }


    }
}
