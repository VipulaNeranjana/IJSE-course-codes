package lk.ijse.dep10.oop;

public class Overriding {
    public static void main(String[] args) {
        Sub1 sub1 = new Sub1();
        sub1.myStaticMethod();
        Super1 super1 = sub1;
        super1.myStaticMethod();
    }
}
class Super1{
    public static void myStaticMethod(){
        System.out.println("Super:myStaticMethod");
    }
}
class Mediater extends Super1{

}

class Sub1 extends Mediater{
    public static void myStaticMethod(){
        System.out.println("Sub:myStaticMethod");
    }
}
