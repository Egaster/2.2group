package lab3.Task1;

import lab3.Employee;
import lab3.Measurable;

public class Main1 {
    public static void main(String[] args){
        Employee e1 = new Employee("Alex", 2);
        Employee e2 = new Employee("Marina", 0);
        Employee e3 = new Employee("Yura", 1);
        Measurable[] employees = {e1,e2,e3};
        System.out.println(average(employees));
    }

    private static double average(Measurable[] objects){
        double sum = 0;
        for(Measurable i: objects){
            sum = sum + i.getMesurable();
        }
        return sum/objects.length;
    }
}
