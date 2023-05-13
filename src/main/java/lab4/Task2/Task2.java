package lab4.Task2;

import lab4.Task1.LabeledPoint;
import lab4.Task1.Point;

public class Task2 {
    public static void main(String[] args) {
        Point point = new Point(1.0, 2.0);
        System.out.println(point);
        System.out.println(point.hashCode());
        System.out.println(point.equals(new Point(1.0, 2.0)));

        LabeledPoint labeledPoint = new LabeledPoint("label", 1.0, 3.0);
        System.out.println(labeledPoint);
        System.out.println(labeledPoint.hashCode());
        System.out.println(labeledPoint.equals(new LabeledPoint("label_1", 1.0, 3.0)));
    }
}
