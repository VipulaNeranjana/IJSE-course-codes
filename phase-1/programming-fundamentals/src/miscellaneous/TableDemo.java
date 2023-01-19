package miscellaneous;

public class TableDemo {
    public static void main(String[] args) {

        String[] coloumnNames = {"ID","Name","Contacts","lol"};
        String[][] data = {
                {"S001", "kasun", "011-2222223","ds"},
                {"S002", "vipula Nearanjana", "011-2222224","Dsfd"},
                {"S003", "sadun", "011-2222225","dsf"},
                {"S004", "nimal", "011-2222226","dsfds"},
                {"S005", "rajith", "011-2222227","dsf"},
        };
        printTable(coloumnNames,data);
    }
    public static void printTable(String[] columnNames,String[][] data ){
        int[] maxLengthArray = findMaxLengths(columnNames,data);

        String line1 = "";
        for (int i=0; i < maxLengthArray.length;i++){
            if (i == 0) line1 = line1 +  "+".concat("-".repeat(maxLengthArray[i])).concat("+");
            else line1 = line1 + "-".repeat(maxLengthArray[i]).concat("+");
        }

        //for first line
        System.out.println(line1);

        //second line
        printLine(columnNames,maxLengthArray);

        //for third line
        System.out.println(line1);

        //for fourth line
        for(String[] row : data){
            printLine(row,maxLengthArray);
        }
        //fifth line

        System.out.println(line1);

    }

    public static int[] findMaxLengths(String[] columnNames,String[][] data ){
        int[] maxLengthArray = new int[columnNames.length];

        for (int i=0; i<columnNames.length;i++) {
            int maxLength=0;
            for (String[] row:data) {
                if (row[i].length()> maxLength){
                    maxLength = row[i].length();
                    maxLengthArray[i] = maxLength;
                }
            }
        }
        return maxLengthArray;
    }
    public static void printLine(String[] row, int[] maxLengthArray){
        String line2 = "";
        for (int i=0; i < maxLengthArray.length;i++){
            if (i==0) line2 = line2 + String.format("|%-"+maxLengthArray[i]+"s|", row[i]);
            if (i == maxLengthArray.length-1) line2 = line2+String.format("%-"+maxLengthArray[i]+"s|",row[i]);
            if (i !=0 && i !=maxLengthArray.length-1) line2 = line2+String.format("%-"+maxLengthArray[i]+"s|",row[i]);
        }
        System.out.println(line2);
    }



//        String line = "+".concat("-".repeat(5)).concat("+").concat("-".repeat(20)).concat("+");
//        System.out.println(line);
//        System.out.printf("|%-5s|%-20s|\n","ID","Name");
//        System.out.println(line);
//        for(String[] row : data){
//            System.out.printf("|%-5s|%-20s|\n",row[0],row[1]);
//        }
//        System.out.println(line);




}

