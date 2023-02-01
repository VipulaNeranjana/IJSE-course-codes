package lk.ijse.dep10.oop;

public class AppInitializer {
    static  int x = 10;

    public AppInitializer(){
        System.out.println("inside the constructor");
    }

    static  {
        System.out.println("x = " + x);
        System.out.println("y = " /* + */ /*y*/);  // cant access y because it is forward referencing. in java it is only support back referencing
        System.out.println("Static initializer");
    }
    public static void main(String[] args) {
        System.out.println("inside the main method");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("inside the main method, to be exit");

    }

    static int y = 20;

    static {
        System.out.println("static initializer 2");
    }
}
