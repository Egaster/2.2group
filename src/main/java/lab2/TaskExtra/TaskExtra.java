package lab2.TaskExtra;

import lab2.Task5.Point;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskExtra {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты верхней левой точки 1 прямоугольника (Сначала x, потом y):");
        double xUpLeft1 = in.nextDouble();
        double yUpLeft1 = in.nextDouble();
        Point upLeft1 = new Point(xUpLeft1, yUpLeft1);
        System.out.println("Введите координаты правой нижней точки 1 прямоугольника (Сначала x, потом y):");
        double xDownRight1 = in.nextDouble();
        double yDownRight1 = in.nextDouble();
        Point downRight1 = new Point(xDownRight1, yDownRight1);
        System.out.println("Введите координаты верхней левой точки 2 прямоугольника (Сначала x, потом y):");
        double xUpLeft2 = in.nextDouble();
        double yUpLeft2 = in.nextDouble();
        Point upLeft2 = new Point(xUpLeft2, yUpLeft2);
        System.out.println("Введите координаты правой нижней точки 2 прямоугольника (Сначала x, потом y):");
        double xDownRight2 = in.nextDouble();
        double yDownRight2 = in.nextDouble();
        Point downRight2 = new Point(xDownRight2, yDownRight2);

        Rectangle rec1;
        try {
            rec1 = new Rectangle(upLeft1, downRight1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        Rectangle rec2;
        try {
            rec2 = new Rectangle(upLeft2, downRight2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        ArrayList<ArrayList<Object>> intersects = Rectangle.rectanglesIntersection(rec1, rec2);
        System.out.println("Точки пересечения: ");
        for (ArrayList<Object> intersect: intersects){
            if (intersect.size() == 1){
                System.out.print(intersect.get(0) + " ");
                System.out.println();
            }
            else if (intersect.size() == 2) {
                System.out.print(intersect.get(0) + " ");
                Point p1 = (Point)intersect.get(1);
                System.out.print("x = "+p1.getX()+" ");
                System.out.print("y = "+p1.getY()+" ");
                System.out.println();
            }
            else if (intersect.size() == 3) {
                System.out.print(intersect.get(0) + " ");
                Point p1 = (Point)intersect.get(1);
                System.out.print("x = "+p1.getX()+" ");
                System.out.print("y = "+p1.getY()+" ");
                Point p2 = (Point)intersect.get(2);
                System.out.print("x = "+p2.getX()+" ");
                System.out.print("y = "+p2.getY()+" ");
                System.out.println();
            }
        }
    }
}
