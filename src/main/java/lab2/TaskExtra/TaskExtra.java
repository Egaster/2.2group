package lab2.TaskExtra;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskExtra {
    private static final int COUNT_OF_RECTANGLES = 2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rectangle[] rectangles = new Rectangle[COUNT_OF_RECTANGLES];

        for(int i = 0; i < COUNT_OF_RECTANGLES; i++){
            System.out.println("Введите координаты верхней левой точки "+ (i+1) +" прямоугольника (Сначала x, потом y):");
            double xUpLeft = in.nextDouble();
            double yUpLeft = in.nextDouble();
            Point upLeft = new Point(xUpLeft, yUpLeft);
            System.out.println("Введите координаты правой нижней точки "+ (i+1) +" прямоугольника (Сначала x, потом y):");
            double xDownRight = in.nextDouble();
            double yDownRight = in.nextDouble();
            Point downRight = new Point(xDownRight, yDownRight);
            try {
                rectangles[i] = new Rectangle(upLeft, downRight);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return;
            }
        }

        ArrayList<ArrayList<Point>> intersects = Rectangle.rectanglesIntersection(rectangles[0], rectangles[1]);
        System.out.println("Точки пересечения: ");

        if (intersects.isEmpty()){
            System.out.println("Нет точек пересечения");
            return;
        }

        for (ArrayList<Point> intersect: intersects) {
            if (intersect.size() == 1) {
                System.out.print("Point: ");
                Point p1 = intersect.get(0);
                System.out.print("x = "+p1.getX()+" , ");
                System.out.print("y = "+p1.getY()+" ");
                System.out.println();
            }
            else if (intersect.size() == 2) {
                System.out.print("Line segment: ");
                Point p1 = intersect.get(0);
                System.out.print("x = "+p1.getX()+" , ");
                System.out.print("y = "+p1.getY()+" ");
                Point p2 = intersect.get(1);
                System.out.print("x = "+p2.getX()+" , ");
                System.out.print("y = "+p2.getY()+" ");
                System.out.println();
            }
        }
    }
}
