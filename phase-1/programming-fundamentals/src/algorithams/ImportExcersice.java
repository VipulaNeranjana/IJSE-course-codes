package algorithams;

import miscellaneous.TableDemo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ImportExcersice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter anything : ");
        String anything = scanner.nextLine();
        String letterName = "";
        String[] header = new String[] {"String","Count"};

        char[] letters = anything.toCharArray();
        String[] countArray = new String[letters.length];
        String[] letterArray = new String[letters.length];

        for (int j = 0; j < letters.length; j++) {
            int count = 0;
            boolean isCountable = true;
            for (String string :letterArray) {
                if (Objects.equals(string, Character.toString(letters[j])) | letters[j]== ' ') isCountable = false;
            }
            if(isCountable){
                letterName = Character.toString(letters[j]);
                for (int i = 1; i < letters.length; i++) {
                    if(letters[i] == letters[j]) {
                        ++count;
                    }
                }
                if(count == 0) count++;
                countArray[j] = Integer.toString(count);
                letterArray[j] = letterName;
            }

        }

        int unNullCount = 0;
        for (String num:countArray) {
            if (!(num==null)) unNullCount++;
        }

        String[][] finalArray = new String[unNullCount][2];
        for (int i = 0,j=0; i < countArray.length; i++) {
            if(countArray[i]!= null){
                finalArray[j][1] = countArray[i];
                finalArray[j][0] = letterArray[i];
                j++;
            }
        }

        TableDemo.printTable(header,finalArray);


    }
}
