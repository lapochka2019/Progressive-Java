package Collections.Collection_Sorting;

import java.util.*;

public class Comparable_s {
    public static void main(String[] args) {
        List <Person> list = new ArrayList<>();
        Set <Person> set = new TreeSet<>();

        addElements(list);
        addElements(set);

        System.out.println(list);
        System.out.println(set);
    }
    public static void addElements(Collection collection){
        collection.add(new Person("Ann", 15));
        collection.add(new Person("Marin", 5));
        collection.add(new Person("Alise", 23));
        collection.add(new Person("Liz", 78));
        collection.add(new Person("Max", 11));
    }
    static class Person implements Comparable<Person>/*способный быть сравненным*/{
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override//задает сортировку по умолчанию
        public int compareTo(Person o) {
            if (this.age> o.getAge()) return 1;
            else if (this.age< o.getAge()) return -1;
            else return 0;
        }
    }
}
