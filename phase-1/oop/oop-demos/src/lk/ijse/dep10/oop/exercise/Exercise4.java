package lk.ijse.dep10.oop.exercise;

public class Exercise4 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.printDetails();

    }
}

class Teacher{
    String nic;
    String name;
    String contact;

    public Teacher(String nic, String name, String contact){
        this.nic = nic;
        this.name = name;
        this.contact = contact;
    }

    public Teacher() {

    }

    void printDetails(){
        System.out.printf("nic=%s , name = %s , contact = %s", nic,name,contact);
    }
}
