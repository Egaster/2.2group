
package lab3.Task15;

public class Lab15 {
    public static void main(String[] args) {
        IntSequence randomSequence = new IntSequence.RandomSequence(10, 100);
        for (int i = 0; i < 100; i++) {
            System.out.println(randomSequence.next());
        }
    }
}
