package lab4.Task1;

public abstract class Shape {
    protected Point point;
    public Shape(Point point) {
        this.point = point;
    }
    public void moveBy(double dx, double dy) {
        point.x += dx;
        point.y += dy;
    }

    public abstract Point getCenter();
}
