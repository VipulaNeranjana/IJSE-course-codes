package lk.ijse.dep10.serialization.model.inherit2;

public class A {
    public int a = 10;

    public A() {
    }
    public A(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}
