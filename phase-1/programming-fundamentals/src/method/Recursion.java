package method;

public class Recursion {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("IJSE");
        }

        print(5);

    }

    public static void print(int iteration) {
        if (iteration == 0) return;
        System.out.println("IJSE");
        iteration--;
        print(iteration);


    }
}

