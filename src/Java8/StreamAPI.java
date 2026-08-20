package Java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
//        Stream creation


//        List<String> list = Arrays.asList("apple", "banana", "cherry");
//        Stream<String> stream = list.stream();
//
//
//        String[] array ={"apple", "banana", "cherry"};
//        Stream<String> stream1 = Arrays.stream(array);
//
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
//
//        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);//UnaryOperator
//
//        Stream<Integer> limit1 = Stream.generate(() -> (int) Math.random()).limit(5);//supplier

//        Stream operation

        List<Integer> list = Arrays.asList(1, 3, 4, 6, 654, 6, 23, 6, 2, 90, 23, 34, 98);
//        List<Integer> filterList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//        List<Integer> filterList = list.stream().filter(x -> x % 2 == 0).map(x->x/2).distinct().sorted().collect(Collectors.toList());//distinct() remove duplicate value

        List<Integer> filterList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .distinct()
                .sorted((a, b) -> (b - a))
                .limit(4)
                .skip(1)
                .collect(Collectors.toList());

        System.out.println(filterList);

//        List<Integer> mapList = filterList.stream().map(x -> x / 2).collect(Collectors.toList());
//        System.out.println(mapList);

//        List<Integer> integers = Stream.iterate(0, x -> x + 1)
//                .limit(101)
//                .skip(1)
//                .map(x->x/10)
//                .distinct()
//                .sorted()
//                .peek(x-> System.out.println(x))
//                .collect(Collectors.toList());
//        System.out.println(integers);

        Integer i = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .map(x -> x / 20)
                .distinct()
                .peek(x-> System.out.println(x))
                .max((a, b) -> b - a)
                .get();
        System.out.println(i);
    }
}
