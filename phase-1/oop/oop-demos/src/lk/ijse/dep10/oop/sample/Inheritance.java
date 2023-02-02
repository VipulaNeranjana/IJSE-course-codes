package lk.ijse.dep10.oop.sample;

public class Inheritance {
    public static void main(String[] args) {
        Car car1 = new Car();
        System.out.println("---------------------------");
        Van van1 = new Van();

    }
}

class Vehicle{
    String registationNumber;

    static {
        System.out.println("vehicle class is initialized");
    }
    Vehicle(){
        System.out.println("Vehicle constructor");
    }
    void printRegistationNumber(){
        System.out.println(registationNumber);
    }
}
class Car extends Vehicle{
    //van is a vehicle
    static {
        System.out.println("car class is initialized");
    }

    {
        System.out.println("car object is initialized");
    }
    Car(){
        System.out.println("car constructor");
    }
}
class Van extends Vehicle{
    //van is a vehicle
    static {
        System.out.println("van class is initialized");
    }
    {
        System.out.println("van object is initialized");
    }

    Van(){
        System.out.println("van constructor");
    }
}