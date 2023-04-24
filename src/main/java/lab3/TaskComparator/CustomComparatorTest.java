package lab3.TaskComparator;

import java.util.ArrayList;
import java.util.List;

public class CustomComparatorTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 25));
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Bob", 20));
        persons.add(new Person("Charlie", 35));

        System.out.println("Список до сортировки:");
        for (Person person : persons) {
            System.out.println(person);
        }

        CustomComparator<Person> ageComparator = CustomComparator.comparing(Person::getName);

        persons.sort(ageComparator);

        System.out.println("\nСписок после сортировки по возрасту:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    // Пример класса Person для сортировки
    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
