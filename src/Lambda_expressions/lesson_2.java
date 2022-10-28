package Lambda_expressions;

import Collections.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lesson_2 {
    public static void main(String[] args) {
        int[]arr = new int [10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        //for (int i=0;i<10;i++) {
        //    arr[i] *= 2;
        //    list.set(i,list.get(i)*2);
        //}

        //map method
        arr = Arrays.stream(arr).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        //filter method
        arr = Arrays.stream(arr).filter(a -> a%2==0).toArray();
        list = list.stream().filter(a -> a >10).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        //forEach method
        Arrays.stream(arr).forEach(System.out::println);
        list.stream().forEach(a-> System.out.println(a));

        int[]arr1 = new int [10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        //reduce
        //identity -> начальное значение аккумулятора
        //(иначе аккумулятор равен первому значению
        // и иттерации начинаются со второго элемента)
        int s1=Arrays.stream(arr1).reduce(10, (acc,temp)->acc+temp);//.getAsInt();
        int s2 = list1.stream().reduce((acc,temp)->acc*temp).get();

        System.out.println(s1 + "\n" + s2);

        arr1=Arrays.stream(arr1).filter(a->a%2!=0).map(a->a*2).toArray();
        System.out.println(Arrays.toString(arr1));

        //can be used with Set

    }

    private static void fillList(List<Integer> list){
        for (int i=0;i<10;i++)
            list.add(i+1);
    }

    private static void fillArr(int[] arr){
        for (int i=0;i<10;i++)
            arr[i]=i+1;
    }
}

