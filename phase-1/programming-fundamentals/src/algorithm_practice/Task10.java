package algorithm_practice;

import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(split(123)));
        System.out.println(split(121));
    }
    public static boolean split(int input){
        int devider = 10;
        int input1 = input;
        int count = 0;
        while (true){
            if(input1/devider < 10) {
                count++;
                break;
            }
            input1 /=devider;
            count++;
        }
        System.out.println(count);
        int lastno = (int) (input%Math.pow(10,1));
        int firstno = (int) (input/Math.pow(10,count));
        int[] l = new int[]{lastno, firstno};
        System.out.println(Arrays.toString(l));

        if(l[0]==l[1]) return  true;
        else return false;
    }
}
