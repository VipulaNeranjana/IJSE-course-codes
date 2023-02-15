package model;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class Student {
    public String id;
    public String name;

    public String[] contacts;
    public String[] modules;

    public Student(String id, String name, String[] contacts, String[] modules) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
        this.modules = modules;
    }

    @Override
    public String toString() {
        return String.format("%-20s%s", id, name);
    }
}
