package Regexp;

import java.util.Arrays;

public class Lesson_2 {
    public static void main(String[] args) {
        String a = "Hello there hey";
        String [] words = a.split(" ");
        System.out.println(Arrays.toString(words));

        //replace принимает символ
        String a_mod = a.replace(" ",".");
        //replaceAll принимает регулярное выражение
        String b = "Hello1232456there123546hey";
        String b_mod = b.replaceAll("\\d+","-");
        System.out.println(b_mod);
        //replaceFirst заменяет только первое вхождение
        String b_mod2 = b.replaceFirst("\\d+","-");
        System.out.println(b_mod2);

    }
}
