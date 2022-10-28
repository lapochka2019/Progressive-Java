package Java_Reflection_API;

import java.lang.annotation.Annotation;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class personClass = Person.class;

        Person person = new Person();
        Class personClass3 = person.getClass();

        //Class personClass2 = Class.forName("Person");

        /*Method[] methods = personClass.getMethods();
        for (Method method: methods){
            System.out.println(method.getName() + " , " + method.getReturnType() +
                    " , " + Arrays.toString(method.getParameterTypes()));
        }*/

        /*Field[] fields = personClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName() + " , " + field.getType());
        }*/

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation: annotations){
            if(annotation instanceof Author)
                System.out.println("Yes");
        }
    }
}
