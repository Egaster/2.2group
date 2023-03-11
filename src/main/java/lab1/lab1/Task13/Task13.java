package lab1.lab1.Task13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task13 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= 49; i++){
            array.add(i);
        }
        int[] res = new int[6];
        Random rand = new Random();
        for (int i = 0; i < 6; i++){
            int randomIndex = rand.nextInt(array.size());
            res[i] = array.remove(randomIndex);
        }
        Arrays.sort(res);
        for (int x: res){
            System.out.print(x + " ");
        }
    }
}
