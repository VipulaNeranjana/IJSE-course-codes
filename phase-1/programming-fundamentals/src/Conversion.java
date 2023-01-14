public class Conversion {
    public static void main(String[] args) {
        /*identity conversion*/

        boolean flag1 = true;
        boolean flag2 = flag1;

        int int1 = 10;
        int int2 = int1;

        byte myBite = 10;     // narrowing conversion
        short myShort = 10;  // narrowing conversion
        int myInt = 10;     // Identity conversion
        long myLong = 10;  // widening conversion
        float myFloat = 10; // widening conversion
        double myDouble = 10;         // widening conversion
        myDouble = myLong;           // widening conversion
        myDouble = myInt;           // widening conversion
        myFloat = myLong;          // widening conversion
        char myChar = 'a';
        myInt = myChar;         // widening conversion
        myLong = myChar;       // widening conversion
        myDouble = myChar;    // widening conversion
        myFloat = myChar;    // widening conversion

        int myint2 = 10;
        byte myByte2 = (byte) myint2; //casting (narrowing conversion)
    }
}
