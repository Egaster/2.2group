package lab2.TaskExtra;

import static lab2.TaskExtra.Line.EPS;

import lab2.Task5.Point;

import java.util.ArrayList;

public class Rectangle {
    private final Point upLeft;
    private final Point downRight;
    public Rectangle(Point upLeft, Point downRight) throws Exception {
        if (
                upLeft.getY() < downRight.getY()+EPS || downRight.getX() < upLeft.getX()+EPS ||
                Math.abs(upLeft.getX() - downRight.getX()) < EPS && Math.abs(upLeft.getY()- downRight.getY())<EPS
           )
        {
            throw new Exception("Wrong input of points!");
        }

        else {
            this.upLeft = upLeft;
            this.downRight = downRight;
        }
    }
    public Point getUpLeft() {
        return upLeft;
    }
    public Point getDownRight() {
        return downRight;
    }

    private Point[][] recSegments(){
        Point upLeftSameY = new Point(downRight.getX(),upLeft.getY());
        Point upLeftSameX = new Point(upLeft.getX(), downRight.getY());

        Point[][] result = {
                {upLeft, upLeftSameY},
                {upLeftSameX, downRight},
                {upLeftSameX, upLeft},
                {downRight, upLeftSameY}
        };

        return result;
    }
    public static ArrayList<ArrayList<Object>> rectanglesIntersection(Rectangle rec1, Rectangle rec2){
        ArrayList<ArrayList<Object>> result = new ArrayList<>();

        Point[][] rec1LineSegments = rec1.recSegments();
        Point[][] rec2LineSegments = rec2.recSegments();

        for (Point[] pairPoints1: rec1LineSegments){
            for (Point[] pairPoints2: rec2LineSegments) {
                ArrayList<Object> intersect = Line.intersect(pairPoints1[0], pairPoints1[1], pairPoints2[0], pairPoints2[1]);
                result.add(intersect);
            }
        }
        return result;
    }
}
