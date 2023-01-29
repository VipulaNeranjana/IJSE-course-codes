package algorithm_practice;

public class FindTheLongestString {
    public static void main(String[] args) {
        String[] strings = new String[]{"vi","vipu","vip","v","vipula","vipul"};
        System.out.println(findLongestStringByRecursion(strings));

    }
    public static String findTheLongestStringByFor(String[] stringArray){
        String maxString = stringArray[0];
        for (int i = 1; i < stringArray.length; i++) {
            if (maxString.length() > stringArray[i].length()) continue;
            maxString = stringArray[i];
        }
        return maxString;
    }

    public static String findTheLongestStringByWhile(String[] stringArray){
        String maxString = stringArray[0];
        int index = 0;
        while (index < stringArray.length -1){
            if(maxString.length() > stringArray[index].length()) {
                ++index;
                continue;
            }
            maxString = stringArray[index];
            ++index;
        }
        return maxString;
    }

    public static String findLongestStringByDoWhile(String[] stringArray){
        String maxString = stringArray[0];
        int index = 1;
        do{
            if(maxString.length() > stringArray[index].length()){
                ++index;
                continue;
            }
            maxString = stringArray[index];
        }while(++index < stringArray.length-1);
        return maxString;
    }
    public static String findLongestStringByForEachLoop(String[] stringArray){
        String maxString = stringArray[0];
        for (String s : stringArray) {
            if(maxString.length()>s.length())continue;
            maxString = s;
        }
        return maxString;
    }
    public static String findLongestStringByRecursion(String[] stringArray,int... params){
        if(params.length == 0) {
            int start = 0;
            int max = 0;
            return findLongestStringByRecursion(stringArray,start,max);
        }
        else if(params[0] == stringArray.length){
            return stringArray[params[1]];
        }
        else if(params[0] < stringArray.length){
            if(stringArray[params[1]].length()>stringArray[params[0]].length()) {
                return findLongestStringByRecursion(stringArray,++params[0],params[1]);
            }
            else if(stringArray[params[1]].length()<=stringArray[params[0]].length()){
                int max = params[0];
                return findLongestStringByRecursion(stringArray,++params[0],max);
            }
        }
        return stringArray[params[1]];
    }
}
