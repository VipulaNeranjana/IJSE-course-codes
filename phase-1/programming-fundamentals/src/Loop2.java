import java.util.Scanner;

public class Loop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] customerList = new String[3][3];
        int index = 1;
        String id = "";
        String name = "";
        String contact = "";

        while(index < 4){
            boolean isIdChecked = true;
            boolean isNameChecked =  false;
            boolean isContactChecked =  false;

            while (isIdChecked){

                System.out.printf("Enter customer - %s id : ", index);
                id = scanner.nextLine().trim();
                char[] idChar = id.toCharArray();
                if(idChar.length > 4 || !(idChar[0] == 'C')) {
                    System.out.println("Invalid id!!");
                }
                else {

                    int x = 0;

                    while (idChar.length > x){
                        if(!Character.isLetter(idChar[x])){

                            System.out.print("Invalid name!");
                            break;
                        }
                        else {

                            x++;
                            if (x == idChar.length-1){

                                isIdChecked = false;
                            }
                        }
                    }
                }
            }

            while (!isNameChecked){

                System.out.print("Enter the customer name : ");
                name = scanner.nextLine().trim();
                char[] nameChar = name.toCharArray();

                if (nameChar.length < 3){

                    System.out.println("Invalid name");
                }
                else {

                    int x = 0;
                    while (nameChar.length > x){
                        if(Character.isDigit(nameChar[x])){
                            System.out.print("Invalid name!");
                            break;

                        }
                        else {

                            x++;
                            if (x == nameChar.length-1){
                                isNameChecked = true;
                            }
                        }
                    }
                }
            }

            while (!isContactChecked){

                System.out.print("Enter contact no : ");
                contact = scanner.nextLine().trim();
                char contactChar[] = contact.toCharArray();

                if(!(contactChar.length == 11) || contactChar[3] !='-'){
                    System.out.println("Invalid contact");
                }
                else {

                    int x = 0;
                    while (contactChar.length > x){
                        if(!Character.isDigit(contactChar[x]) && x != 3){
                            System.out.print("Invalid contact!");
                            break;

                        }
                        else {

                            x++;
                            if (x == contactChar.length-1){
                                isContactChecked = true;
                            }
                        }
                    }
                }
            }

        customerList[index-1]= new String[]{id, name, contact};
        index++;
        }

        System.out.println(customerList[1][1]);

    }
}
