package lab3.Task5;

import lab3.IntSequence;

public class Main5 {
    public static void main(String[] args) {
        IntSequence intSequence1 = IntSequence.constant(1);
        while (intSequence1.hasNext()) {
            System.out.println(intSequence1.next());
        }
    }
}
