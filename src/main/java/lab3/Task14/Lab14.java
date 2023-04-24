package lab3.Task14;

import java.util.Arrays;
import java.util.Comparator;

public class Lab14 {
    public static void main(String[] args) {

        Employee[] employees = Lab1_2.createRandomListEmployees();
        System.out.println("employees: " + Arrays.toString(employees));

        Arrays.sort(employees, Comparator.comparing(Employee::getMeasure).thenComparing(Employee::getName));
        System.out.println("employees after sort: " + Arrays.toString(employees));

        Arrays.sort(employees, Comparator.comparing(Employee::getMeasure).thenComparing(Employee::getName).reversed());
        System.out.println("employees after reversed sort: " + Arrays.toString(employees));
    }
}