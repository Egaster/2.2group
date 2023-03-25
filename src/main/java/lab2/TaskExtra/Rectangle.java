package lab2.TaskExtra;

import static lab2.TaskExtra.Point.comparePoints;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Rectangle {
    private final Point upLeft;
    private final Point downRight;
    public Rectangle(Point upLeft, Point downRight) throws Exception {
        if (upLeft.equals(downRight) || comparePoints(upLeft, downRight) == 1)
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
    public static ArrayList<ArrayList<Point>> rectanglesIntersection(Rectangle rec1, Rectangle rec2){
        ArrayList<ArrayList<Object>> result = new ArrayList<>();

        Point[][] rec1LineSegments = rec1.recSegments();
        Point[][] rec2LineSegments = rec2.recSegments();

        for (Point[] pairPoints1: rec1LineSegments){
            for (Point[] pairPoints2: rec2LineSegments) {
                ArrayList<Object> intersect = Line.intersect(pairPoints1[0], pairPoints1[1], pairPoints2[0], pairPoints2[1]);
                result.add(intersect);
            }
        }
        return filterResultOfRectanglesIntersection(result);
    }

    private static ArrayList<ArrayList<Point>> filterResultOfRectanglesIntersection(ArrayList<ArrayList<Object>> intersections){
        ArrayList<ArrayList<Point>> filteredResult = new ArrayList<>();
        Set<Point> uniquePoints = new HashSet<>();

        for (ArrayList<Object> intersect: intersections){
            if (intersect.size() == 3){
                ArrayList<Point> segment = new ArrayList<>();
                Point p1 = (Point) intersect.get(1);
                Point p2 = (Point) intersect.get(2);
                uniquePoints.add(p1);
                uniquePoints.add(p2);
                segment.add(p1);
                segment.add(p2);
                filteredResult.add(segment);
            }
        }
        for (ArrayList<Object> intersect: intersections){
            if (intersect.size() == 2){
                Point p = (Point) intersect.get(1);
                boolean isAddedToUniquePointsSet;
                isAddedToUniquePointsSet = uniquePoints.add(p);

                if (isAddedToUniquePointsSet){
                    ArrayList<Point> segment = new ArrayList<>();
                    segment.add(p);
                    filteredResult.add(segment);
                }
            }
        }
        return filteredResult;
    }
}
