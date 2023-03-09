package lk.ijse.dep10.oop;

import java.util.ArrayList;

public class Aggregation {
    public static void main(String[] args) {



        ArrayList<Program2> programList = new ArrayList<>();
        programList.add(new Program2("Dep","5 Month"));
        programList.add(new Program2("CMJD","6 Month"));
        programList.add(new Program2("GDSE","2 Year"));

        Institute2 ijse = new Institute2(programList);
        System.out.println(ijse.programList.get(0).name);

        ijse = null;

        System.out.println(programList.get(0).name);     // still can access any program
    }

}

class Institute2{
    ArrayList<Program2> programList = new ArrayList<>();

    public Institute2(ArrayList<Program2> programList){
        this.programList = programList;
    }
}

class Program2{
    String name;
    String duration;

    public Program2(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
