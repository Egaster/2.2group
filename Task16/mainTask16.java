package Task16;

public class mainTask16 {
    public static void main(String[] args) {
        double avg = average(2, 2);
        System.out.println(avg);
    }

    public static double average(double first, double... rest) {
        double sum = first;
        for (double value: rest){
            sum += value;
        }
        return sum / (rest.length + 1);
    }
}