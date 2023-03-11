package lab2.Task5;

public class Point {
    private final double x;
    private final double y;
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
        return new Point(x+dx,y+dy);
    }
    public Point scale(double ratio){
        return new Point(x*ratio,y*ratio);
    }

}