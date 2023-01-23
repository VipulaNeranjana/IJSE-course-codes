package algorithm_practice;

public class ReverseAsciiCharSequence {
    public static void main(String[] args) {
        String word = "HelloVipula";
        reverseAsciiByFor(word);
        reverseAsciiByWhile(word);
        reverseAsciiByDoWhile(word);
        reverseAsciiByForEach(word);
        reverseAsciiByRecursion(word,0);

    }
    public static void reverseAsciiByFor(String word){
        char[] wordInChar = word.toCharArray();
        StringBuilder finalString  = new StringBuilder();
        for (int index = 0; index < word.length()/2; index++) {
            char intermediate = wordInChar[index];
            wordInChar[index] = wordInChar[wordInChar.length-1-index];
            wordInChar[wordInChar.length-1-index] = intermediate;

        }
        for (int index = 0; index < wordInChar.length; index++) {
            finalString.append(wordInChar[index]);
        }
        System.out.println(finalString);
    }

    public static void reverseAsciiByWhile(String word){
        char[] wordInChar = word.toCharArray();
        StringBuilder finalWord = new StringBuilder();
        int index = 0;
        while (index<wordInChar.length/2){
            char intermediate = wordInChar[index];
            wordInChar[index] = wordInChar[wordInChar.length-1-index];
            wordInChar[wordInChar.length-1-index]  = intermediate;
            index++;
        }
        int index2 = 0;
        while (index2 < wordInChar.length){
            finalWord.append(wordInChar[index2]);
            index2++;
        }
        System.out.println(finalWord);
    }
    public  static void reverseAsciiByDoWhile(String word){
        char[] wordInChar = word.toCharArray();
        StringBuilder finalWord = new StringBuilder();
        int index = 0;
        do{
            char intermediate = wordInChar[index];
            wordInChar[index] = wordInChar[wordInChar.length-1-index];
            wordInChar[wordInChar.length-1-index] = intermediate;
        }while (++index<wordInChar.length/2);

        int index2 = 0;
        do{
           finalWord.append(wordInChar[index2]);
        }while (++index2<wordInChar.length);

        System.out.println(finalWord);
    }

    public static void reverseAsciiByForEach(String word){
        char[] wordInChar = word.toCharArray();
        StringBuilder finalWord = new StringBuilder();

        int index = 0;
        for (char charactor : wordInChar) {
            wordInChar[index] = wordInChar[wordInChar.length-1-index];
            wordInChar[wordInChar.length-1-index]= charactor;
            index++;
            if(index > wordInChar.length/2) break;
        }
        int index2 = 0;
        for (char charactor : wordInChar) {
            finalWord.append(charactor);
        }
        System.out.println(finalWord);
    }
    public static void reverseAsciiByRecursion(String word,int startingPoint){
        char[] wordInChar = word.toCharArray();
        if(wordInChar.length/2 < startingPoint){
            System.out.println(createString(wordInChar, ""));
            return;
        }
        char intermediate = wordInChar[startingPoint];
        wordInChar[startingPoint] = wordInChar[wordInChar.length-1-startingPoint];
        wordInChar[wordInChar.length-1-startingPoint] = intermediate;
        word = createString(wordInChar,"");
        reverseAsciiByRecursion(word,++startingPoint);
        return;


    }
    public static String createString(char[] charArray, String startingWord){
        if(charArray.length == startingWord.length()) return startingWord;

        startingWord += charArray[startingWord.length()];
        return  createString(charArray,startingWord);

    }
}
