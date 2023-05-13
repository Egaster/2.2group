package lab4.Task5;

import lab4.Task1.Point;
import lab4.Task1.Shape;

public class Line extends Shape implements Cloneable {
    private Point from;
    private Point to;
    public Line(Point from, Point to) {
        super(null);
        this.from = from;
        this.to = to;
        this.point = new Point((from.getX() + to.getX()) / 2, (from.getY() + to.getY()) / 2);
    }

    @Override
    public Point getCenter() {
        return point;
    }

    @Override
    protected Line clone() {
        try {
            Line cloned = (Line) super.clone();
            cloned.point = new Point(point.getX(), point.getY());
            cloned.from = new Point(from.getX(), from.getY());
            cloned.to = new Point(to.getX(), to.getY());
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
