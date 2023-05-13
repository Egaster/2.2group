package lab4.Task1;

import java.util.Objects;

public class Point {
    protected double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "x=" + x + "," +
                "y=" + y +
                "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Point other = (Point) otherObject;
        return Objects.equals(other.x, x) &&
                Objects.equals(other.y, y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

