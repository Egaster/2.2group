package lab2.TaskExtra;

public class Point {
    static final double EPS = 1e-5;
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

    private static boolean valueLiesBetween(double left, double right, double value){  //check if value lies between left and right
        return Math.min(left,right) <= value + EPS && value <= Math.max(left,right) + EPS;
    }

    public static boolean pointLiesBetween(Point a, Point b, Point m){  //check if Point M lies between Points A and B
        return valueLiesBetween(a.getX(), b.getX(), m.getX()) && valueLiesBetween(a.getY(),b.getY(), m.getY());
    }

    public static int comparePoints(Point a, Point b){
        if (b.getX() < a.getX()-EPS || Math.abs(b.getX()-a.getX())<EPS && b.getY()<a.getY()-EPS){  //b<a => a>b
            return 1;
        }
        else if (Math.abs(b.getX() - a.getX())<EPS && Math.abs(b.getY()-a.getY())<EPS) {  //a==b
            return 0;
        }
        else {  //a<b
            return -1;
        }
    }

    public static Point maxPoint(Point a, Point b){
        if (comparePoints(a,b) == 1) {
            return a;
        }
        else {
            return b;
        }
    }

    public static Point minPoint(Point a, Point b){
        if (comparePoints(a,b) == -1){
            return a;
        }
        else {
            return b;
        }
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return comparePoints(this, p) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        return result;
    }
}