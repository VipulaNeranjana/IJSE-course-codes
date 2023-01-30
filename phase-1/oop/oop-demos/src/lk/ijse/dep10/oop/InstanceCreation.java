package lk.ijse.dep10.oop;

public class InstanceCreation {
    public static void main(String[] args) {

        Customer c001 = new Customer();
        System.out.println("==================");
        Customer c002 = new Customer();
        System.out.println(c001.id);
        c001.id = 3;
        System.out.println(c002.id);
        System.out.println(Customer.id);
        Customer.id = 5;
        System.out.println(c001.id);

        c001.name = "vipula";
        c002.name = "vipula";

        System.out.println(c001.name);
        System.out.println(c002.name);

        c002.name = "gayashan";

        System.out.println(c001.name);
        System.out.println(c002.name);
    }
}
class Customer{
    static int id;
    static {
        System.out.println("Customer static initializer");
    }
    {
        System.out.println("Customer instance initializer");
    }

    String name;

    public Customer(){
        System.out.println("Customer constructor");
    }
    static {
        System.out.println("Customer static initializer 2");
    }
    String address = "panadura";


    {
        System.out.println("Customer instance initializer 2");
    }

}
