import java.lang.reflect.Method;

public class Reflect {
    public static void listMethods(String className) {

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("Методы используемые в классе " + className + ":");
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method.getName());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Дружок у тебя нету класса с названием " + className + ", поменяй неймес класса пж");
        }
    }
}