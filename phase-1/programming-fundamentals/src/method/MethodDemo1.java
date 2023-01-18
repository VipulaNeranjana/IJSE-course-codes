package method;

public class MethodDemo1 {
    public static void main(String[] args) {
        myMethod();
        myMethod();
        myMethod();
        myMethod();

        print("my name is vipula");
        print("im not khan im vipula");


    }
    public static void myMethod(){
        System.out.println("----------");
        System.out.println("---IJSE---");
        System.out.println("----------");
    }
    public static void print(String something){
        System.out.println("---------------");
        System.out.println(something.toUpperCase());
        System.out.println("---------------");
    }
}
