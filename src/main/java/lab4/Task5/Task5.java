package lab4.Task5;

import lab4.Task1.Point;

public class Task5 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(new Point(1, 1), 100, 50);
        Rectangle cloned = rectangle.clone();
        cloned.moveBy(0, 40);
        System.out.println("rectangle: "+rectangle);
        System.out.println("cloned: "+cloned);

        Circle circle = new Circle(new Point(2, 5), 10);
        Circle circleCloned = circle.clone();
        System.out.println("circle: "+circle);
        System.out.println("circle cloned: "+circleCloned);
    }
}
