package Collections.Collection_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_S {
    public static void main(String[] args) {
        List <String> animals = new ArrayList<>();

        animals.add("bird");
        animals.add("frog");
        animals.add("dog");
        animals.add("cat");

        Collections.sort(animals, new myLengthComparator());// sort - статический метод в классе Collections, который содержит в себе много полезных методов
        System.out.println(animals);

        List <Integer> num = new ArrayList<>();
        num.add(100);
        num.add(2);
        num.add(41);
        num.add(0);

        //использование лямбда-выражения
        Collections.sort(num, ((o1, o2) ->{
            if (o1>o2) return -1;
            else if (o1<o2) return 1;
            else return 0;
        } ));
        //локальный класс, создаем класс-наследник для компаратора в методе
        /*Collections.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2) return -1;
                else if (o1<o2) return 1;
                else return 0;
            }
        });*/
        System.out.println(num);

        List <Person> list = new ArrayList<>();
        list.add(new Person("Liz", 15));
        list.add(new Person("Mia", 10));
        list.add(new Person("Mark", 20));
        //в классе не указана "естественная" сортировка, поэтому без прямого указание
        //способа сортировки метод работать не будет
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge()>o2.getAge()) return -1;
                else if (o1.getAge()<o2.getAge()) return 1;
                else return 0;
            }
        });
        System.out.println(list);
    }
    static class myLengthComparator implements Comparator <String>/*сравнивающий*/{

        @Override
        public int compare(String o1, String o2) {
            /* o1 > o2 => 1 || o1 < o2 => -1 || o1 == o2 => 0 */
            if (o1.length()>o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            else return 0;
        }
    }

    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
