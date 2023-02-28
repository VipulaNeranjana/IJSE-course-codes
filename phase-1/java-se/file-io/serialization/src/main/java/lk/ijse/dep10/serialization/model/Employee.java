package lk.ijse.dep10.serialization.model;

import javafx.scene.control.Button;
import lk.ijse.dep10.serialization.model.PersonInfo;
import lk.ijse.dep10.serialization.enmumaration.Status;


import java.io.Serializable;

public class Employee implements Serializable {

    private String id;
    private PersonInfo employeeInfo;
    private Status status;
    private PersonInfo spouseInfo;
    private transient Button btnDelete;

    public Employee(String id, PersonInfo employeeInfo, Status status, PersonInfo spouseInfo, Button btnDelete) {
        this.id = id;
        this.employeeInfo = employeeInfo;
        this.status = status;
        this.spouseInfo = spouseInfo;
        this.btnDelete = btnDelete;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public Employee() {
    }

    public String getName() {
        return employeeInfo.getName();
    }

    public void setEmployeeInfo(PersonInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getSpouseName() {
        return this.status == Status.MARRIED ? spouseInfo.getName() : "-" ;
    }

    public void setSpouseInfo(PersonInfo spouseInfo) {
        this.spouseInfo = spouseInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
