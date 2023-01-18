public class BreakStatement3 {
    public static void main(String[] args) {
        start:
        System.out.println("App start");

        end:
        System.out.println("App end");

        first:{
            System.out.println("first started");
            second:{
                System.out.println("second started");
                third:{
                    System.out.println("third started");
                    fourth:{
                        System.out.println("fourth started");
                        if (true) break second;
                        System.out.println("fourth end");

                    }
                    System.out.println("third end");
                }
                System.out.println("second end");
            }
            System.out.println("first end");
        }
    }
}
