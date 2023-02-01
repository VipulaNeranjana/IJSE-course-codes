package lk.ijse.dep10.oop.exercise;

public class Exercise4 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.printDetails();

    }
}

class Teacher{
    int nic;
    String name;
    String contact;

    void printDetails(){
        System.out.printf("nic=%s , name = %s , contact = %s", nic,name,contact);
    }
}
