package lab2.Task5;
public class Main5 {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.printf("Point: (x = %.5f; y = %.5f)", p.getX(), p.getY());
    }
}