package lab2.Task10;

import java.util.List;
import java.util.Random;

public class RandomNumbers {
    private static Random generator = new Random();
    public static int nextInt(int low, int high){
        return low + generator.nextInt(high - low + 1);
    }
    public static int randomElement(int[] ints){
        if (ints.length == 0){
            return 0;
        }
        return ints[nextInt(0, ints.length - 1)];
    }
    public static int randomElement(List<Integer> integers){
        if (integers.size() == 0){
            return 0;
        }
        return integers.get(nextInt(0, integers.size() - 1));
    }
}
