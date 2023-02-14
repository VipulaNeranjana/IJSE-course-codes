package lk.ijse.dep10;

public class NullObject {
    public static void main(String[] args) {

        System.out.println(extract("IJSE",1,3));
        System.out.println(extract("IJSE",3,3));
        System.out.println(extract("IJSE is the worst place to be",3,7));

    }
    public static  String extract(String input, int start, int end){
        if(start < 0 || end > input.length() ) return  null;
        String extractedText = input.substring(start,end);
        return  extractedText;
    }
}
