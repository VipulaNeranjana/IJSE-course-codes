package lk.ijse.dep10.oop;

public class TemplateLoader {

    static {
        System.out.println("template loader static initializer");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("template loader main");
/*        new MyTemplate();
        new MyTemplate(); // only one time initialize the java class method*/
//
//        MyTemplate.doSomething();
        Class.forName("lk.ijse.dep10.oop.MyTemplate");
    }
}

class MyTemplate{
    static {
        System.out.println("my template");
    }

    static void doSomething(){};
}
