package method;

public class AutoBoxingInInvocations {
    public static void main(String[] args) {
        myMethod(true);
        byte b = 10;
        myMethod(b);
        short s = 10;
        myMethod(s);

    }
    public static void myMethod(Boolean b){
        System.out.println("my method boolean");
    }
    public static void myMethod(Short s){
        System.out.println("my method short");
    }
    public static void myMethod(Byte b){
        System.out.println("my method byte");
    }
}
