package method;

public class RecursionDemo2 {
    public static void main(String[] args) {
        print(4,4);

    }
    public static void print(int x, int y){
        if (x != y) return;
        if (y == 0) return;
        if (x == 0) {
            System.out.println("");
            print(y - 1, --y);
            return;
        };
        System.out.print("*");
        print(--x,y);

    }
}


