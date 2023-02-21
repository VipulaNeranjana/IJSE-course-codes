package lk.ijse.dep10.oop;

public class Overloading2 {
    public static void main(String[] args) {
        Object o =  new Super();  //liskow substitution low
        Object o2 = new Overloading2();

        Super s1 = new Sub();
    }
}

class Super{

}
class Sub extends Super{

}
