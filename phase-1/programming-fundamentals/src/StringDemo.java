import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {

        var name = "ijse";
        var uName = name.toUpperCase();
        System.out.println(name);
        System.out.println(uName);
        System.out.println(uName == "IJSE"); // to check weather is uname in the constant pool or not

        var uName1 = name.toUpperCase().intern();
        System.out.println(uName1 == "IJSE"); // this is on the constant pool because of the intern method


        var nums = new int[5];
        System.out.println(nums);
        System.out.println(nums.toString());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter something:");
        var something = scanner.nextLine();

        System.out.printf("Input text %s \n", something);
        System.out.printf("Input text %s \n", something.toString());
        System.out.printf("Input text length %s \n", something.length());
        System.out.printf("3rd character %s \n", something.charAt(2));
        System.out.printf("to upper case %s \n", something.toUpperCase());
        System.out.printf("to lower case %s \n", something.toLowerCase());
        System.out.printf("trimmed text %s \n", something.trim());  /*______(leading white spaces)_____Hello_______(trailing white space)___*/


        something = "   "; /*if you give the null here it will show null pointer exception because it hasnt any address in the heap*/
        System.out.println("is blank:" + something.isBlank()); //true
        System.out.println("is empty:" + something.isEmpty()); //false

        something =  "Hi! we are dep-10";  /*to get the part of the string*/
        String extracted = something.substring(4);
        System.out.println(extracted);
        System.out.println(something.substring(0,1));

        something = "Monday,    Tuesday,Wednesday   , Thursday, Friday    ";
        String[] splits = something.split(",");
        System.out.println(splits[0].trim());
        System.out.println(splits[1] = splits[1].trim()); // remove white2 spaces and assign new values to the splits array
        System.out.println(splits[2].trim());
        System.out.println(splits[3]);  //width wide spaces
        System.out.println(splits[4].trim());

        System.out.println("is something contains the friday "+  something.contains("Friday"));  // to find some word is in there
        System.out.println("is something contains the friday "+  something.toUpperCase().contains(("friday").toUpperCase()));
        System.out.println("where is tuesday :" + something.indexOf("Tuesday"));
        System.out.println("first index of day :" + something.indexOf("day"));
        System.out.println("last index of day :" + something.lastIndexOf("day"));


        String newText = something.replaceAll("day", "poop"); // replace string
        System.out.println(newText);

    }
}
