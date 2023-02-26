import java.util.ArrayList;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер треугольника Паскаля: ");
        int triangleSize = in.nextInt();
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>(triangleSize);

        for (int i = 0; i < triangleSize; i++){
            pascalTriangle.add(new ArrayList<>(i + 1));
            for (int k = 0; k < i + 1; k++){
                pascalTriangle.get(i).add(1);
            }

            for (int j = 1; j < i; j++){
                int value1 = pascalTriangle.get(i-1).get(j-1);
                int value2 = pascalTriangle.get(i-1).get(j);
                pascalTriangle.get(i).set(j,value1+value2);
            }
        }

        for (ArrayList<Integer> row: pascalTriangle){
            for (Integer value: row){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
