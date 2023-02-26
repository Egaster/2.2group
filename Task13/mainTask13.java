package Task13;

import java.util.Random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class mainTask13 {
    public static void main(String[] args) {

        List<Integer> list = IntStream.rangeClosed(1,49).boxed().collect(Collectors.toList());
        int[] res = new int[6];
        for (int i = 0; i < 6; i++) {
            Random rand = new Random();
            int idx = rand.nextInt(49);
            res[i] = list.remove(idx);
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
    }
}
