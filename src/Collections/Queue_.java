package Collections;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Queue_ {
    public static void main(String[] args) {
    /*Queue <Person> q= new LinkedList<>();// кол-во элементов не ограничено
    q.add(new Person("Ann", 15));
    q.add(new Person("Greg", 20));
    q.add(new Person("Lis", 21));
    q.add(new Person("Joe", 40));
    //An <- Greg <- Lis <- Joe
    */
    Queue <Person> q2= new ArrayBlockingQueue<>(3);//мы можем задать максимальное количество элементов
        System.out.println(q2.offer(new Person("Ann", 15)));
        System.out.println(q2.offer(new Person("Greg", 20)));
        System.out.println(q2.offer(new Person("Lis", 21)));
        System.out.println(q2.offer(new Person("Joe", 40)));
       /** методы **/
    /*при ошибке выбрасывают исключение*/
    //q.add(new Person("Ann", 15)) --> добавляет элемент
    //q.element() --> возвращает первый элемент
    //q.remove() --> удаляет первый элемент
    /*при ошибке возвращают специальное значение*/
    //q.offer(new Person("Ann", 15)) --> добавляет элемент
    //q.peek() --> возвращает первый элемент
    //q.poll() --> возвращает и удаляет первый элемент
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
