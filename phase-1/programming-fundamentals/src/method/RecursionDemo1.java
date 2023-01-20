package method;

public class RecursionDemo1 {
    public static void main(String[] args) {

        printStar(6,6);

    }

    public static void printStar(int x, int y) {
        int xNumber2 = 0;
        if ((y != 0) ){
            if(x==0){
                System.out.println("");
                y--;
                printStar(x,y);
            }
            System.out.print("*");
            x--;
            xNumber2++;
            printStar(x, y);

        };
        if(y==0 && x==0) return;
    }
}
