package Regexp;

public class Lesson_1 {
    public static void main(String[] args) {
        /*
            \\d - одна цифра
            \\w - одна буква

            + - 1 или более
            * - 0 или более
            ? - 0 или 1 символов до
            (x|y|z) - одно из множества
            [a-zA-Z] - все английские буквы
            [0-9] = \\d
            [^awd] - исключаем символы
            . - любой символ
            {2} - 2 символа до (\\d{2})
            {2, } - 2 или более символов до (\\d{2, })
            {2, 4} - от 2 до 4 символов до (\\d{2,4})

         */
        String a = "1";//5
        System.out.println(a.matches("1"));//t//f

        a = "1"; //="2"//="91"
        System.out.println(a.matches("\\d"));//true//true//false

        a = "13456";//1//""
        System.out.println(a.matches("\\d+"));//t//t//f

        a = "13456";//1//""
        System.out.println(a.matches("\\d+"));//t//t//t

        a = "13456";
        System.out.println(a.matches("-\\d+"));//f
        //"\\d*" --> false
        System.out.println(a.matches("-?\\d*"));//t

        a = "12345";//-12345//+12345
        System.out.println(a.matches("(-|\\+)?\\d*"));//t//t//t

        a = "k12345";//T1234//fhxdfhgfh123456
        System.out.println(a.matches("[a-zA-Z]+\\d*"));//t//t//t

        a = "ace";//abcd
        System.out.println(a.matches("[^bd]*"));//t//f

        a = "http://www.google.com";
        System.out.println(a.matches("http://www\\..+\\.(com|ru)"));

        a = "123";//12//1
        System.out.println(a.matches("\\d{2}"));//f//t//f

        a = "123";//12//1
        System.out.println(a.matches("\\d{2,}"));//t//t//f
    }
}
