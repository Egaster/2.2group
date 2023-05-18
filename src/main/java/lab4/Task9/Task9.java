package lab4.Task9;

import lab4.Task1.Point;
import lab4.Task5.Rectangle;
import lab4.Task5.Task5;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.StringJoiner;
public class Task9 {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle = new Rectangle(new Point(1, 1), 100, 50);
        System.out.println(toString(rectangle));
        System.out.println(toString("c"));
    }

//    public static String toString(Object o) throws Exception {
//        Class<?> clazz = o.getClass();
//        StringJoiner joiner = new StringJoiner(",", clazz.getName() + "{", "}");
//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            joiner.add(field.getName() + "=" + field.get(o).toString());
//        }
//        return joiner.toString();
//    }


    public static String toString(Object o) throws Exception{
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        sb.append(clazz.getSimpleName()).append("[");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(field.getName()).append("=").append(field.get(o)).append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }
}
