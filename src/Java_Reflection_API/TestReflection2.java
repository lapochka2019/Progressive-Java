package Java_Reflection_API;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);
        //first_class name second_class name method name
        Class classObj1 = Class.forName(scan.next());
        Class classObj2 = Class.forName(scan.next());
        String s =  scan.next();

        Method m = classObj1.getMethod(s, classObj2);
        Object o1 = classObj1.newInstance();
        Object o2 = classObj2.getConstructor(String.class).newInstance("String value");

        m.invoke(o1,o2);

        System.out.println(o1);
    }
}
