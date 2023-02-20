package method;

public class BoxingVsUnboxing2 {
    public static void main(String[] args) {
        Integer i = 10;
        Long l = 10L;

        Short s = 10;
        Character c = 10;
        Byte b = 10;

        Number n1 = 10;
        Number n2 = 10L;
        Number n3 = 10F;
        Number n4 = 10.0;

        Object o1 = 10;
        Object o2 = 10L;
        Object o3 = 10F;
        Object o4 = 10.0;

        Object o5 = 'c';
        Object o6 = true;
    }
}
