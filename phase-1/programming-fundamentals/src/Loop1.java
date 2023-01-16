public class Loop1 {
    public static void main(String[] args) {

        boolean flag = true;
        int x = 0;

//        for ( ; flag ;) {                       //([initialization] ; boolean expression ; [update])
//            System.out.println("IJSE");
//            System.out.println("------");
//            System.out.println("DEP-10");
//            x++;
//            if (x == 5 )  flag =false;
//        }
//
        for (int y = 0; y < 5; y++) {              //([initialization] ; boolean expression ; [update])
            System.out.println("IJSE");
            System.out.println("------");
            System.out.println("DEP-10");
            x++;
            if (x == 5) flag = false;
        }

    }
}
