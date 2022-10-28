package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Pattern and Matcher**/
public class Lesson_3 {
    public static void main(String[] args) {
        String text = "Hello, Guys! I send you my email joe@list.ru so we can\n" +
                "keep in touch. Thanks, Joe! That's cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";

        //паттерн программирования
        //контсруктор - приватный
        //статический метод после своей работы возвращает объект класса
        Pattern email = Pattern.compile("(\\w+)@(list|yandex)\\.(com|ru)"); // (\w) - группа
        Matcher matcher = email.matcher(text);

        //id 1, 2, 3 ... NOT 0!      1     4   5
        //(()()) () (()) -------> ((2)(3)) () ((6))
        while (matcher.find()){
            System.out.println(matcher.group(1));// (1) - 1 id группы
        }
    }
}

