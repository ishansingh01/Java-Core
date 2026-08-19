package Java8;

import java.util.Objects;
import java.util.function.Predicate;

public class Predicate1 {

    public static void main(String[] args) {
        Predicate<Integer> predicate1 = x-> x>1;
        Predicate<String> predicate2 = x-> x.toLowerCase().charAt(0)=='i';
        Predicate<String> predicate3 = x-> x.toLowerCase().charAt(4)=='a';
        Predicate<String> and = predicate3.and(predicate2);
        Predicate<String> or = predicate3.or(predicate2);
        System.out.println(or.test("Ishan"));
        System.out.println(predicate1.test(0));
        System.out.println(and.test("Ishan"));
        System.out.println(predicate2.negate().test("Singh"));
        Student student = new Student(101,"Ishan");
        Student student2 = new Student(100,"Singh");
        Predicate<Student> st = x-> x.getId()>1;
        System.out.println(st.test(student));
        Predicate<Object> equality = Predicate.isEqual("Ishan");
        System.out.println(equality.test("Singh"));
    }
    private static class Student{
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
