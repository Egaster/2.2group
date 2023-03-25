package lab2.TaskExtra;

import lab2.Task5.Point;

import java.util.ArrayList;

public class Line {
    static final double EPS = 1e-5;

    //ax + by + c = 0 - line equation
    private final double a;
    private final double b;
    private final double c;

    public Line(double a, double b, double c){
        this.a = a; this.b = b; this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    //line segment PQ (we know Px, Py, Qx, Qy
    private Line normalize(){
        double z = Math.sqrt(a*a + b*b);
        if (z != 0 && Math.abs(z) > EPS){
            return new Line(a/z, b/z,c/z);
        }
        else {
            return this;
        }
    }

    private static double det(double a, double b, double c, double d){
        return a*d-b*c;
    }

    private static Line normalizedLineEquation(Point p, Point q){
        double a = p.getY() - q.getY();
        double b = q.getX() - p.getX();
        double c = -a*p.getX() - b*p.getY();
        return new Line(a,b,c).normalize();  //returned normalized line equation
    }

    private static boolean liesBetween(double left, double right, double value){  //check if x lies between left and right
        return Math.min(left,right) <= value + EPS && value <= Math.max(left,right) + EPS;
    }
    public static ArrayList<Object> intersect(Point a, Point b, Point c, Point d){
        ArrayList<Object> result = new ArrayList<>();
        Line line1 = normalizedLineEquation(a,b);
        Line line2 = normalizedLineEquation(c,d);
        double a1 = line1.getA();
        double b1 = line1.getB();
        double c1 = line1.getC();

        double a2 = line2.getA();
        double b2 = line2.getB();
        double c2 = line2.getC();

        double det = det(a1,b1,a2,b2);  //Kramer coefficient
        double det1 = (-1)*det(c1,b1,c2,b2);
        double det2 = (-1)*det(a1,c1,a2,c2);

        if (Math.abs(det) < EPS) {  //det == 0
            if (Math.abs(det1) < EPS && Math.abs(det2) < EPS){  //det1==0 and det2==0 - lines match
                //Add max left and min right end
                boolean isIntersection = liesBetween(a.getX(), b.getX(), c.getX()) && liesBetween(a.getY(),b.getY(), c.getY()) &&
                                         liesBetween(c.getX(), d.getX(), b.getX()) && liesBetween(c.getY(), d.getY(), b.getY());
                if (isIntersection){
                    result.add(true);
                    //add max left end
                    if (b.getX() < a.getX()-EPS || Math.abs(b.getX()-a.getX())<EPS && b.getY()<a.getY()-EPS){
                        result.add(a);
                    }
                    else {
                        result.add(b);
                    }
                    //add min right end
                    if (d.getX() < c.getX()-EPS || Math.abs(d.getX()-c.getX())<EPS && d.getY()<c.getY()-EPS){
                        result.add(d);
                    }
                    else {
                        result.add(c);
                    }
                }
            }
            else {
                result.add(false);  //lines don't intersect
            }
        }
        else {  //det != 0
            double xRes = det1/det;
            double yRes = det2/det;

            boolean isIntersection = liesBetween(a.getX(), b.getX(),xRes) &&
                                   liesBetween(a.getY(), b.getY(), yRes) &&
                                   liesBetween(c.getX(), d.getX(), xRes) &&
                                   liesBetween(c.getY(), d.getY(), yRes);
            if (isIntersection){
                result.add(true);
                Point intersectOnePoint = new Point(xRes, yRes);
                result.add(intersectOnePoint);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

}
