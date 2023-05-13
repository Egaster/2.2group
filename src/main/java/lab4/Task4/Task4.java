package lab4.Task4;

import lab4.Task1.Point;
import lab4.Task5.Circle;

public class Task4 {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(2, 5), 10);
        System.out.println(circle.getCenter());
        circle.moveBy(6, 0);
        System.out.println(circle.getCenter());
    }
}
