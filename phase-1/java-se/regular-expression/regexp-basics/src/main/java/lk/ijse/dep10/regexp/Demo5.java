package lk.ijse.dep10.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
    public static void main(String[] args) {
        String text = "hi my phone number is 077-1111111. My home phone number is 033-1112222. His phone number is 071-9999999";

        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
        Matcher matcher = pattern.matcher(text);

        boolean found ;

        int start ;
        int end ;
//        System.out.printf("start = %s , end = %s \n",start,end);
//        System.out.println(text.substring(start,end));
//
//        found = matcher.find();
//        System.out.println(found);
//
//        start = matcher.start();
//        end = matcher.end();
//        System.out.printf("start = %s , end = %s \n",start,end);
//        System.out.println(text.substring(start,end));
//
//        found = matcher.find();
//        System.out.println(found);

        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            System.out.printf("start = %s , end = %s \n",start,end);
            System.out.println(text.substring(start,end));
        }

        String replaceText = matcher.replaceAll("abc");
        System.out.println(replaceText);

    }
}
