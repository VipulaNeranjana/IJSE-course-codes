package lk.ijse.dep10.oop;

public class Polymorphism {
    public static void main(String[] args) {
        Prius prius = new Prius();

        Car myCar = prius;
        System.out.println(myCar);
        System.out.println(myCar == prius);
    }
}

class Vehicle{
    public void horn(){}
    public void accelerate(){}
    public void pushBreak(){}
}
class Car extends Vehicle{
    public void advanceBreakSystem(){
        System.out.println("car advancedBreakingSystem");
    }
}

class Prius extends Car{

    public void advanceBreakSystem(){
        System.out.println("prius advancedBreakingSystem");
    }
    public void hybrid(){}
}
class Lambo extends Car{

    public void advanceBreakSystem(){
        System.out.println("lambo advancedBreakingSystem");
    }
    public void turboAcceleration(){}
}
