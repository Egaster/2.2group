package lab4.Task5;

import lab4.Task1.Point;
import lab4.Task1.Shape;

public class Rectangle extends Shape implements Cloneable {
    private double width;
    private double height;
    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        return new Point( (point.getX() + width) / 2, (point.getY() + height) / 2 );
    }

    @Override
    protected Rectangle clone() {
        try {
            Rectangle cloned = (Rectangle) super.clone();
            cloned.point = new Point(point.getX(), point.getY());
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Rectangle[" +
                "width="+width+
                ", height"+height+
                ", point="+point+
                "]";
    }
}
