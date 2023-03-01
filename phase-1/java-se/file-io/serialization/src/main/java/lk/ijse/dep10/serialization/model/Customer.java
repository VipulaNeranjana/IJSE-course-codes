package lk.ijse.dep10.serialization.model;

import java.io.Serializable;

public class Customer implements Serializable {
    String id;
    String name;
    String address;

    String Contact;

    private static final long serialVersionUID = -4707805269443981395L;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }

    public void print(){
        System.out.printf("id=%s,name=%s,address=%s",id,name,address);
    }
}
