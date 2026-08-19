package Java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Comparator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(19);
        list.add(90);
        list.add(-9);
        list.add(0);
        Collections.sort(list, (a, b)->a-b);
        System.out.println(list);
    }
}
