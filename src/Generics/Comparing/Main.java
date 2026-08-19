package Generics.Comparing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student kunal = new Student(15, 87.57f);
        Student rahul = new Student(5, 99.52f);
        Student arpit = new Student(9, 90.52f);
        Student ishan = new Student(10, 9.52f);
        Student preet = new Student(7, 79.52f);
        Student[] students = {kunal, rahul, arpit, ishan, preet};
        System.out.println(Arrays.toString(students));
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return -(int) (o1.marks-o2.marks);
//            }
//        });
        Arrays.sort(students, (o1, o2) -> -(int) (o1.marks-o2.marks));
        System.out.println(Arrays.toString(students));


//        if (kunal.compareTo(rahul) < 0){
//            System.out.println(kunal.compareTo(rahul));
//            System.out.println("Rahul have more marks than kunal");
//        }
    }
}
