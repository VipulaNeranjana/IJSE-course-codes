package lk.ijse.dep10.serialization.model.inherit2;

public class C extends B{
    int c = 30;

    public C() {
    }
    public C(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String toString() {
        return "C{" +
                "c=" + c +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
