package HW7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainFor5 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new LinkedList<>();

        for (int i = 0; i < 1000; i++){
            intList.add(Integer.valueOf(i));
        }

        for (int i = 0; i < 10000; i++){
            strList.add(Integer.valueOf(i).toString());
        }

        Integer integer = new Integer(1000);
        String string = new String("string");

        long time;

        System.out.println("add, set, get, remove operations respectively for ArrayList of 1000 Integer elements (time in nanoseconds):");

        time = System.nanoTime();
        intList.add(integer);
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        intList.set(999, 6);
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        intList.get(999);
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        intList.remove(999);
        System.out.println(System.nanoTime() - time);

        System.out.println("add, set, get, remove operations respectively for LinkedList of 10000 String elements:");

        time = System.nanoTime();
        strList.add(string);
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        strList.set(999, "6");
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        strList.get(999);
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        strList.remove(999);
        System.out.println(System.nanoTime() - time);

        System.out.println("all indexes are the same in both lists");

    }
}
