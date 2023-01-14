public class TypeSystem8 {
    public static void main(String[] args) {
        String myStr = "010";
        var myInt = Integer.parseInt(myStr,8);
        var myBool = Boolean.parseBoolean(myStr);
        System.out.println(myBool);
        System.out.println(myInt);
    }
}
