package method;

public class BoxingVsUnBoxing {
    public static void main(String[] args) {
        Integer myint = new Integer(10);
        int x = 10;
        myint = new Integer(x);//Boxing
        Integer myint2 = 20;  //AutoBoxing

        int y = myint2.intValue(); //Unboxing
        Integer t = myint2; //AutoUnBoxing
    }
}
