package lk.ijse.dep10.app;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(10/0);
//        int x = Integer.parseInt("abc");
//        System.out.println(x);
//        String something = null;
//        System.out.println(something.toUpperCase());

//        Class.forName("abc");

        myMethod1();
    }

    public static void  myMethod1(){
        myMethod2();
        System.out.println("after method2 invocation");
    }

    private static void myMethod2() {

        try{
            Class.forName("abc");
        }catch (Throwable e){
            System.out.println(e);
        };
    }
}
