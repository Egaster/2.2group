package lab2.Task10;

import java.util.Collections;
import java.util.List;

import static lab2.Task10.RandomNumbers.randomElement;

public class Main10 {
    public static void main(String[] args) {
        System.out.println(randomElement(new int[]{2323,1111,54,121,8}));
        System.out.println(randomElement(List.of(3232,67878,34,898,232)));
        System.out.println(randomElement(new int[0]));
        System.out.println(randomElement(Collections.emptyList()));
    }
}