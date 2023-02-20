package method;

public class OverLoadingDemo3 {
    public static void main(String[] args) {

    }

    public static void myMethod(int x, int y){
        System.out.println("int int");
    }

    public static void myMethod(int x, long y){
        System.out.println("int long");
    }

    public static void myMethod(int x, double y){
        System.out.println("int double");
    }

    public static void myMethod(long x, int y){
        System.out.println("int int");
    }
}
