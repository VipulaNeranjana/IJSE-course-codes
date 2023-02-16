package model;

import java.util.ArrayList;

public class Modules {
    public String moduleName;
    public ArrayList<String> subjects;

    public Modules(String moduleName, ArrayList<String> subjects) {
        this.moduleName = moduleName;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return moduleName;
    }
}
