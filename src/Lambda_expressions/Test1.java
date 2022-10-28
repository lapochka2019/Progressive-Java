package Lambda_expressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Good");
        list.add("a");
        list.add("Long string");

        list.sort((s1,s2) -> {
            if (s1.length()>s2.length()) return 1;
            else if (s1.length()<s2.length()) return -1;
            else return 0;
        });

        //Comparator<String> comparator = (s1,s2) -> {
        //    if (s1.length() > s2.length()) return 1;
        //    else if (s1.length() < s2.length()) return -1;
        //    else return 0;
        //};
        //    list.sort(comparator);
        System.out.println(list);
    }
}
