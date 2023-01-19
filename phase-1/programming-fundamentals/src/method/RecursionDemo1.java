package method;

public class RecursionDemo1 {
    public static void main(String[] args) {

        printStar(6,6);

    }

    public static void printStar(int x, int y) {
        int xNumber = x;
        int xNumber2 = 0;
        if ((y != 0) ){
            if(y!=0 && xNumber==0){
                System.out.println("");
                y--;
                System.out.println(y);
                xNumber = x;
                System.out.println(xNumber2);
                printStar(xNumber,y);
            }
            System.out.print("*");
            xNumber--;
            xNumber2++;
            printStar(xNumber, y);

        };
        if(y==0 && xNumber==0) return;
    }
}
