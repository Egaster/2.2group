package lab2.Task6;

public class Point {
    private double x;
    private double y;
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Point translate(double dx, double dy){
        this.x += dx;
        this.y += dy;
        return this;
    }
    public Point scale(double ratio){
        this.x *= ratio;
        this.y *= ratio;
        return this;
    }

}
