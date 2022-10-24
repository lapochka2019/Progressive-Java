package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        //List <Integer> arrayList = new ArrayList<>();
        //List <Integer> linkedList = new LinkedList<>();
        System.out.println("ArrayList:");
        measureTime_add(new ArrayList<>());//быстро
        measureTime_get(new ArrayList<>());//быстро
        measureTime_add_reverse(new ArrayList<>());//медленно
        System.out.println("LinkedList:");
        measureTime_add(new LinkedList<>());//медленно
        measureTime_get(new LinkedList<>());//медленно
        measureTime_add_reverse(new LinkedList<>());//быстро
    }
    private static void measureTime_add(List<Integer> list){
        long start = System.currentTimeMillis();
        for (int i=0;i<1000000;i++)
            list.add(i);
        //for arrayList [] -> [0] -> [0][1] ->...
        long end = System.currentTimeMillis();
        System.out.println("Add time:" + (end-start));
    }
    private static void measureTime_get(List<Integer> list){
        for (int i=0;i<100000;i++)
            list.add(i);
        long start = System.currentTimeMillis();
        for (int i=0;i<100000;i++)
            list.get(i);
        long end = System.currentTimeMillis();
        System.out.println("Get time:" + (end-start));
    }
    private static void measureTime_add_reverse(List<Integer> list){
        long start = System.currentTimeMillis();
        for (int i=0;i<100000;i++)
            list.add(0,i);//индекс - место постановки текущего элемента
        // for arrayList [] -> [0] -> ([][0]) [1][0]-> ([][1][0])-> [2][1][0]->...
        // for linkedList (original) head -> [0] -> [1] -> [2]...
        // add(0,3) head -> [3] -> [0] -> [1] -> [2]...
        // step 1: head -> [3] ? [0] -> [1] -> [2]...
        // step 2: [3]->[0] -> [1] -> [2]...
        long end = System.currentTimeMillis();
        System.out.println("Reverse add time:" + (end-start));
    }
}
