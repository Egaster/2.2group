package lab3.Task6;

import java.util.Iterator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Iterator<Integer> sequence = new DigitSequence();
        print(sequence, 10);
        sequence.remove();
    }
    private static void print(Iterator<Integer> sequence, int limit) {
        Stream.generate(sequence::next).limit(limit).forEach(System.out::println);
    }
}
