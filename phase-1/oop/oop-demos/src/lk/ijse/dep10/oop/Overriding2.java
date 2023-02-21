package lk.ijse.dep10.oop;

public class Overriding2 {
    public static void main(String[] args) {
        T t = new S();
        t.myMethod();
        t.myStaticMethod();

    }
}
class T{
    public static void myStaticMethod(){
        System.out.println("T static Method");
    }
    public void myMethod(){
        System.out.println("T myMethod");
    }
}
class S extends T{
    public static void myStaticMethod(){
        System.out.println("S static Method");
    }
    public void myMethod(){
        System.out.println("S myMethod");
    }
}
