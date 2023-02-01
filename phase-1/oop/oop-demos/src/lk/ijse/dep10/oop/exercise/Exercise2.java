package lk.ijse.dep10.oop.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        Student s001;
        System.out.println(s001 = new Student(1,"kasun","0777-888888"));
        Student s002 = new Student();
        s002.name = s001.name;
        System.out.println(s002);

    }
}
class  Student{

    int id;
    String name;
    String contactNo;

    public Student(){}
    public Student(int sid, String sName, String sContactNo){
        id = sid;
        name = sName;
        contactNo =sContactNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
