package lab2.TaskExtra;

import java.util.ArrayList;

import static lab2.TaskExtra.Point.EPS;

public class Line {


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
                boolean isIntersection = Point.pointLiesBetween(a, b, c) && Point.pointLiesBetween(c, d, b);
                if (isIntersection){
                    result.add(true);
                    Point resA = Point.minPoint(a,b);
                    Point resB = Point.maxPoint(a,b);
                    Point resC = Point.minPoint(c,d);
                    Point resD = Point.maxPoint(c,d);

                    Point resLeftEnd = Point.maxPoint(resA, resC);
                    Point resRightEnd = Point.minPoint(resB, resD);

                    if (Point.comparePoints(resLeftEnd, resRightEnd) == 0) {
                        result.add(resLeftEnd);
                    }
                    else {
                        result.add(resLeftEnd);  //add max left end
                        result.add(resRightEnd); //add min right end
                    }
                }
                else {
                    result.add(false);
                }
            }
            else {
                result.add(false);  //lines don't intersect
            }
        }
        else {  //det != 0
            double xRes = det1/det;
            double yRes = det2/det;
            Point intersectOnePoint = new Point(xRes, yRes);

            boolean isIntersection = Point.pointLiesBetween(a, b, intersectOnePoint) && Point.pointLiesBetween(c, d, intersectOnePoint);

            if (isIntersection){
                result.add(true);
                result.add(intersectOnePoint);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

}
