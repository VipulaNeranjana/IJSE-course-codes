package algorithm_practice;

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {
        String a = "my name is a vipula and vipula is a name of mine";
        System.out.println(Arrays.deepToString(findDuplicates(a)));
    }
    public static String[][] findDuplicates(String word){
        String[] word1 = word.toLowerCase().split(" ");
        String[][] out = new String[1][];
        String[] dups = new String[2];
        int index = 0;
        for (String s : word1) {
            int count = 0;
            String countedWord = s;

            for (String s1 : word1) {
                if(s.equals(s1)) count++;
            }
            if (count > 1){
                dups[0] = countedWord;
                dups[1] = Integer.toString(count);
                out[index] = dups;
                index++;
                System.out.println(Arrays.toString(dups));
            }
            String[][] out2 = new String[dups.length+1][];
            for (int i = 0; i < out.length; i++) {
                out2[i] = out[i];
            }
            out = out2;
        }
        return out;
    }
}
