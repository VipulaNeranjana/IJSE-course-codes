package lk.ijse.dep10.oop;

public class Overloading3 {
    public static void main(String[] args) {
        B.myMethod(10);
        B.myMethod("A class my method");

        new B().myMethod(10);
    }
}

class A {
    public static void myMethod(String something){
        System.out.println(something);
    }

    public static void myMethod(int something){
        System.out.println(something);
    }
    public void myMethod(String something, int x){
        System.out.println(something);
    }
}

class B extends A{

    public static void myMethod(long something){
        System.out.println(something);
    }
}
