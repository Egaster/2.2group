package lab4.Task9;

import java.lang.reflect.Field;
import java.util.*;

public class Task9 {
    private static Set<Object> alreadyWatched;

    private static final Set<Class<?>> BOX_TYPES;

    static {
        BOX_TYPES = new HashSet<>();

        BOX_TYPES.add(Boolean.class);
        BOX_TYPES.add(Character.class);
        BOX_TYPES.add(Byte.class);
        BOX_TYPES.add(Short.class);
        BOX_TYPES.add(Integer.class);
        BOX_TYPES.add(Long.class);
        BOX_TYPES.add(Float.class);
        BOX_TYPES.add(Double.class);
        BOX_TYPES.add(Void.class);
    }

    public static boolean isBoxType(Class<?> clazz) {
        return BOX_TYPES.contains(clazz);
    }

    public static void main(String[] args) throws Exception {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        class1.otherClass = class2;
        class2.otherClass = class1;
        Integer a = 4;
        System.out.println(toString(class1));
        System.out.println(toString(a));
    }


     public static String toString(Object object) throws IllegalAccessException {
        boolean isFirst = false;
        if (alreadyWatched == null) {
            alreadyWatched = new HashSet<>();
            isFirst = true;
        }
        if (alreadyWatched.contains(object)) {
            return null;
        }
        alreadyWatched.add(object);
        Class<?> clazz = object.getClass();
        StringJoiner joiner = new StringJoiner(",", clazz.getName() + "{", "}");
        if (clazz.isArray()) {
            joiner.add(object.toString());
        } else if (clazz.isPrimitive() || clazz.getSimpleName().equals("String") || isBoxType(clazz)) {
            joiner.add(object.toString());
        } else {
            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    if (fieldType.isArray()) {
                        joiner.add(field.getName() + "=" + field);
                    } else if (fieldType.isPrimitive() || fieldType.getSimpleName().equals("String") || isBoxType(fieldType))
                        joiner.add(field.getName() + "=" + field.get(object).toString());
                    else {
                        String result = toString(field.get(object));
                        if (result != null) {
                            joiner.add(result);
                        }
                    }
                }
                clazz = clazz.getSuperclass();
            }
        }

        if (isFirst) {
            alreadyWatched = null;
        }
        return joiner.toString();
    }
}