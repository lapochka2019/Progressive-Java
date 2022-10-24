package Collections;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        //Set хранит только уникальные элементы
        //Set <String> hSet = new HashSet<>(); // не сохраняет порядка
        //Set <String> tSet = new TreeSet<>(); // сортирует по естественному порядку
        //Set <String> lhSet = new LinkedHashSet<>(); // сохраняет порядок ввода элементов
        // метод contains реализуется при помощи хэширования, что значительно ускоряет поиск
        // полезные операции со множествами
        Set<Integer> set1 = new HashSet<>();
        Set <Integer> set2 = new HashSet<>();
        for (int i=0;i<10;i++)
            set1.add(i);
        for (int i=5;i<15;i++)
            set2.add(i);
        //union - объединение
        Set <Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union set1 & set 2: " + union);
        //intersection - пересечение
        Set <Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection set1 & set 2: " + intersection);
        //difference - разность
        Set <Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference set1 & set 2: " + difference);
    }
}
