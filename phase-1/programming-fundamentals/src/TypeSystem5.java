public class TypeSystem5 {
    public static void main(String[] args) {
        boolean myBoolean = true;          /*to convert to string in java 8*/
        byte myByte = 10;
        short myShort = 10;
        char myChar = 'a';
        int myInt = 30;
        long myLong = 40;
        float myFloat = 1.3F;
        double myDouble = 20.5;

        String myString = new Boolean(myBoolean).toString();
        System.out.println(myString);
        myString = new Byte(myByte).toString();
        System.out.println(myString);
        myString = new Short(myShort).toString();
        System.out.println(myString);
        myString = new Integer(myByte).toString();
        System.out.println(myString);


    }
}
