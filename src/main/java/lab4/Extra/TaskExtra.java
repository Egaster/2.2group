package lab4.Extra;

import lab3.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TaskExtra {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MyClass instance = set(MyClass.class, new Pair<>("field1", "value1"), new Pair<>("field2", 2), new Pair<>("employees", List.of(new Employee("Fred", 123))));

        System.out.println(instance.getField1());
        System.out.println(instance.getField2());
        System.out.println(instance.getEmployees());
    }

    @SafeVarargs
    public static <T> T set(Class<T> clazz, Pair<String, Object>... pairs) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Pair<String, Object> pair: pairs) {
            String key = pair.getKey();
            Object value = pair.getValue();

            Method getter = findGetter(clazz, key);
            if (getter != null) {
                String fieldName = getGetterFieldName(getter.getName());
                Method setter = findSetter(clazz, fieldName);
                if (setter != null) {
                    setter.invoke(instance, value);
                }
            }
        }

        return instance;
    }

    private static Method findGetter(Class<?> clazz, String name) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            if (isGetter(method) && method.isAnnotationPresent(Key.class) && name.equals(getGetterFieldName(method.getName()))) {
                return method;
            }
        }
        return null;
    }

    private static String getGetterFieldName(String getterName) {
        return Character.toLowerCase(getterName.charAt(3)) + getterName.substring(4);
    }
    private static boolean isGetter(Method method) {
        String methodName = method.getName();
        return methodName.startsWith("get") && method.getParameterCount() == 0 && !method.getReturnType().equals(void.class);
    }

    private static Method findSetter(Class<?> clazz, String fieldName) {
        String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
            return clazz.getMethod(setterName, clazz.getDeclaredField(fieldName).getType());
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            return null;
        }
    }
}
