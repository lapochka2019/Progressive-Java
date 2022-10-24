package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        // Map <Integer,String> hMap = new HashMap<>(); ---> не гарантирует порядок
        // Map <Integer,String> tMap = new TreeMap<>(); ---> сортирует по значению ключа (по умолчанию "естественный порядок")
        // Map <Integer,String> lhMap = new LinkedHashMap<>(); ---> гарантирует исходный порядок (как были добавлены)
        /*Map<Integer,String> map = new HashMap<>();// элементы не имеют порядка
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"three");
        System.out.println(map.toString());
        map.put(3,"Three");
        System.out.println(map.toString());
        for (Map.Entry<Integer,String> entry: map.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
         */
        System.out.println("HashMap:");
        testMaps(new HashMap<>());
        System.out.println("TreeMap:");
        testMaps(new TreeMap<>());
        System.out.println("LinkedHashMap:");
        testMaps(new LinkedHashMap<>());
    }
    public static void testMaps(Map<Integer,String> map){
        map.put(25, "Ann");
        map.put(14,"Joe");
        map.put(87, "Mark");
        map.put(36, "Lis");
        map.put(40,"Jorg");
        map.put(5, "Tim");
        for (Map.Entry<Integer,String> entry: map.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }
}
