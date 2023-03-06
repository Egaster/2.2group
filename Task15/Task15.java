import java.util.ArrayList;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер треугольника Паскаля: ");
        int triangleSize = in.nextInt();
        ArrayList<ArrayList<Integer>> pascalTriangle = generatePascalTriangle(triangleSize);
        printReverseTriangle(pascalTriangle);
    }

    private static ArrayList<ArrayList<Integer>> generatePascalTriangle(int triangleSize){
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
        return pascalTriangle;
    }

    private static void printTriangle(ArrayList<ArrayList<Integer>> pascalTriangle){

        int numberOfRows = pascalTriangle.size();
        ArrayList<Integer> lastRow = pascalTriangle.get(numberOfRows - 1);
        int largestElement = lastRow.get(lastRow.size() / 2);
        int elementWidth = String.valueOf(largestElement).length();

        int triangleWidth = formatRow(lastRow, elementWidth).length();

        for (ArrayList<Integer> row : pascalTriangle){
            System.out.println(centerString(formatRow(row, elementWidth),triangleWidth));
        }
    }

    private static void printReverseTriangle(ArrayList<ArrayList<Integer>> pascalTriangle){
        int numberOfRows = pascalTriangle.size();
        ArrayList<Integer> lastRow = pascalTriangle.get(numberOfRows - 1);
        int largestElement = lastRow.get(lastRow.size() / 2);
        int elementWidth = String.valueOf(largestElement).length();

        int triangleWidth = formatRow(lastRow, elementWidth).length();

        for (int i = numberOfRows - 1; i >= 0; i--){
            ArrayList<Integer> row = pascalTriangle.get(i);
            System.out.println(centerString(formatRow(row, elementWidth),triangleWidth));
        }
    }

    private static String formatRow(ArrayList<Integer> row, int elementWidth){
        StringBuilder resRow = new StringBuilder();
        for (Integer element : row){
            resRow.append(centerString(String.valueOf(element), elementWidth));
            resRow.append(" ");
        }
        return resRow.toString();
    }
    private static String centerString(String str, int width){
        int padSize = width - str.length();
        int padStart = str.length() + padSize / 2;
        String res = String.format("%" + padStart + "s", str);
        res = String.format("%-" + width  + "s", res);
        return res;
    }

}
