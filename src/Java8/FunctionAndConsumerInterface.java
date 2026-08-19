package Java8;

import Generics.Comparing.Student;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionAndConsumerInterface {
    public static void main(String[] args) {
//        Function<String, String> function = s -> s.toUpperCase();
//        System.out.println(function.apply("Ishan"));
//        Function<String, String> function1 = s -> s.substring(0,3);
//        System.out.println(function1.apply("Ishan Singh"));
//        Function<List<Student>, List<Student>> function2 = li->{
//          List<Student> result = new ArrayList<>();
//          for(Student s: li){
//              if(function1.apply(s.getName()).equalsIgnoreCase("vip")){
//                  result.add(s);
//              }
//          }
//          return result;
//        };
//        Student s1 = new Student(1, "Vipul");
//        Student s2 = new Student(2, "Vipulav");
//        Student s3 = new Student(3, "Arnav");
//        List<Student> list = Arrays.asList(s1, s2, s3);
//        System.out.println(function2.apply(list));
////        Function<String, String> function3 = function.andThen(function1);
//        System.out.println(function.andThen(function1).apply("ishan"));

//        Consumer
        Consumer<List<Integer>> listConsumer = li->{
            for (Integer i:li){
                System.out.println(i+100);
            }
        };
        Consumer<List<Integer>> listConsumer1 = li->{
            for (Integer i:li){
                System.out.println(i);
            }
        };
        listConsumer.andThen(listConsumer1).accept(Arrays.asList(1,2,3,4));

//        Supplier

        Supplier<String> supplier = ()-> "Ishan";
        System.out.println(supplier.get());



//        All work together
        Predicate<Integer> predicate = val->val%2==0;
        Function<Integer, Integer> function = val-> val*val;
        Consumer<Integer> consumer = val -> System.out.println(val);
        Supplier<Integer> supplier1 = ()-> 4;

        if(predicate.test(supplier1.get())){
            consumer.accept(function.apply(supplier1.get()));
        }

    }

//    private static class Student{
//        int id;
//        String name;
//
//        public Student(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return "Student{" +
//                    "id=" + id +
//                    ", name='" + name + '\'' +
//                    '}';
//        }
//    }
}
