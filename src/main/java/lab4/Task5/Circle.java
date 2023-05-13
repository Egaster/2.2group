package lab4.Task5;

import lab4.Task1.Point;
import lab4.Task1.Shape;

public class Circle extends Shape implements Cloneable {
    private double radius;
    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }
    @Override
    public Point getCenter() {
        return this.point;
    }

    @Override
    public String toString() {
        return "Circle["+
                "center="+point+
                ", radius="+radius+
                "]";
    }

    @Override
    protected Circle clone() {
        try {
            Circle cloned = (Circle) super.clone();
            cloned.point = new Point(point.getX(), point.getY());
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
