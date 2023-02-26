import java.util.*;

public class Task14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите элементы квадрата:");
        List<Integer> array = new ArrayList<>();

        while (true){
            String row = in.nextLine();
            if (row.trim().isEmpty()){
                break;
            }
            for (String strNumber: row.split("\\s+")){
                if (strNumber.isEmpty()){
                    continue;
                }
                int x = Integer.parseInt(strNumber);
                array.add(x);
            }
        }

        int size = array.size();
        int sizeSquare = isCompleteSquare(size);
        if (sizeSquare == -1){
            throw new RuntimeException("You entered not square matrix");
        }

        int[][] square = new int[sizeSquare][sizeSquare];
        for (int i = 0; i < sizeSquare; i++){
            for (int j = 0; j < sizeSquare; j++){
                square[i][j] = array.get(i * sizeSquare + j);
            }
        }

        System.out.println("Введенный квадрат:");
        for (int[] row: square){
            for (int value: row){
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(isMagicSquare(square) ? "Есть магический квадрат" : "Нет магического квадрата");
    }

    private static boolean isMagicSquare(int[][] array){
        boolean result = true;

        //check sum in diagonals
        int sumDiagMain = 0;
        int sumDiagSide = 0;
        for (int i = 0; i < array.length; i++){
            sumDiagMain += array[i][i];
            sumDiagSide += array[i][array.length - i - 1];
        }
        int uniqueSum = sumDiagMain;
        if (sumDiagSide != uniqueSum){
            result = false;
        }

        System.out.println("Сумма по главной диагонали: " + sumDiagMain);
        System.out.println("Сумма по побочной диагонали: " + sumDiagSide);

        //check sums in rows
        for (int i = 0; i < array.length; i++){
            int sum = 0;
            for (int j = 0; j < array.length; j++){
                sum += array[i][j];
            }
            if (sum != uniqueSum){
                result = false;
            }
            System.out.println("Сумма по " + (i + 1) + " строке: " + sum);
        }

        //check sum in columns
        for (int i = 0; i < array.length; i++){
            int sum = 0;
            for (int j = 0; j < array.length; j++){
                sum += array[j][i];
            }
            if (sum != uniqueSum){
                result = false;
            }
            System.out.println("Сумма по " + (i + 1) + " столбцу: " + sum);
        }
        return result;
    }


    //method isCompleteSquare checks if the number is a complete square. If it is, method returns sqrt(n), else returns -1
    private static int isCompleteSquare(int n){
        int sum = 0, count = 0;
        for (int i = 1; sum < n ; i += 2){
            sum += i;
            count++;
        }
        if (sum == n){
            return count;
        }
        else {
            return -1;
        }
    }
}
