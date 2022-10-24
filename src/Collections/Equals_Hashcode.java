package Collections;

import java.util.HashMap;
import java.util.*;


public class Equals_Hashcode {
    public static void main(String[] args) {
        Person p1 = new Person("Liz", 5);
        Person p2 = new Person("Liz", 5);

        Map<Person, Integer> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        map.put(p1,1);
        map.put(p2,2);

        set.add(p1);
        set.add(p2);

        System.out.println(map+ "\n" + set); // --> объекты класса Person одинаковые, но так как нет методов
                                                // Equals и Hashcode сопоставление производится не корректно

        Person2 p_1 = new Person2("Liz", 5);
        Person2 p_2 = new Person2("Liz", 5);

        Map<Person2, Integer> map1 = new HashMap<>();
        Set<Person2> set1 = new HashSet<>();

        map1.put(p_1,1);
        map1.put(p_2,2);

        set1.add(p_1);
        set1.add(p_2);

        System.out.println(map1+ "\n" + set1); //--> работает корректно

    }
    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    static class Person2{
        private String name;

        private int age;

        public Person2(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person2{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            //этот метод работает медленнее
            //и включается в работу, если хэшкод выдает коллизию
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person2 person2 = (Person2) o;
            return age == person2.age && name.equals(person2.name);
        }

        @Override
        public int hashCode() {
            //преобразует любые объекты любой длины в числа определенного размера
            //если числа совпадают, то появляется коллизия
            //этот метод работает быстрее
            return Objects.hash(name, age);
        }
    }
}
