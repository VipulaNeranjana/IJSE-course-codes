public class TypeSystem2 {
    public static void main(String[] args) {
        var name = "khan";
        var num1 = 10;
        var isGood = true;                  // this type is using in the java 11 for make variables
        var character = 'A';
        final var MONTHS_OF_THE_YEAR = 12; //this is a compile time constant

        num1 = 50;
        isGood = false;  //variables can change
        character = 400;
        System.out.println(character);

        int age = 10;
        age = 40;

        final int FINAL_NUM = 12 + 12; // this is a compile time constant

//        char character1 = 'A';
//        short num3 = character1;      //cant do it
    }
}
