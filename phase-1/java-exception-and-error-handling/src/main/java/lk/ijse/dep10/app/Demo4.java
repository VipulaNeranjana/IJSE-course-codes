package lk.ijse.dep10.app;

public class Demo4 {
    public static void main(String[] args) throws Exception {

        MyResource2 myResource21 = new MyResource2();   // this can only do in the versions, after java 9

        try(MyResource myResource = new MyResource(); MyResource1 myResource1 = new MyResource1(); MyResource2 myResource2 = new MyResource2(); myResource21) {
            System.out.println(myResource);
            System.out.println(myResource1);
            System.out.println(myResource2);
            System.out.println(myResource21);
        }
//        myResource.close();
    }
}

class MyResource implements  AutoCloseable{


    @Override
    public void close() throws Exception {
        System.out.println("Resource is about to free");
    }
}
class MyResource1 implements  AutoCloseable{


    @Override
    public void close() throws Exception {
        System.out.println("Resource 1 is about to free");
    }
}
class MyResource2 implements  AutoCloseable{


    @Override
    public void close() throws Exception {
        System.out.println("Resource 2 is about to free");
    }
}
