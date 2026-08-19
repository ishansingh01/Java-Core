import java.util.Arrays;

public class oops01 {
    public static void main(String[] args) {
    Student[] students = new Student[5];
//        System.out.println(Arrays.toString(students));
//        Student student1;//declare referance variable
//        student1 = new Student();//allocate a Student object
//        student1.rollno = 101;
//        student1.name = "Ishan";
//        student1.marks = 89.9f;
//        System.out.println(student1);
//        System.out.println(student1.rollno);
//        System.out.println(student1.name);
//        System.out.println(student1.marks);
        //constructor need for this
//        Student ishan = new Student();
//        System.out.println(ishan);
//        System.out.println(ishan.rollno);
//        System.out.println(ishan.name);
//        System.out.println(ishan.marks);
//        ishan.changeName("Aujla");
//        ishan.greeting();
//        Student ishan = new Student(13,"Singh", 88.5f);
//        System.out.println(ishan.rollno);
//        System.out.println(ishan.name);
//        System.out.println(ishan.marks);
        A obj;
        for (int i = 0; i<10000; i++){
            obj = new A("New");
        }
    }
}
class A{
    final int num = 10;
    String name;

    public A(String name) {
        this.name = name;
    }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//    }
}
class Student{
    int rollno;
    String name;
    float marks = 90;


    void changeName(String newName){
        name = newName;
    }
    void greeting(){
//        System.out.println("My name is "+ name);
        System.out.println("My name is "+ this.name);
    }
     Student(){
        this(13,"Default",100.0f);
     }
     Student (int rno, String naam, float num){
        rollno = rno;
        name = naam;
        marks = num;
    }
}