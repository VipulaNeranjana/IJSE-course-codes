public class StringFormatting {
    public static void main(String[] args) {
        int id = 5;
        // s005
        String studentId = String.format("S%03d",id);
        System.out.println(studentId);

        double value = 54300000;
        String price = String.format("%,.2f",value);
        System.out.println(price);
    }
}


