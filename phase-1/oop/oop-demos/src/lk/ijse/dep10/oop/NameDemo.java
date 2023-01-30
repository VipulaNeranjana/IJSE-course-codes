package lk.ijse.dep10.oop;

//import lk.ijse.dep10.oop.sample.DummyObeject;
//import lk.ijse.dep10.oop.sample.MyObject;
import lk.ijse.dep10.oop.sample.*; //by while card character

public class NameDemo {
    public static void main(String[] args) {
        new MyObject();
        new DummyObeject();

        //or we can creat object without simple name as bellow;
        new lk.ijse.dep10.oop.sample.DummyObeject();  // this is full qualified name
    }
}
