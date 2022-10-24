package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Iterable_ {
    public static void main(String[] args) {
        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(21);

        // Java 5+
        for (int i: list){
            //мф не можем удалять элементы во время работы
            System.out.println(i);
        }

        Iterator <Integer> iterator = list.iterator();
        int i =0;
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //можем удалить элемент во время работы
            if (i==2) iterator.remove();
            i++;

        }
    }
}
