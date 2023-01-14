public class TypeSystem7 {
    public static void main(String[] args) {
        String mystr = "true";

        boolean myBoolean = new Boolean(mystr);
        System.out.println(myBoolean);

        myBoolean = Boolean.valueOf(mystr);
        System.out.println(myBoolean);

        String myStr1 = "1";

        System.out.println(Byte.valueOf(myStr1));
        System.out.println(Short.valueOf(myStr1));
        System.out.println(Float.valueOf(myStr1));       //java 11
        System.out.println(new Double(myStr1));          //java 8

        String mystr2 = "a";
    //    System.out.println(new Character(mystr2));       //java 8
        System.out.println(mystr2.charAt(0));   //java 11


    }
}
