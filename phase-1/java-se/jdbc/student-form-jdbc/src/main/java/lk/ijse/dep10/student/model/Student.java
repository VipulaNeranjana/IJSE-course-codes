package lk.ijse.dep10.student.model;

public class Student {
    private int id;
    private String first_name;
    private String second_name;
    private String address;
    private String gender;
    private String dob;

    public Student(int id, String first_name, String second_name, String address, String gender, String dob) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
