package Java_Reflection_API;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();

    int dateOfCreation();
}
