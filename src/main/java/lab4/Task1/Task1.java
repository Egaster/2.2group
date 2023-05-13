package lab4.Task1;

public class Task1 {
    public static void main(String[] args) {
        Point point = new Point(1.0, 2.0);
        System.out.println(point);

        LabeledPoint labeledPoint = new LabeledPoint("label",1.0,3.0);
        System.out.println(labeledPoint);

        //For task 3
        double y = point.y;
        double x = labeledPoint.x;
        System.out.println(x + " " + y);
    }
}
