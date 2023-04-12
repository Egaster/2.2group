package lab3.Task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        while (true){
            for (int i = 0; i < strings.size() - 1; i++){
                if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
                    return;
                }
            }
            Collections.shuffle(strings);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("a","bb","ccc","dddd","eeeee"));
        System.out.println("Old strings: "+strings);
        luckySort(strings, Comparator.comparing(String::toString));
        System.out.println("New strings: "+strings);
    }
}
