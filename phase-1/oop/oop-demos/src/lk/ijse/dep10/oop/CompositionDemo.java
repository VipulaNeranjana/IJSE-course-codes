package lk.ijse.dep10.oop;

import java.util.ArrayList;

public class CompositionDemo {
    public static void main(String[] args) {

        Institute ijse = new Institute();
        Program program1 = ijse.programList.get(0);
        System.out.println(program1.name);

        ijse = null;

        Program program = ijse.programList.get(0);
        System.out.println(program.name); // this should give a null pointer exception

    }

}

class Institute{
    ArrayList<Program> programList = new ArrayList<>();

    public Institute(){
        programList.add(new Program("Dep","5 Month"));
        programList.add(new Program("CMJD","6 Month"));
        programList.add(new Program("GDSE","2 Year"));
    }
}

class Program{
    String name;
    String duration;

    public Program(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
