public class TypeSystem6 {
    public static void main(String[] args) {
        boolean myBoolean = true;           /*to convert to string after java 8         */
        byte myByte = 10;
        short myShort = 10;
        char myChar = 'a';
        int myInt = 30;
        long myLong = 40;
        float myFloat = 1.3F;
        double myDouble = 20.5;

        String myString = Boolean.toString(myBoolean);
        System.out.println(myString);
        myString = Byte.toString(myByte);
        System.out.println(myString);
        myString = Short.toString(myShort);
        System.out.println(myString);
        myString = Integer.toString(myInt);
        System.out.println(myString);


    }
}
