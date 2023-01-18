public class ReturnStatement {
    public static void main(String[] args) {
        System.out.println("Start");
        if (true) return;
        System.out.println("End");
    }

    public static int add(int num1, int num2){
        return num2+num1;
    }
}
