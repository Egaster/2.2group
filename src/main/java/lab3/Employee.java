package lab3;

import lab3.Measurable;

public class Employee implements Measurable {

    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }
    @Override
    public double getMesurable() {
        return salary;
    }

    @Override
    public String toString() {
        return "{ name: " + name + ", salary: " + salary + '}';
    }
}
