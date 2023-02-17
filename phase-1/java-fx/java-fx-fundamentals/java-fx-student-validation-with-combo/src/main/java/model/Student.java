package model;

import javafx.collections.ObservableList;
import util.Gender;

public class Student {
    public String id;
    public String name;

    public String moduleName;
    public Gender gender;

    public ObservableList<String> contact;
    public ObservableList<String> selectedModules;

    public boolean isPartTimer;

    public Student(String id, String name, String moduleName, Gender gender, ObservableList<String> contact, ObservableList<String> selectedModules, boolean isPartTimer) {
        this.id = id;
        this.name = name;
        this.moduleName = moduleName;
        this.gender = gender;
        this.contact = contact;
        this.selectedModules = selectedModules;
        this.isPartTimer = isPartTimer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setContact(ObservableList<String> contact) {
        this.contact = contact;
    }

    public void setSelectedModules(ObservableList<String> selectedModules) {
        this.selectedModules = selectedModules;
    }

    public void setPartTimer(boolean partTimer) {
        isPartTimer = partTimer;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Gender getGender() {
        return gender;
    }

    public ObservableList<String> getContact() {
        return contact;
    }

    public ObservableList<String> getSelectedModules() {
        return selectedModules;
    }

    public boolean isPartTimer() {
        return isPartTimer;
    }
}
