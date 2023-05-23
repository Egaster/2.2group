package lab4.Extra;

import lab3.Employee;

import java.util.List;

public class MyClass {
    private String field1;
    private int field2;
    private List<Employee> employees;
    public void setField1(String field1) {
        this.field1 = field1;
    }
    public void setField2(int field2) {
        this.field2 = field2;
    }

    @Key
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    @Key
    public String getField1() {
        return field1;
    }
    @Key
    public int getField2() {
        return field2;
    }
}