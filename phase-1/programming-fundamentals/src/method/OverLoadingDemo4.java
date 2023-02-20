package method;

public class OverLoadingDemo4 {
    public static void main(String[] args) {
        byte x = 10;
        short y = 20;
        int z = 30;
        float f = 10.0f;

//        myMethod(x,y,z,f);

    }

    public static void myMethod(short x, float y, float z, float d){
        System.out.println("short float float float");
    }
    public static void myMethod(int x, float y, double z, float d){
        System.out.println("int float long float");
    }
    public static void myMethod(short x, float y, double z, float d){
        System.out.println("short double float double");
    }
    public static void myMethod(short x, Short y, int z, float d){
        System.out.println("short Short int float");
    }
//    public static void myMethod(Byte x, Short y, Integer z, Float d){
//        System.out.println("Byte Short Integer Float");
//    }
}
