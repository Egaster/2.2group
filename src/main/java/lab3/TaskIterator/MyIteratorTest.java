package lab3.TaskIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MyIteratorTest {
    public static void main(String[] args) {
        // Создаем список чисел
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // Создаем MyIterator из списка
        MyIterator<Integer> iterator = MyIterator.fromIterator(numbers.iterator());

        // Тест метода reduce
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        MyIterator<Integer> sumIterator = iterator.reduce(sum);
        System.out.println("Sums of two adjacent numbers:");
        while (sumIterator.hasNext()) {
            System.out.println(sumIterator.next());
        }

        // Тест метода union
        List<Integer> otherNumbers = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
        iterator = MyIterator.fromIterator(numbers.iterator());
        MyIterator<Integer> otherIterator = MyIterator.fromIterator(otherNumbers.iterator());
        MyIterator<Integer> unionIterator = iterator.union(otherIterator);
        System.out.println("All numbers:");
        while (unionIterator.hasNext()) {
            System.out.println(unionIterator.next());
        }

        // Тест метода filter
        Predicate<Integer> isEven = n -> n % 2 == 0;
        iterator = MyIterator.fromIterator(numbers.iterator());
        MyIterator<Integer> evenNumbers = iterator.filter(isEven);
        System.out.println("Even numbers:");
        while (evenNumbers.hasNext()) {
            System.out.println(evenNumbers.next());
        }
    }
}
