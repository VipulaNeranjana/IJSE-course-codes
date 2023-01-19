public class StringDemo2 {
    public static void main(String[] args) {
        /*Java 11*/
        String star = "* ";
        System.out.println(star.repeat(5));

        /*java 11*/
        String something = "   this is my content      ";
        System.out.println(something.stripLeading());
        System.out.println(something.stripTrailing());
        System.out.println(something.strip());

        var name = "kasun";
        var cotact = "011-2222224";
        int age = 15;

        something = String.format("Hi i am %s, my contact is %s. and my age is %s", name,cotact,age);
        System.out.println(something);

        something = String.format("Hi i am %1$s, %1$s's contact is %2$s. and my age is %2$s. and im %3$s", name,cotact,age);
        System.out.println(something);

        something = String.format("%50s", "Hello");
        System.out.println(something);

        something = String.format("%-50s", "Hello");
        System.out.println(something);
    }
}
