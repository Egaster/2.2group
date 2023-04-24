package lab3.Task14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab1_2 {
    private static final Random rand = new Random();


    public static Employee[] createRandomListEmployees() {
        List<Employee> employees = new ArrayList<>();
        String[] names = {"Alex", "Sasha", "Mike", "Stiven", "Jek", "Bob"};
        int count = rand.nextInt(30);
        for (int i = 0; i < count; i++) {
            employees.add(new Employee(names[rand.nextInt(names.length - 1)], rand.nextInt(25_000, 150_000)));
        }
        return employees.toArray(new Employee[0]);
    }
}
